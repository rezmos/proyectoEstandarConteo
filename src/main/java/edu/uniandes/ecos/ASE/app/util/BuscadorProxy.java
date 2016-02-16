/**
 * Esta clase es una libreria de archivos, en donde se encuentran sus principales funciones:
 * encontrarProxies y contar los items y el total del tamaño del proxy
 *
 * Fecha de creacion: Febrero 14 de 2016
 *
 * @Version 1.0
 * @Author Claudia Marcela Alvarez Ramos
 */
package edu.uniandes.ecos.ASE.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class BuscadorProxy {

    /**
     * #Method Cuenta la cantidad total de lineas de código y su cantidad total
     * de métodos según mi estandar de conteo por archivo
     *
     * @author Claudia Marcela Alvarez Ramos
     * @param file archivo proxy
     * @return arreglo de enteros ([0] totalProxySize, [1] totalItems)
     */
    public static int[] contarItemsYTotalTamanioProxy(File file) {
        int[] countArray = new int[2];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        if (!(line.startsWith("package") || line.startsWith("import"))) {
                            countArray[0]++;
                            if (line.contains("#Method")) {
                                countArray[1]++;
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {

            } finally {
                reader.close();
                if (file.getName().equalsIgnoreCase("BuscadorProxy.java")) {
                                    countArray[1]--;
                }
            }
        } catch (IOException ex) {

        }
        return countArray;
    }

    /**
     * #Method Encuentra todos los proxies en los subdirectorios de un
     * directorio
     *
     * @author Claudia Marcela Alvarez Ramos
     * @param directory directorio raiz
     * @return una coleccion de archivos (Proxy)
     */
    public static ArrayList<File> encontrarProxies(File directory) {
        ArrayList<File> results = new ArrayList<File>();
        Stack<File> subFolders = new Stack<File>();
        File currentFolder = directory;
        while (currentFolder != null && currentFolder.isDirectory() && currentFolder.canRead()) {
            File[] fs = null;
            try {
                fs = currentFolder.listFiles();
            } catch (SecurityException e) {
            }
            if (fs != null && fs.length > 0) {
                for (File f : fs) {
                    if (!f.isDirectory()) {
                        if (f.getName().toLowerCase().endsWith(".java")) {
                            results.add(f);
                        }
                    } else {
                        subFolders.push(f);
                    }
                }
            }
            if (!subFolders.isEmpty()) {
                currentFolder = subFolders.pop();
            } else {
                currentFolder = null;
            }
        }
        return results;
    }
}
