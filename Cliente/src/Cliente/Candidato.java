/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;


/**
 *
 * @author user
 */
public class Candidato {
    private final String nombre;
    private final String partidoPolitico;
    private int cantidadDeVotos;
    private int IDCandidato;
    
    public Candidato(String nombre, String partidoPolitico, int num) {
        this.nombre = nombre;
        this.partidoPolitico = partidoPolitico;
        cantidadDeVotos = 0;
        this.IDCandidato = num;
    }

    public int getCantidadDeVotos() {
        return cantidadDeVotos;
    }

    public void setCantidadDeVotos(int candidadDeVotos) {
        this.cantidadDeVotos = candidadDeVotos;
    }

    public String getNombre() {
        return nombre;
    }


    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    void SumarVotos() {
        this.cantidadDeVotos++;
    }

    
    
    
    
}
