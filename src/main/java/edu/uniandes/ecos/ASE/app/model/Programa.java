/**
 * Esta clase es un modelo de la entidad Programa, que contiene una colección de proxies
 *
 * Fecha de creacion: Febrero 14 de 2016
 *
 * @Version 1.0
 * @Author Claudia Marcela Alvarez Ramos
 */
package edu.uniandes.ecos.ASE.app.model;

import java.io.File;
import java.util.ArrayList;

public class Programa {

    /**
     * Coleccion de proxies
     *
     * @see #getProxies()
     */
    private ArrayList<Proxy> proxies;

    /**
     * Cosntructor por defecto, se encarga de inicializar la coleccion de
     * proxies
     */
    public Programa() {
        proxies = new ArrayList<Proxy>();
    }

    /**
     * #Method adiciona un proxy a la coleccion
     *
     * @author Claudia Marcela Alvarez Ramos
     * @param file archivo del proxy
     * @return retorna el Proxy adicionado
     */
    public Proxy addProxy(File file) {
        Proxy proxy = new Proxy(file);
        proxies.add(proxy);
        return proxy;
    }

    /**
     * #Method adiciona un proxy a la coleccion
     *
     * @author Claudia Marcela Alvarez Ramos
     * @return coleccion de proxies
     */
    public ArrayList<Proxy> getProxies() {
        return proxies;
    }
}
