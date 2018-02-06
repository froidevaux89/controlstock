/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import CRUDs.CRUDClientes;
import CRUDs.CRUDVentas;
import Utilidades.ExportarExcel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Hugo
 */
public class Clientes extends javax.swing.JPanel {

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayClientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        apellido = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        datosContacto = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(666, 551));
        setMinimumSize(new java.awt.Dimension(666, 551));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(displayClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 228, 20));

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableClientesMousePressed(evt);
            }
        });
        jTableClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 234, 520, 230));

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 15, 25));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombre.setLabelFor(txtNombres);
        nombre.setText("Nombres:");
        jPanel1.add(nombre);
        jPanel1.add(txtNombres);

        apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        apellido.setLabelFor(txtApellidos);
        apellido.setText("Apellidos:");
        jPanel1.add(apellido);
        jPanel1.add(txtContacto);

        datosContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        datosContacto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        datosContacto.setLabelFor(txtContacto);
        datosContacto.setText("Datos de contacto:");
        jPanel1.add(datosContacto);

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 420, 140));

        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 15, 25));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 340, 30));

        jButton1.setText("Exportar tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CRUDClientes actualizar = new CRUDClientes();
        actualizar.Actualizar();
        actualizar.MostrarRegistroClientes();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jTableClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMousePressed
        CRUDClientes mostrar = new CRUDClientes();
        mostrar.Mostrar();
    }//GEN-LAST:event_jTableClientesMousePressed

    private void jTableClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClientesKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN){
            CRUDClientes mostrar = new CRUDClientes();
            mostrar.Mostrar();
        }
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            CRUDClientes borrar = new CRUDClientes();
            borrar.Borrar();
            borrar.MostrarRegistroClientes();
        }
    }//GEN-LAST:event_jTableClientesKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        CRUDClientes agregar = new CRUDClientes();
        agregar.Guardar();
        agregar.MostrarRegistroClientes();
        
        CRUDVentas actualizarComboBox = new CRUDVentas();
        actualizarComboBox.GenerarComboBox();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        CRUDClientes borrar = new CRUDClientes();
        borrar.Borrar();
        borrar.MostrarRegistroClientes();
        
        CRUDVentas actualizarComboBox = new CRUDVentas();
        actualizarComboBox.GenerarComboBox();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTableClientes.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla para ser exportados");
        }

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel","xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar Archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(jTableClientes);
            nom.add("Registro de clientes");
            String file = chooser.getSelectedFile().toString().concat(".xls");

            try{
                ExportarExcel e = new ExportarExcel (new File(file), tb, nom);
                if (e.export()){
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados con éxito");
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Hubo un error");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel datosContacto;
    public static javax.swing.JLabel displayClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableClientes;
    private javax.swing.JLabel nombre;
    public static javax.swing.JTextField txtApellidos;
    public static javax.swing.JTextField txtContacto;
    public static javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}