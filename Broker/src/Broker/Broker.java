package Broker;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Broker {

    private ArrayList<Thread> processors;
    private Socket conexionSocket;
    
    public Broker(Socket conexionSocket) throws IOException{
        this.conexionSocket = conexionSocket;
    }



    public void processRequest(String mensaje) throws IOException {
        
         int accion = Integer.parseInt(mensaje.substring((mensaje.length() - 1), mensaje.length()));
         
         enviarValidacionMensaje(accion, mensaje);
        
    }

    /*
     * outputs the available server instructions
     */

    private void enviarValidacionMensaje(int accion, String mensaje) throws UnknownHostException, IOException {
        System.out.println("Validación 1");
        
        System.out.println("Validación 2");
        DataOutputStream outToClient = new DataOutputStream(conexionSocket.getOutputStream());
        System.out.println("Validación 3");
        if (accion == 1 || accion == 0) {
            System.out.println("Accion 1 y 0");
            ClienteTCP clienteTCP = new ClienteTCP(5000);
            clienteTCP.enviarMensaje(mensaje);
        } else {
                  
        if (accion == 2) {
            System.out.println("Accion 2");
            ClienteTCP clienteTCP = new ClienteTCP(1234);
            clienteTCP.enviarMensaje(mensaje);
        } else {
            ClienteTCP clienteTCP = new ClienteTCP(1234);
            clienteTCP.enviarMensaje(mensaje);
        }
        }
    }

}
