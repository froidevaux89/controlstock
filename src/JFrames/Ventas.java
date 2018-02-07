/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import CRUDs.CRUDBalance;
import CRUDs.CRUDCervezas;
import CRUDs.CRUDVentas;
import Utilidades.ExportarExcel;
import java.awt.Color;
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
public class Ventas extends javax.swing.JPanel {

    /**
     * Creates new form Ventas
     */
    public Ventas() {
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

        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistroVentas = new javax.swing.JTable();
        displayVenta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cerveza = new javax.swing.JLabel();
        jComboBoxCerveza = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        displayDisponibles = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnIniciarVenta = new javax.swing.JButton();
        btnConcluirVenta = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(666, 551));
        setMinimumSize(new java.awt.Dimension(666, 551));
        setPreferredSize(new java.awt.Dimension(666, 551));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExportar.setText("Exportar tabla");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, -1));

        jTableRegistroVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableRegistroVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableRegistroVentasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRegistroVentas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 265, 630, 210));

        displayVenta.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        displayVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(displayVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 630, 17));

        jPanel1.setLayout(new java.awt.GridLayout(5, 3, 15, 25));

        cerveza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cerveza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cerveza.setText("Cerveza:");
        jPanel1.add(cerveza);

        jPanel1.add(jComboBoxCerveza);
        jPanel1.add(jLabel3);

        cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cliente.setText("Cliente:");
        jPanel1.add(cliente);

        jPanel1.add(jComboBoxClientes);
        jPanel1.add(jLabel5);

        cantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cantidad.setText("Cantidad:");
        jPanel1.add(cantidad);

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
        });
        txtCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantidadMouseClicked(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidad);

        displayDisponibles.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(displayDisponibles);

        precio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        precio.setText("Precio unitario:");
        jPanel1.add(precio);

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtPrecio);
        jPanel1.add(jLabel6);

        btnIniciarVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIniciarVenta.setText("Iniciar venta");
        btnIniciarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarVenta);

        btnConcluirVenta.setText("Concluir venta");
        btnConcluirVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnConcluirVenta);

        btnCancelarVenta.setText("Cancelar venta");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarVenta);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 580, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        if (jTableRegistroVentas.getRowCount()==0){
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
            tb.add(jTableRegistroVentas);
            nom.add("Registro de ventas");
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
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnIniciarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarVentaActionPerformed
        CRUDVentas ventas = new CRUDVentas();
        ventas.IniciarVenta();
        ventas.MostrarRegistroVentas();
        
        CRUDCervezas mostrar = new CRUDCervezas();
        mostrar.MostrarRegistroCervezas();

    }//GEN-LAST:event_btnIniciarVentaActionPerformed

    private void jTableRegistroVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRegistroVentasKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            CRUDVentas borrar = new CRUDVentas();
            borrar.CancelarVenta();
            borrar.MostrarRegistroVentas();
            
            CRUDCervezas mostrar = new CRUDCervezas();
            mostrar.MostrarRegistroCervezas();
        }
    }//GEN-LAST:event_jTableRegistroVentasKeyReleased

    private void btnConcluirVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirVentaActionPerformed
        CRUDVentas finalizar = new CRUDVentas();
        finalizar.FinalizarVenta();
        finalizar.MostrarRegistroVentas();
        
        CRUDBalance actualizar = new CRUDBalance();
        actualizar.ObtenerBalance();
           
       
    }//GEN-LAST:event_btnConcluirVentaActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        CRUDVentas cancelar = new CRUDVentas();
        cancelar.CancelarVenta();
        cancelar.MostrarRegistroVentas();
        
        CRUDCervezas mostrar = new CRUDCervezas();
        mostrar.MostrarRegistroCervezas();

    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        CRUDVentas disponibles = new CRUDVentas();
        int Ndisponibles = disponibles.MostrarDisponibles() - Integer.parseInt(txtCantidad.getText());
        String Tdisponibles = Integer.toString(Ndisponibles);
        displayDisponibles.setText("");
        displayDisponibles.setForeground(Color.black);
        displayDisponibles.setText("Disponible: "+ Tdisponibles+" unidades");
        if (Ndisponibles <= 0) {
            displayDisponibles.setForeground(Color.red);
        }
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        
        
        
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadMouseClicked

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        CRUDVentas disponibles = new CRUDVentas();
        displayDisponibles.setText("");
        displayDisponibles.setForeground(Color.black);
        if (txtCantidad.getText().equals("")) {
            displayDisponibles.setText("Ingrese la cantidad");

        } else {
            int Ndisponibles = disponibles.MostrarDisponibles() - Integer.parseInt(txtCantidad.getText());
            String Tdisponibles = Integer.toString(Ndisponibles);
            
            displayDisponibles.setText("Disponible: " + Tdisponibles + " unidades");
            if (Ndisponibles <= 0) {
                displayDisponibles.setForeground(Color.red);

            }

        }   
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnConcluirVenta;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnIniciarVenta;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel cerveza;
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel displayDisponibles;
    public static javax.swing.JLabel displayVenta;
    public static javax.swing.JComboBox<String> jComboBoxCerveza;
    public static javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableRegistroVentas;
    private javax.swing.JLabel precio;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
