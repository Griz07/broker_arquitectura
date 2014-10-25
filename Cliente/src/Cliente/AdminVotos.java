package Cliente;


import Cliente.Candidato;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a09001540
 */
public class AdminVotos {
    private final static AdminVotos instance= new AdminVotos();
    ArrayList<Candidato> candidatos= new ArrayList();
    private int number=0;
    
    public AdminVotos(){
        Candidato candidato1 = new Candidato("Maximiliano de Habsburgo", "Conservadores",number++);
        Candidato candidato2 = new Candidato("Benito Juarez", "Liberales", number++);
        Candidato candidato3 = new Candidato("Juan Perez", "Izquierda", number++);
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        candidatos.add(candidato3);
    }
    
    /*
    public AdminVotos getAdminVotos(){
        return admin;
    }
     *
     */
    
    public void setVoto(String candidato){
        for(Candidato e: candidatos){
            if(e.getNombre().equals(candidato)){
                e.SumarVotos();
            }
        }
    }
    
    /*
    public void addCandidato(String nombre){
        Candidato nuevo = new Candidato(nombre);
        candidatos.add(nuevo);
    }
    */
    
    public ArrayList<Candidato> getCandidatos(){
        return this.candidatos;
    }
    
    public int getVoto(String candidato){
        int numVotos=0;
        for(Candidato e: candidatos){
            if(e.getNombre() == candidato){
                numVotos = e.getCantidadDeVotos();
            }
        }
        return numVotos;
    }
    
    public ArrayList getNombreCandidatos(){
        ArrayList<String> nombres= new ArrayList();
        for(Candidato e: candidatos){
            nombres.add(e.getNombre());
        }
        
        return nombres;
    }
    
    public static AdminVotos getInstance(){
        return instance;
    }
}
