/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ClienteTCP {

    private int puerto;
    private String host;

    /**
     * @param args the command line arguments
     */

    public ClienteTCP(String hots, int puerto) throws UnknownHostException, IOException {
        this.host = host;
        this.puerto = puerto;

    }

    public void enviarMensaje(String mensaje) throws IOException {
        System.out.println("enviado");
        EscribirLog.setOut("C:log.txt");
            EscribirLog.write("Enviado");
            EscribirLog.flush();
        try {
            Socket clientSocket = new Socket(host, puerto);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            outToServer.writeUTF(mensaje);
            clientSocket.close();

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje Cliente TCP broker: servicio desactivado");

        }

    }
}
