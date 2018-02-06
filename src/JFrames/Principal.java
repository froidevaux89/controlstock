package JFrames;

import CRUDs.CRUDBalance;
import CRUDs.CRUDCervezas;
import CRUDs.CRUDClientes;
import CRUDs.CRUDGastos;
import CRUDs.CRUDVentas;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Principal extends javax.swing.JFrame {
    
    
    

    public Principal() {
        initComponents();
    }
    
    
    public void mostrarTabs(){
            Ventas t1 = new Ventas();
            CRUDVentas ventas = new CRUDVentas();
            ventas.MostrarRegistroVentas();
            ventas.GenerarComboBox();
            TabPane.addTab("Ventas", t1);
            
            
            Gastos t2 = new Gastos();
            CRUDGastos gastos1 = new CRUDGastos();
            gastos1.MostrarRegistroGastos();
            TabPane.addTab("Gastos", t2);
            
            
            Cervezas t3 = new Cervezas();
            CRUDCervezas mostrarLista = new CRUDCervezas();
            mostrarLista.MostrarRegistroCervezas();
            TabPane.addTab("Cervezas", t3);
            
            Clientes t4 = new Clientes();
            CRUDClientes mostrarListaClientes = new CRUDClientes();
            mostrarListaClientes.MostrarRegistroClientes();
            TabPane.addTab("Clientes", t4);
            
            Balances t5 = new Balances();
            CRUDBalance calculo = new CRUDBalance();
            calculo.ObtenerBalance();
            TabPane.addTab("Balances", t5);
            
            
            
            
            
                        
            TabPane.setSelectedComponent(t1);
            
      }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        TabPanel = new javax.swing.JPanel();
        TabPane = new javax.swing.JTabbedPane();
        BannerPanel = new javax.swing.JLayeredPane();
        ImagenBanner = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deleite - Sistema Basico de Gestion");

        TabPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TabPane.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TabPane.setMinimumSize(new java.awt.Dimension(666, 551));
        TabPane.setPreferredSize(new java.awt.Dimension(666, 600));
        TabPanel.add(TabPane);

        getContentPane().add(TabPanel, java.awt.BorderLayout.CENTER);

        BannerPanel.setBackground(new java.awt.Color(0, 0, 0));
        BannerPanel.setFocusable(false);
        BannerPanel.setMinimumSize(new java.awt.Dimension(688, 130));
        BannerPanel.setOpaque(true);
        BannerPanel.setPreferredSize(new java.awt.Dimension(688, 130));
        BannerPanel.setLayout(new java.awt.FlowLayout());

        ImagenBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagenBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banner1.png"))); // NOI18N
        ImagenBanner.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ImagenBanner.setFocusable(false);
        ImagenBanner.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BannerPanel.add(ImagenBanner);

        getContentPane().add(BannerPanel, java.awt.BorderLayout.NORTH);

        jMenu2.setText("Archivo");

        jMenu3.setText("Configuración");

        jMenu4.setText("Aspecto");

        jMenuItem1.setText("Por Defecto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Mascara Nº2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("Mascara Nº3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenu3.add(jMenu4);

        jMenu7.setText("Conexión");
        jMenu3.add(jMenu7);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Ayuda");
        jMenuBar1.add(jMenu6);

        jMenu5.setText("Créditos");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 689, 843);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            
        try{
            Principal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
                    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try{
            Principal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try{
            Principal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane BannerPanel;
    private javax.swing.JLabel ImagenBanner;
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JPanel TabPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
