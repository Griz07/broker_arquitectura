/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;


import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ServidorTCP {

    private String mensajeRecibido;
    private final ProxyServidor proxyServidor;
    private final ServerSocket welcomeSocket;
        private boolean validarMensaje;

    public ServidorTCP() throws IOException {
        proxyServidor = new ProxyServidor();
        welcomeSocket = new ServerSocket(5000);
    }

    public void recibirMensaje() {
        try {
           
            Socket conexionSocket = welcomeSocket.accept();
            DataInputStream recibido = new DataInputStream(conexionSocket.getInputStream());
            mensajeRecibido = recibido.readUTF();
            
//            processRequest(accion, mensajeRecibido);
            System.out.println("Mensaje Recibido");
            EscribirLog.setOut("C:log.txt");
            EscribirLog.write("Mensaje recibido. Estado: Exitoso");
            EscribirLog.flush();
        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje tcp servidor en servidor" + excepcion.getMessage());
        }
    }
    
    public void mandarValidacionServicio(){
        
        
    }
    
    public void llamarAlServicio() throws FileNotFoundException, IOException {
        //revisar si va aquí proxyServidor
        proxyServidor.recibirMensaje(mensajeRecibido);

    }

    public static void main(String argv[]) throws Exception {
        ServidorTCP servidorTCP = new ServidorTCP();
       


        while (true) {
            servidorTCP.recibirMensaje();
            servidorTCP.llamarAlServicio();

        }
    }
}
