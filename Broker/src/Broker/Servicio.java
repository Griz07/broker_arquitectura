/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hyuchiha
 */
public class Servicio {
    private int service;
    private String host;
    private int port;
    private ClienteTCP clienteTCP = null;
    
    public Servicio(int service, String host, int port){
        this.service=service;
        this.host=host;
        this.port=port;
        try {
            this.clienteTCP= new ClienteTCP(host,port);
        } catch (IOException ex) {
            System.out.println("Error creando servidor");
        }
    }

    /**
     * @return the service
     */
    public int getService() {
        return service;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @return the clienteTCP
     */
    public ClienteTCP getClienteTCP() {
        return clienteTCP;
    }
    
    
}
