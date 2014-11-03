/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author GrIzZz
 */
public class EscribirLog {

    private static PrintWriter myOutWriter = null;
//variable que define si se debe escribir o no
    private static boolean LOG = true;

    /**
     * Setea un file para realizar la salida
     *     
* @param pNameFile nombre del file.
     */
    public static void setOut(String pNameFile) {
        try {
            myOutWriter = new PrintWriter(new FileWriter(pNameFile, true));
        } catch (IOException io) {
            System.out.println("Error al intentar abrir el archivo" + pNameFile);
            System.exit(0); // @j@ cuando se usa esto!!!!!
        }
    }

    /**
     * Setea un OutputStream para realizar la salida que puede ser la consola
     * por ejemplo.
     *     
* @param pOut
     */
    public static void setOut(OutputStream pOut) {
        myOutWriter = new PrintWriter(pOut);
    }

    /**
     * Logea el string que se pasa como parametro, este proceso lo realiza si la
     * variable LOG esta en true, se le puede anadir el flush en este metodo o
     * utilizar a mano, según se prefiera
     *     
* @param pLine
     */
    public static void write(String pLine) {
        if (LOG) {
            myOutWriter.println(pLine);
//según si se necesetia puede ir esta linea
//flush();
        }
    }

    public static void flush() {
        myOutWriter.flush();
    }

    /**
     * Setea la variable LOG, que indica si se debe escribir o no.
     *     
*/
    public static void close() {
        LOG = false;
    }

    public static void open() {
        LOG = true;
    }

    /**
     * Seteo la salida a un archivo primero, luego escribo dos lineas en este,
     * cambio la salida a la consola y escribo dos lineas en este. Observar que
     * si no utilizamos el flush automatico yo debo indicar a la clase cuando
     * quiero que vacie el buffer.
     *     
* @param args the command line arguments
     */
//    public static void main(String[] args) {
//     
//       EscribirLog.setOut("C:prueba.txt");
////        EscribirLog.setOut("c:\\prueba.txt");
//        EscribirLog.write("Linea uno");
//        EscribirLog.write("Linea dos");
//        EscribirLog.flush();
//        EscribirLog.setOut(System.out);
//        EscribirLog.write("Linea tres");
//        EscribirLog.write("Linea cuatro");
//        EscribirLog.flush();
//    }

}
