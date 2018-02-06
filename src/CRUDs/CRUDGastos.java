package CRUDs;

import static JFrames.Gastos.displayGastos;
import static JFrames.Gastos.txtDescripcion;
import static JFrames.Gastos.txtFecha;
import static JFrames.Gastos.txtImporte;
import controlstock.Entidades.Gastos;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class CRUDGastos {
    
    public void Agregar (){
        
        
        String descripcion = txtDescripcion.getText();                
        int importe = Integer.parseInt(txtImporte.getText());
        String fecha = txtFecha.getText();
                       
        Gastos x = new Gastos(descripcion, importe, fecha);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        try{
            session.save(x);
            displayGastos.setText("El gasto ha sido agregado");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
        }
        
        session.getTransaction().commit();
        session.close();
    }
    
    public void Borrar(){
      DefaultTableModel tm = (DefaultTableModel)  JFrames.Gastos.TablaGastos.getModel();
        //aca capturo el primer dato de la celda seleccionada 
      String dato = String.valueOf(tm.getValueAt( JFrames.Gastos.TablaGastos.getSelectedRow(),0));                       
      int Id = Integer.parseInt(dato);
               
      Session session=HibernateUtil.getSessionFactory().openSession();
      Transaction tx=session.beginTransaction();
      Gastos x =(Gastos)session.get(Gastos.class,Id);
 
      session.delete(x);
 
      int seleccion = JOptionPane.showConfirmDialog(null,
                    "Estás seguro que deseas borrar el gasto?", "Confirmación", JOptionPane.YES_NO_OPTION);
     
        if (seleccion == 0){
            try{
               session.delete(x);
               displayGastos.setText("El item seleccionado fué borrado");
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
           }
        }
      
      session.getTransaction().commit(); 
      session.close();
    }
    
    public void MostrarRegistroGastos(){
        
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
	
        
        org.hibernate.Query query = session.createQuery("FROM Gastos");
        List<Gastos> gastos= query.list();
        
        
            DefaultTableModel modelo = new DefaultTableModel(){
            
            @Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
                        
            modelo.addColumn("Id");
            modelo.addColumn("Descripción");
            modelo.addColumn("Importe");
            modelo.addColumn("Fecha");
            
            
            
            modelo.setRowCount(0);
                 
               
          for (int x = 0; x<gastos.size(); x++){  
            Vector v = new Vector();
            v.add(gastos.get(x).getId());
            v.add(gastos.get(x).getDescripcion());
            v.add("$ "+gastos.get(x).getImporte());
            v.add(gastos.get(x).getFecha());
            
            
            modelo.addRow(v);
            
          }
       
        JFrames.Gastos.TablaGastos.setModel(modelo); 
        
        
        tx.commit();
        session.close();
        
    }
    
    public void Actualizar(){
                       
        
        DefaultTableModel tm = (DefaultTableModel)  JFrames.Gastos.TablaGastos.getModel();
        //aca capturo el primer dato de la celda seleccionada 
        String dato = String.valueOf(tm.getValueAt( JFrames.Gastos.TablaGastos.getSelectedRow(),0));                       
        int id = Integer.parseInt(dato);
        
        String descripcion = txtDescripcion.getText();
        int importe = Integer.parseInt(txtImporte.getText());
        
        String fecha = txtFecha.getText();
       
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Gastos x =(Gastos)session.get(Gastos.class,id);
             
        x.setDescripcion(descripcion);
        x.setImporte(importe);
        x.setFecha(fecha);
                
          
        try{
            session.update(x);
            displayGastos.setText("El item seleccionado ha sido actualizado");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
        }
 
        session.getTransaction().commit();
        session.close();
       
    }
    
    public void Mostrar(){
        DefaultTableModel tm = (DefaultTableModel)  JFrames.Gastos.TablaGastos.getModel();
        //aca capturo el primer dato de la celda seleccionada 
        String dato = String.valueOf(tm.getValueAt( JFrames.Gastos.TablaGastos.getSelectedRow(),0));                       
        int Id = Integer.parseInt(dato);
               
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Gastos x =(Gastos)session.get(Gastos.class,Id);
        
        txtDescripcion.setText(x.getDescripcion());
        txtImporte.setText(Integer.toString(x.getImporte()));
        txtFecha.setText(x.getFecha());
                
        tx.commit();
        session.close();
        
    }
    
    
}
