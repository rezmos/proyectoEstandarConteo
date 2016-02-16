/**
 * Esta clase es un modelo de la entidad Proxy, que tiene un nombre, un total de items, un tamano total del proxy
 *
 * Fecha de creacion: Febrero 14 de 2016
 *
 * @Version 1.0
 * @Author Claudia Marcela Alvarez Ramos
 */
package edu.uniandes.ecos.ASE.app.model;

import edu.uniandes.ecos.ASE.app.util.BuscadorProxy;
import java.io.File;

public class Proxy {

    /**
     * Cantidad total de lineas de código según mi estandar de conteo
     */
    private int totalProxySize;
    /**
     * Cantidad total de métodos por proxy
     */
    private int totalItems;
    /**
     * Archivo del proxy
     */
    private File file;

    /**
     * Constructor principal clase Proxy, recibe como parametro el archivo del
     * proxy y en el mismo se encarga de contar la cantidad total de lineas de
     * código según mi estandar de conteo y la cantidad total de métodos por
     * proxy
     *
     * @param file
     */
    public Proxy(File file) {
        this.file = file;
        countingProxyTotalSize();
    }

    /**
     * #Method se encarga de contar y asignar los valores del tamaño total del
     * proxy y la cantidad de items en sus variables respectivas
     *
     * @author Claudia Marcela Alvarez Ramos
     */
    public void countingProxyTotalSize() {
        int[] countArray = BuscadorProxy.contarItemsYTotalTamanioProxy(file);
        if (countArray != null) {
            this.totalProxySize = countArray[0];
            this.totalItems = countArray[1];
        }
    }

    /**
     * #Method Obtiene la cantidad total de lineas de código según mi estandar
     * de conteo
     *
     * @author Claudia Marcela Alvarez Ramos
     * @return Cantidad total de lineas de código según mi estandar de conteo
     */
    public int getTotalProxySize() {
        return totalProxySize;
    }

    /**
     * #Method Cambia la cantidad total de lineas de código por una cantidad
     * nueva
     *
     * @param totalProxySize Cantidad total de lineas de código nuevas según mi
     * estandar de conteo
     */
    public void setTotalProxySize(int totalProxySize) {
        this.totalProxySize = totalProxySize;
    }

    /**
     * #Method Obtiene la cantidad total de métodos por proxy
     *
     * @author Claudia Marcela Alvarez Ramos
     * @return la cantidad total de métodos por proxy
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * #Method Cambia la cantidad total de métodos por proxy por una cantidad
     * nueva
     *
     * @param totalItems cantidad total de métodos nueva por proxy
     */
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * #Method Obtener el archivo del proxy
     *
     * @author Claudia Marcela Alvarez Ramos
     * @return archivo del proxy
     */
    public File getFile() {
        return file;
    }

    /**
     * #Method Cambiar el archivo del proxy por uno nuevo
     *
     * @param file archivo del proxy
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * #Method Retorna un String con la informacion del proxy (ProxyName, Total
     * Items, Tamaño total proxy
     *
     * @author Claudia Marcela Alvarez Ramos
     * @return un String con la informacion del proxy
     */
    @Override
    public String toString() {
        return "Proxy Name:" + this.file.getName() + " - Total Items ( " + this.totalItems + " ) - Tamaño total proxy ( " + this.totalProxySize + " ) ";
    }

}
