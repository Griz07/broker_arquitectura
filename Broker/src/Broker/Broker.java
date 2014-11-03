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

    private Socket conexionSocket;
    private ArrayList<Servicio> servicios = new ArrayList();
    private Servicio currentService;
    private int SERVICIOS_REGISTRADOS = 5;

    public Broker(Socket conexionSocket) throws IOException {
        this.conexionSocket = conexionSocket;
        initializeServices();
    }

    public void processRequest(String mensaje) throws IOException {

        int accion = Integer.parseInt(mensaje.substring((mensaje.length() - 1), mensaje.length()));

        System.out.println(accion);
//        EscribirLog.setOut("C:log.txt");
//            EscribirLog.write(Integer.toString(accion));
//            EscribirLog.flush();
        if(verifyService(accion)){
            enviarValidacionMensaje(accion, mensaje);
        }
        
        if(accion == 2 ||  accion == 0){
            enviarValidacionMensaje(accion, mensaje);
        }

    }

    /*
     * outputs the available server instructions
     */
    private void enviarValidacionMensaje(int accion, String mensaje) throws UnknownHostException, IOException {
        
        DataOutputStream outToClient = new DataOutputStream(conexionSocket.getOutputStream());
        

        //Se contacta al servidor
        if (accion == 1) {
            System.out.println("Accion 1");
            EscribirLog.setOut("C:log.txt");
            EscribirLog.write(" Accion 1: Envio de datos al servidor. Estado: Exitoso");
            EscribirLog.flush();
            this.currentService.getClienteTCP().enviarMensaje(mensaje);
        } else {
            
            if( accion == 0){
                ClienteTCP clienteTCP = new ClienteTCP("localhost",5000);
                clienteTCP.enviarMensaje(mensaje);
                EscribirLog.setOut("C:log.txt");
            EscribirLog.write(" Accion 0: Finaliza el envío de datos al servidor. Estado: Exitoso");
            EscribirLog.flush();
            }
            //Se contacta al cliente    
            if (accion == 2) {
                System.out.println("Accion 2");
                EscribirLog.setOut("C:log.txt");
            EscribirLog.write(" Accion 2: Confirma al cliente. Estado: Exitoso");
            EscribirLog.flush();
                ClienteTCP clienteTCP = new ClienteTCP("localhost",1234);
                clienteTCP.enviarMensaje("2");
            } else {
                ClienteTCP clienteTCP = new ClienteTCP("localhost",1234);
                clienteTCP.enviarMensaje(mensaje);
            }
        }
    }

    private void initializeServices() {
        //El servicio 1 se refiere a recibir votos y actualizar la grafica de barras
        for (int i = 0; i < SERVICIOS_REGISTRADOS; i++) {
            Servicio nuevo = new Servicio(1, "localhost", 5000+i);
            servicios.add(nuevo);
        }
    }

    private boolean verifyService(int service){
        
        for(Servicio servicio: servicios){
            if(servicio.getService() == service){
                this.currentService=servicio;
                return true;
            }
        }
        return false;
    }
    
}
