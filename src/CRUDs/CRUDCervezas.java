package CRUDs;

import static JFrames.Cervezas.display;
import static JFrames.Cervezas.txtCantidad;
import static JFrames.Cervezas.txtCerveza;
import controlstock.Entidades.Cervezas;
import java.awt.HeadlessException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class CRUDCervezas {
    
    public void Guardar(){
        
        String cerveza = txtCerveza.getText();                
        int cantidad = Integer.parseInt(txtCantidad.getText());
                       
        Cervezas x = new Cervezas(cerveza, cantidad);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        try{
            session.save(x);
            display.setText("Los datos han sido cargados");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
        }
        
        
        session.getTransaction().commit();
        session.close();
   
    }
    
    public void Borrar(){
        
            
      DefaultTableModel tm = (DefaultTableModel) JFrames.Cervezas.jTableCervezas.getModel();
 
        //aca capturo el primer dato de la celda seleccionada 
 
      String dato = String.valueOf(tm.getValueAt(JFrames.Cervezas.jTableCervezas.getSelectedRow(),0));
                    
      int Id = Integer.parseInt(dato);
               
      Session session=HibernateUtil.getSessionFactory().openSession();
      Transaction tx=session.beginTransaction();
      Cervezas x =(Cervezas)session.get(Cervezas.class,Id);
 
     
      
     int seleccion = JOptionPane.showConfirmDialog(null,
                    "Estás seguro que deseas borrar la cerveza?", "Confirmación", JOptionPane.YES_NO_OPTION);
     
     if (seleccion == 0){
         try{
            session.delete(x);
            display.setText("El item seleccionado fué borrado");
        }
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
        }
     }
          
 
      session.getTransaction().commit(); 
      session.close();
    }
    
    public void MostrarRegistroCervezas(){
        
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
	
        
        org.hibernate.Query query = session.createQuery("FROM Cervezas");
        List<Cervezas> cerveza= query.list();
        
        
            DefaultTableModel modelo = new DefaultTableModel(){
            
            @Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
                        
            modelo.addColumn("Id");
            modelo.addColumn("Cerveza");
            modelo.addColumn("Cantidad");
            
            
            
            modelo.setRowCount(0);
                 
               
          for (int x = 0; x<cerveza.size(); x++){  
            Vector v = new Vector();
            v.add(cerveza.get(x).getId());
            v.add(cerveza.get(x).getDescripcion());
            v.add(cerveza.get(x).getCantidad());
            
            
            modelo.addRow(v);
            
          }
       
        JFrames.Cervezas.jTableCervezas.setModel(modelo); 
        
        
        tx.commit();
        session.close();
        
    }
    
    public void Actualizar(){
        
        DefaultTableModel tm = (DefaultTableModel) JFrames.Cervezas.jTableCervezas.getModel();
 
        //aca capturo el primer dato de la celda seleccionada 
 
        String dato = String.valueOf(tm.getValueAt(JFrames.Cervezas.jTableCervezas.getSelectedRow(),0));
        
               
        int id = Integer.parseInt(dato);                           
        String cerveza = txtCerveza.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        
       
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Cervezas x =(Cervezas)session.get(Cervezas.class,id);
             
        x.setDescripcion(cerveza);
        x.setCantidad(cantidad);
                
               
        try{
            session.update(x);
            display.setText("Los datos han sido actulizados");
        }
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
        }
        
        session.getTransaction().commit();
        session.close();
        
        
        
        
    }
    
    public void Mostrar(){
              
        
        DefaultTableModel tm = (DefaultTableModel) JFrames.Cervezas.jTableCervezas.getModel();
 
        //aca capturo el primer dato de la celda seleccionada 
 
        String dato = String.valueOf(tm.getValueAt(JFrames.Cervezas.jTableCervezas.getSelectedRow(),0));
        
               
        int Id = Integer.parseInt(dato);
               
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Cervezas x =(Cervezas)session.get(Cervezas.class,Id);
        
        txtCerveza.setText(x.getDescripcion());
        
        
        
        
        tx.commit();
        session.close();
        
    }
    
    
}
