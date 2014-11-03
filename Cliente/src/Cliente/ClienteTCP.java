/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ClienteTCP extends Thread {

    private String mensajeRecibido;
    private Socket clientSocket;

    public ClienteTCP(){
        try {
            clientSocket = new Socket("localhost", 6789);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje Cliente tcp de cliente " + ex.getMessage());
        }
    }
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
        
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeUTF(mensaje + accion);

            System.out.println("Paso");
            //clientSocket.close();

    }

    public void enviarfin() {

            DataOutputStream outToServer = null;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeUTF("0");
            //clientSocket.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje Cliente tcp de cliente " + ex.getMessage());
        }

    }

    @Override
    public void run() {

            while(true){
                try {
                    recibirMensaje();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Mensaje servidor tcp broker " + ex.getMessage());
                    break;
                }
            }
    }
    
    public void recibirMensaje() throws Exception{
            DataInputStream recibido = new DataInputStream(clientSocket.getInputStream());
            mensajeRecibido = recibido.readUTF();
            System.out.println("Mensaje Recibido en el cliente");
            procesarRespuesta();
    }
    
        public void procesarRespuesta() {
        int accion = Integer.parseInt(mensajeRecibido.substring((mensajeRecibido.length() - 1), mensajeRecibido.length()));
        if (accion == 2) {
            JOptionPane.showMessageDialog(null, "Los votos se han registrado correctamente");
            //vistaCaptura.hacerDisponible();
        } else {
            if (accion != 1) {
                if (accion != 0) {
                    JOptionPane.showMessageDialog(null, "Hubo un problema");
                    //vistaCaptura.hacerDisponible();
                }
            }
        }
    }
    
}
