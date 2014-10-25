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
    /**
     * @param args the command line arguments
     */
    
    public ClienteTCP(int puerto ) throws UnknownHostException, IOException{
        this.puerto = puerto;
         
    }
    
    public void enviarMensaje(String mensaje) throws IOException{
        System.out.println("enviado");
        try{
        Socket clientSocket = new Socket("localhost", puerto);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
           
         outToServer.writeUTF(mensaje);
         clientSocket.close();
         
         
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(null, "Mensaje Cliente tcp broker " + excepcion.getMessage());
        }
    }
    


}
