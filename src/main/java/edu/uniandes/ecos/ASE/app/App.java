/**
 * Clase principal
 *
 * Fecha de creacion: Febrero 14 de 2016
 *
 * @Version 1.0
 * @Author Claudia Marcela Alvarez Ramos
 */
package edu.uniandes.ecos.ASE.app;

import edu.uniandes.ecos.ASE.app.model.Programa;
import edu.uniandes.ecos.ASE.app.view.VistaEstandarConteo;

public class App {

    /**
     * Instancia principal del modelo : Programa
     */
    private Programa programa;
    /**
     * Interfaz grafica principal
     */
    private VistaEstandarConteo vistaEstandarConteo;

    /**
     * Constructor por defecto, se encarga de inicializar las variables de
     * instancia programa e instancia de conteo
     */
    public App() {
        this.programa = new Programa();
        this.vistaEstandarConteo = new VistaEstandarConteo(this.programa);
    }

    /**
     * #Method Obtiene la vista de estandar de conteo
     *
     * @return la vista de estandar de conteo construida y configurada
     */
    public VistaEstandarConteo getCountStandarView() {
        return vistaEstandarConteo;
    }

    /**
     * #Method Obtiene el programa
     *
     * @return el Programa
     */
    public Programa getProgram() {
        return programa;
    }

    /**
     * #Method
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().getCountStandarView().setVisible(true);
            }
        });
    }
}
