/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author usuario
 */
public class pokeSonido extends Thread {
    
    public void ReproducirSonido(String fichero) {
        AudioClip sonido;
        URL url;
        try {
            url = new URL("file:" + fichero);
            sonido = java.applet.Applet.newAudioClip(url);
            sonido.play();
            Thread.sleep(3000);
            sonido.loop();
            sonido.stop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
