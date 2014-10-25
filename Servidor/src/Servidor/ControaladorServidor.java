/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ControaladorServidor {

    private final ArrayList<Candidato> candidatos;
    private final ContabilizadorDeVotos contabilizadorDeVotos;
    private int cont=0;

    public ControaladorServidor() {
        candidatos = new ArrayList<Candidato>();
        Candidato candidato1 = new Candidato("Maximiliano de Habsburgo", "Conservadores",cont++);
        Candidato candidato2 = new Candidato("Benito Juarez", "Liberales", cont++);
        Candidato candidato3 = new Candidato("Juan Perez", "Izquierda", cont++);
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        candidatos.add(candidato3);
        contabilizadorDeVotos = new ContabilizadorDeVotos(candidatos);
        
    }
    public ArrayList<Candidato> darVotosContabilizados(){
        return contabilizadorDeVotos.getDarVotaciones();
    }

    public void contabilizarVoto(Candidato candidato) {
        contabilizadorDeVotos.contabilizar(candidato);
        
    }

}
