/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.universidad.vistas;

import Datas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pro.universidad.modelo.*;

/**
 *
 * @author Mauri
 */
public class VistaAlumnosMateria extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private ArrayList<Cursada> listCursadas;
    private ArrayList<Materia> listMaterias;
    private CursadaData cd;
    private MateriaData md;
    private AlumnoData ad;
    private ArrayList<Alumno> listAlumnos;
    private Conexion conexion;
    /**
     * Creates new form VistaAlumnosMateria
     */
    public VistaAlumnosMateria() {
        initComponents();
        try {
            conexion= new Conexion();
            modelo = new DefaultTableModel();
            cd = new CursadaData(conexion);
            listCursadas = (ArrayList)cd.obtenerCursadas();
            md=new MateriaData(conexion);
            listMaterias= (ArrayList)md.obtenerMaterias();
            ad = new AlumnoData(conexion);
            listAlumnos = (ArrayList)ad.obtenerAlumnos();
            
            cargarMaterias();
            armarCTabla();
            cargaDatos();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaAlumnosMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlumnos = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 255));
        jLabel1.setText("LISTADO DE ALUMNOS X MATERIA");

        jLabel2.setText("MATERIA");

        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });

        tAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tAlumnos);

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cbMateria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed
        // TODO add your handling code here:
        cargaDatos();
    }//GEN-LAST:event_cbMateriaActionPerformed

    public void cargarMaterias(){
        for (Materia a : listMaterias){
            
            cbMateria.addItem(a);
        }
    }
    public void armarCTabla(){
        ArrayList<Object> columna= new ArrayList<>();
        columna.add("ID");
        columna.add("Nombre");
        columna.add("Nota");
        
        for( Object it: columna){
            
            modelo.addColumn(it);
        }
        tAlumnos.setModel(modelo);
    }
    public void borrarFilasTabla(){
        
        int a = modelo.getRowCount()-1;
        for ( int i = 0 ; i>=0; i--){
            modelo.removeRow(a);
        }
    }
    public void cargaDatos(){
        borrarFilasTabla();
        Materia mat = (Materia)cbMateria.getSelectedItem();
        for (Cursada c : listCursadas){
            if (c.getMateria().getIdMateria() == mat.getIdMateria() ){
                modelo.addRow(new Object [] {c.getAlumno().getIdAlumno() ,c.getAlumno().getNombre() , c.getNota()} );
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> cbMateria;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAlumnos;
    // End of variables declaration//GEN-END:variables
}
