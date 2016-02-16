/**
 * Esta clase es el formulario del estandar de conteo, se divide en tres secciones.
 * 1. En La primera seccion se brindan varios componentes para seleccionar la carpeta raiz del proyecto.
 * 2. En la segunda seccion se muestra un panel con informacion de COMO utilizar la aplicacion
 * 3. En la tercera seccion se muestra un reporte de todos los proxys encontrados (Nombre, tamaño total proxy (cantidad total de lineas de codigo, siguiendo estandar de conteo
 *    , cantidad total de items o metodos).
 *
 * Fecha de creacion: Febrero 14 de 2016
 *
 * @Version 1.0
 * @Author Claudia Marcela Alvarez Ramos total:30, Items:2
 */
package edu.uniandes.ecos.ASE.app.view;

import edu.uniandes.ecos.ASE.app.model.Programa;
import edu.uniandes.ecos.ASE.app.model.Proxy;
import edu.uniandes.ecos.ASE.app.util.BuscadorProxy;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class VistaEstandarConteo extends JFrame implements ActionListener {

    private JButton jButtonFind;
    private JLabel jLabelFile;
    private JScrollPane jScrollPaneInfo;
    private JScrollPane jScrollPaneProxies;
    private JTextArea jTextAreaProxies;
    private JTextArea jTextAreaInfo;
    private JTextField jTextFieldPackageName;
    private Programa program;

    /**
     * Crea un nueva vista de estandar de conteo
     */
    public VistaEstandarConteo(Programa program) {
        this.program = program;
        this.initComponents();
    }

    /**
     * #Method Inicializa y configura los componentes graficos
     * 
     * @author Claudia Marcela Alvarez Ramos
     */
    private void initComponents() {

        jLabelFile = new JLabel();
        jTextFieldPackageName = new JTextField();
        jButtonFind = new JButton();
        jButtonFind.addActionListener(this);
        jScrollPaneInfo = new JScrollPane();
        jTextAreaProxies = new JTextArea();
        jScrollPaneProxies = new JScrollPane();
        jTextAreaInfo = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelFile.setText("Carpeta:");

        jTextFieldPackageName.setText(" ");
        jTextFieldPackageName.setEnabled(false);

        jButtonFind.setText("Buscar");

        jTextAreaProxies.setColumns(20);
        jTextAreaProxies.setRows(5);
        jTextAreaProxies.setEnabled(false);
        jScrollPaneProxies.setViewportView(jTextAreaProxies);

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setRows(5);
        jTextAreaInfo.setEnabled(false);
        jTextAreaInfo.setForeground(Color.red);
        jTextAreaInfo.append("\n Recuerde \n 1. Para comenzar seleccione el botón \"Buscar\". \n 2.Si la carpeta ha seleccionar se encuentra dentro de otra carpeta, haga doble click sobre la carpeta contenedora hasta encontrar la carpeta a seleccionar \n 3. Una vez encontrada la carpeta, seleccionela y oprima el botón \" Abrir \" \n ");

        jScrollPaneInfo.setViewportView(jTextAreaInfo);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPaneProxies)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelFile)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldPackageName, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFind))
                                .addComponent(jScrollPaneInfo))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelFile)
                                .addComponent(jTextFieldPackageName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonFind))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneInfo, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneProxies, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        pack();
    }

    /**
     * #Method Se encarga de gestionar el proceso de lectura y conteo de los
     * proxies
     *
     * @author Claudia Marcela Alvarez Ramos
     * @param e name of the action event
     */
    public void actionPerformed(ActionEvent e) {
        int cont = 0;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedPackage = fileChooser.getSelectedFile();
            this.jTextAreaInfo.setText("Directorio: " + selectedPackage.getName() + "\n Archivos: ");
            ArrayList<File> javaFiles = BuscadorProxy.encontrarProxies(selectedPackage);
            for (File javaFile : javaFiles) {
                this.jTextAreaInfo.append(javaFile.getPath() + "\n");
                Proxy proxy = this.program.addProxy(javaFile);
                cont+=proxy.getTotalProxySize();
                this.jTextAreaProxies.append(proxy + "\n");
            }
            this.jTextAreaProxies.append("\n TOTAL: "+cont);
        }
    }
}
