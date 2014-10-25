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
public class ContabilizadorDeVotos {
    private final ArrayList<Candidato> candidatos;

    public ContabilizadorDeVotos(ArrayList<Candidato> candidatos) {

        this.candidatos = candidatos;
        
    }
    
    
    public void contabilizar(Candidato candidato) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNombre().equals(candidato.getNombre())) {
                candidatos.get(i).setCantidadDeVotos(candidato.getCantidadDeVotos());
            }
        }
    }
    public ArrayList<Candidato> getDarVotaciones(){
        return candidatos;
    }



    
    }
    

