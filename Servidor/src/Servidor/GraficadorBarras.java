/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author user
 */
public class GraficadorBarras {

    private JFreeChart grafica;
    private BufferedImage imagen;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    
    /**Su función es crear una gráfica, pero antes debería de haberse insertado los elementos de la gráfica
     @param nombre un <code>String</code> con el nombre que queremos que tengala gráfica     */

    public void graficar(String nombre) {
        grafica = ChartFactory.createBarChart3D(nombre,"Candidatos","Votos", datos,PlotOrientation.VERTICAL, true, true, false);
        imagen = grafica.createBufferedImage(500, 400);
    }

    /**Regresa la grafica resultant
     * @return e*/
    public BufferedImage darGrafica() {
        return imagen;

    }

    public void añadirDato(Dato dato) {
        datos.setValue(dato.getCantidad(),dato.getNombre(),"");

    }

}
