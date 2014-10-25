/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ClienteTCP {

    private String mensajeRecibido;
    private Socket clientSocket;

    /**
     * @param args the command line arguments
     */

    /**
     *
     * @param mensaje
     * @param accion
     * @throws java.io.IOException
     */
    public void enviarMensaje(String mensaje, int accion) throws IOException {
        System.out.println("enviado");
        try {
            clientSocket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeUTF(mensaje + accion);

            System.out.println("Paso");
            clientSocket.close();


        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje Cliente tcp de cliente " + excepcion.getMessage());
        }
    }

    public void enviarfin(){
        try {
            clientSocket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeUTF("0");
            clientSocket.close();


        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje Cliente tcp de cliente" + excepcion.getMessage());
        }
    }


}
