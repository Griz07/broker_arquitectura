package Cliente;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ProxyCliente {

    private AdminVotos admin = AdminVotos.getInstance();
    private ArrayList<String> mensajes;

    private final ClienteTCP clientetcp;

    public ProxyCliente() throws UnknownHostException, IOException {

        clientetcp = new ClienteTCP();

    }

    public void recibirMensaje(Candidato candidato) {
        //this.candidato = candidato;

    }

    /**
     * Método que traducirá lo enviado en un xml
     */
    public void empaquetarDatos() {
        mensajes = new ArrayList();
        for (Candidato candidato : admin.getCandidatos()) {
            XStream xStream = new XStream(new DomDriver());
            xStream.alias("candidato", Candidato.class);
            mensajes.add(xStream.toXML(candidato));
            
        }
        
        for(String mensaje : mensajes){
            System.out.println(mensaje);
        }

    }

    /**
     * Método que traducirá lo recibido en una clase
     */
    public void desempaquetarDatos() {

    }

    /**
     * Método que enviará el mensaje al servidor
     *
     *
     * @throws java.io.IOException
     */
    public void enviarMensaje() throws IOException {
        
        for(String mensaje : mensajes){
            //La accion 1 es para enviar los votos
           clientetcp.enviarMensaje(mensaje, 1); 
        }
        
        
        clientetcp.enviarfin();
    }
}
