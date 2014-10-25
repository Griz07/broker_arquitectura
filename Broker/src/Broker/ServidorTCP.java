/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;


import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ServidorTCP {

        
    private Broker brokerInstance;
    private String mensajeRecibido;
    private final ServerSocket welcomeSocket;
    private Socket conexionSocket;
   
    

    public ServidorTCP() throws IOException {
       welcomeSocket = new ServerSocket(6789);
    }

    public void recibirMensaje() {
        try {
            
            conexionSocket = welcomeSocket.accept();
            DataInputStream recibido = new DataInputStream(conexionSocket.getInputStream());
            mensajeRecibido = recibido.readUTF();
            System.out.println("Mensaje Recibido en el broker");
            brokerInstance = new Broker(conexionSocket);
            

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje servidor tcp broker " + excepcion.getMessage());
        }
    }

    

    public void llamarAlServicio() throws FileNotFoundException, IOException {

        brokerInstance.processRequest(mensajeRecibido);
    }
    
     
   

    public static void main(String argv[]) throws Exception {
  
        ServidorTCP servidorTCP = new ServidorTCP();
       


        while (true) {
            servidorTCP.recibirMensaje();
            servidorTCP.llamarAlServicio();
        }
    }
}
