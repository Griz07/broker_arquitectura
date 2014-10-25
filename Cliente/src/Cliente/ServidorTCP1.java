/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ServidorTCP1 {

    private String mensajeRecibido;
    private final ServerSocket welcomeSocket;
    private Socket conexionSocket;
    private final VistaCaptura vistaCaptura;

    public ServidorTCP1() throws IOException {
        welcomeSocket = new ServerSocket(1234);
        vistaCaptura = new VistaCaptura();
        vistaCaptura.setVisible(true);
    }

    public void recibirMensaje() {
        try {

            conexionSocket = welcomeSocket.accept();
            DataInputStream recibido = new DataInputStream(conexionSocket.getInputStream());
            mensajeRecibido = recibido.readUTF();
            System.out.println("Mensaje Recibido en el cliente");
            procesarRespuesta();

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje servidor tcp broker " + excepcion.getMessage());
        }
    }

    public void procesarRespuesta() {
        int accion = Integer.parseInt(mensajeRecibido.substring((mensajeRecibido.length() - 1), mensajeRecibido.length()));
        if (accion == 2) {
            JOptionPane.showMessageDialog(null, "Los votos se han registrado correctamente");
            vistaCaptura.hacerDisponible();
        } else {
            if(accion != 1){
                JOptionPane.showMessageDialog(null, "Hubo un problema");
                vistaCaptura.hacerDisponible();
            }
        }
    }

    public static void main(String argv[]) throws Exception {
        ServidorTCP1 servidorTCP1 = new ServidorTCP1();

        while (true) {
            servidorTCP1.recibirMensaje();
            System.out.println("Llego la peticion");

        }
        
        
    }
}
