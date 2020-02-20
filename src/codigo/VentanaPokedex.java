/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Statement;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;

    Statement estado;
    Connection conexion;
    ResultSet resultadoConsulta;

    String _nombrePokemon;

    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();

//        Color backgroundColor = Color.black;
//       descripcionPokemon.setBorder(BorderFactory.createLineBorder(backgroundColor, 2));
        Color bgColor = Color.BLACK;
        UIDefaults defaults = new UIDefaults();
        defaults.put("TextPane.background", new ColorUIResource(bgColor));
        defaults.put("TextPane[Enabled].backgroundPainter", bgColor);
        descripcionPokemon.putClientProperty("Nimbus.Overrides", defaults);
        descripcionPokemon.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        descripcionPokemon.setBackground(bgColor);
        try {
            imagen1 = ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        buffer1 = (BufferedImage) imagenPokemon.createImage(imagenPokemon.getWidth(), imagenPokemon.getHeight());

        Graphics2D g2 = buffer1.createGraphics();

        dibujaPokemon(contador);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "");
            estado = conexion.createStatement();
            System.out.println("Se ha conectado bien :D");

            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            resultadoConsulta.next();
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            resultadoConsulta.next();
            nombrePokemon.setText(resultadoConsulta.getString(2));
            _nombrePokemon = resultadoConsulta.getString(2);
            numPokedex.setText(" Nº de Pokedex: " + resultadoConsulta.getString(1));
            altura.setText(" Altura: " + resultadoConsulta.getString(3) + " m.");
            peso.setText(" Peso: " + resultadoConsulta.getString(4) + " Kg.");
            if (resultadoConsulta.getString(8) != "") {
                tipo.setText(" Tipo: " + resultadoConsulta.getString(7) + "/" + resultadoConsulta.getString(8));
            } else {
                tipo.setText(" Tipo: " + resultadoConsulta.getString(7));
            }
            habitat.setText(" Habitat: " + resultadoConsulta.getString(6));
            habilidad.setText(" Habilidad"+resultadoConsulta.getString(9));
            especie.setText(" Especie: " + resultadoConsulta.getString(5));
            mov1.setText(resultadoConsulta.getString(10));
            mov2.setText(resultadoConsulta.getString(11));
            mov3.setText(resultadoConsulta.getString(12));
            mov4.setText(resultadoConsulta.getString(13));
            descripcionPokemon.setText(resultadoConsulta.getString(16));

            sonidoPokemon _sonidoPokemon = new sonidoPokemon();
            _sonidoPokemon.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la conexion a la base de datos");
        }
        sonidoFondo s = new sonidoFondo();
        s.start();
    }

    private void dibujaPokemon(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;

        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight());

        g2.drawImage(imagen1, 0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight(), columna * 96, fila * 96, columna * 96 + 96, fila * 96 + 96, null);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight(), null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrePokemon = new java.awt.Label();
        numPokedex = new java.awt.Label();
        altura = new java.awt.Label();
        peso = new java.awt.Label();
        habitat = new java.awt.Label();
        especie = new java.awt.Label();
        habilidad = new java.awt.Label();
        tipo = new java.awt.Label();
        Movimientos = new java.awt.Label();
        shiny = new javax.swing.JCheckBox();
        mov1 = new java.awt.Label();
        mov2 = new java.awt.Label();
        mov3 = new java.awt.Label();
        mov4 = new java.awt.Label();
        descripcionPokemon = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenPokemon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        getContentPane().add(imagenPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 350, 340));

        izq.setText("<");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 60, 30));

        der.setText(">");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        getContentPane().add(der, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 60, 30));

        nombrePokemon.setAlignment(java.awt.Label.CENTER);
        nombrePokemon.setBackground(new java.awt.Color(0, 0, 0));
        nombrePokemon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nombrePokemon.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(nombrePokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 130, 30));

        numPokedex.setAlignment(java.awt.Label.CENTER);
        numPokedex.setBackground(new java.awt.Color(0, 0, 0));
        numPokedex.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        numPokedex.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(numPokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 130, 30));

        altura.setAlignment(java.awt.Label.CENTER);
        altura.setBackground(new java.awt.Color(0, 0, 0));
        altura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        altura.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 130, 30));

        peso.setAlignment(java.awt.Label.CENTER);
        peso.setBackground(new java.awt.Color(0, 0, 0));
        peso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        peso.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 130, 30));

        habitat.setAlignment(java.awt.Label.CENTER);
        habitat.setBackground(new java.awt.Color(0, 0, 0));
        habitat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        habitat.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(habitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 130, 30));

        especie.setAlignment(java.awt.Label.CENTER);
        especie.setBackground(new java.awt.Color(0, 0, 0));
        especie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        especie.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 130, 30));

        habilidad.setAlignment(java.awt.Label.CENTER);
        habilidad.setBackground(new java.awt.Color(0, 0, 0));
        habilidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        habilidad.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(habilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 130, 30));

        tipo.setAlignment(java.awt.Label.CENTER);
        tipo.setBackground(new java.awt.Color(0, 0, 0));
        tipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tipo.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 130, 30));

        Movimientos.setAlignment(java.awt.Label.CENTER);
        Movimientos.setBackground(new java.awt.Color(0, 0, 0));
        Movimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Movimientos.setForeground(new java.awt.Color(102, 255, 0));
        Movimientos.setName(""); // NOI18N
        Movimientos.setText("Movimientos:");
        getContentPane().add(Movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 260, 30));

        shiny.setText("Shiny");
        shiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shinyActionPerformed(evt);
            }
        });
        getContentPane().add(shiny, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        mov1.setAlignment(java.awt.Label.CENTER);
        mov1.setBackground(new java.awt.Color(0, 0, 0));
        mov1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mov1.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(mov1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 130, 30));

        mov2.setAlignment(java.awt.Label.CENTER);
        mov2.setBackground(new java.awt.Color(0, 0, 0));
        mov2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mov2.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(mov2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 130, 30));

        mov3.setAlignment(java.awt.Label.CENTER);
        mov3.setBackground(new java.awt.Color(0, 0, 0));
        mov3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mov3.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(mov3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 130, 30));

        mov4.setAlignment(java.awt.Label.CENTER);
        mov4.setBackground(new java.awt.Color(0, 0, 0));
        mov4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mov4.setForeground(new java.awt.Color(102, 255, 0));
        getContentPane().add(mov4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 130, 30));

        descripcionPokemon.setBorder(null);
        descripcionPokemon.setForeground(new java.awt.Color(51, 255, 0));
        descripcionPokemon.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(descripcionPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 260, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pokedex.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador--;
        if (contador < 0) {
            contador = 0;
        }
        dibujaPokemon(contador);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            if (resultadoConsulta.next()) {
                resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
                resultadoConsulta.next();
                nombrePokemon.setText(resultadoConsulta.getString(2));
                _nombrePokemon = resultadoConsulta.getString(2);
                numPokedex.setText(" Nº de Pokedex: " + resultadoConsulta.getString(1));
                altura.setText(" Altura: " + resultadoConsulta.getString(3) + " m.");
                peso.setText(" Peso: " + resultadoConsulta.getString(4) + " Kg.");
                if (resultadoConsulta.getString(8) != "") {
                    tipo.setText(" Tipo: " + resultadoConsulta.getString(7) + "/" + resultadoConsulta.getString(8));
                } else {
                    tipo.setText(" Tipo: " + resultadoConsulta.getString(7));
                }
                habitat.setText(" Habitat: " + resultadoConsulta.getString(6));
                especie.setText(" Especie: " + resultadoConsulta.getString(5));
                mov1.setText(resultadoConsulta.getString(10));
                mov2.setText(resultadoConsulta.getString(11));
                mov3.setText(resultadoConsulta.getString(12));
                mov4.setText(resultadoConsulta.getString(13));
                descripcionPokemon.setText(resultadoConsulta.getString(16));

                sonidoPokemon _sonidoPokemon = new sonidoPokemon();
                _sonidoPokemon.start();
            } else {
                nombrePokemon.setText("Este pokemon no figura en la pokedex");
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        contador++;
        if (contador >= 150) {
            contador = 150;
        }
        dibujaPokemon(contador);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            if (resultadoConsulta.next()) {
                resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
                resultadoConsulta.next();
                nombrePokemon.setText(resultadoConsulta.getString(2));
                _nombrePokemon = resultadoConsulta.getString(2);
                numPokedex.setText(" Nº de Pokedex: " + resultadoConsulta.getString(1));
                altura.setText(" Altura: " + resultadoConsulta.getString(3) + " m.");
                peso.setText(" Peso: " + resultadoConsulta.getString(4) + " Kg.");
                if (resultadoConsulta.getString(8) != "") {
                    tipo.setText(" Tipo: " + resultadoConsulta.getString(7) + "/" + resultadoConsulta.getString(8));
                } else {
                    tipo.setText(" Tipo: " + resultadoConsulta.getString(7));
                }
                habitat.setText(" Habitat: " + resultadoConsulta.getString(6));
                especie.setText(" Especie: " + resultadoConsulta.getString(5));
                mov1.setText(resultadoConsulta.getString(10));
                mov2.setText(resultadoConsulta.getString(11));
                mov3.setText(resultadoConsulta.getString(12));
                mov4.setText(resultadoConsulta.getString(13));
                descripcionPokemon.setText(resultadoConsulta.getString(16));

                sonidoPokemon s = new sonidoPokemon();
                s.start();
            } else {
                nombrePokemon.setText("Este pokemon no figura en la pokedex.¡Sal a capturarlo!");
            }
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_derActionPerformed

    private void shinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shinyActionPerformed
        if (shiny.isSelected()) {
            try {
                imagen1 = ImageIO.read(getClass().getResource("/imagenes/shinysPokemon.png"));
                dibujaPokemon(contador);
            } catch (IOException ex) {
            }
        } else {
            try {
                imagen1 = ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
                dibujaPokemon(contador);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_shinyActionPerformed
    public class sonidoPokemon extends Thread {//Creamos un hilo para que  												

        public void run() {                     //reproduzca el sonido a la vez
            pokeSonido s = new pokeSonido(); //que sigue el juego
            s.ReproducirSonido(s.getClass().getResource("/sonidos/" + _nombrePokemon + ".wav").getFile(), 3000);
        }
    }

    public class sonidoFondo extends Thread {//Creamos un hilo para que  												

        public void run() {                     //reproduzca el sonido a la vez
            pokeSonido s = new pokeSonido(); //que sigue el juego
            s.ReproducirSonido(s.getClass().getResource("/sonidos/musicaFondo.wav").getFile(), 100000);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Movimientos;
    private java.awt.Label altura;
    private javax.swing.JButton der;
    private javax.swing.JTextPane descripcionPokemon;
    private java.awt.Label especie;
    private java.awt.Label habilidad;
    private java.awt.Label habitat;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label mov1;
    private java.awt.Label mov2;
    private java.awt.Label mov3;
    private java.awt.Label mov4;
    private java.awt.Label nombrePokemon;
    private java.awt.Label numPokedex;
    private java.awt.Label peso;
    private javax.swing.JCheckBox shiny;
    private java.awt.Label tipo;
    // End of variables declaration//GEN-END:variables
}
