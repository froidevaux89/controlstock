
package CRUDs;

import static JFrames.Clientes.displayClientes;
import static JFrames.Clientes.txtApellidos;
import static JFrames.Clientes.txtContacto;
import static JFrames.Clientes.txtNombres;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import controlstock.Entidades.Clientes;




public class CRUDClientes {
    
    public void Guardar() {
        
               
        String Apellidos = txtApellidos.getText();
        String Nombres = txtNombres.getText();
        String Contacto = txtContacto.getText();
        
               
        Clientes x = new Clientes(Apellidos,Nombres,Contacto);
                
         
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
                
        try{
               session.save(x);
               displayClientes.setText("El cliente ha sido agregado");
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
           }
        
        JOptionPane.showMessageDialog(null, "El cliente fué ingresado");
        session.getTransaction().commit();
        session.close();
        
        
    }
    
    public void Actualizar(){
        
        DefaultTableModel tm = (DefaultTableModel)  JFrames.Clientes.jTableClientes.getModel();
 
        //aca capturo el primer dato de la celda seleccionada 
 
        String dato = String.valueOf(tm.getValueAt( JFrames.Clientes.jTableClientes.getSelectedRow(),0));
        
               
        int id = Integer.parseInt(dato);
        
        
                       
        String apellidos = txtApellidos.getText();
        String nombres = txtNombres.getText();
        String contacto = txtContacto.getText();
        
       
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Clientes x =(Clientes)session.get(Clientes.class,id);
             
        x.setNombres(nombres);
        x.setApellidos(apellidos);
        x.setContacto(contacto);
                
           try{
               session.update(x);
               displayClientes.setText("Los datos del cliente fueron actualizados");
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
           }
 
        session.getTransaction().commit();
        session.close();
        
        JOptionPane.showMessageDialog(null, "La información del cliente fue actualizada");
        
        
    }
    
    public void Borrar(){
      DefaultTableModel tm = (DefaultTableModel)  JFrames.Clientes.jTableClientes.getModel();
 
        //aca capturo el primer dato de la celda seleccionada 
 
      String dato = String.valueOf(tm.getValueAt( JFrames.Clientes.jTableClientes.getSelectedRow(),0));
        
               
      int Id = Integer.parseInt(dato);
               
      Session session=HibernateUtil.getSessionFactory().openSession();
      Transaction tx=session.beginTransaction();
      Clientes x =(Clientes)session.get(Clientes.class,Id);
 
      
      
      int seleccion = JOptionPane.showConfirmDialog(null,
                    "Estás seguro que deseas borrar el cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
     
        if (seleccion == 0){
            try{
               session.delete(x);
               displayClientes.setText("El cliente seleccionado fué borrado");
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ e);
           }
        }
 
      session.getTransaction().commit(); 
      
    }
   
    public void MostrarRegistroClientes(){
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
	
        
        org.hibernate.Query query = session.createQuery("FROM Clientes");
        List<Clientes> clientes = query.list();
        
        
            DefaultTableModel modelo = new DefaultTableModel(){
            
            @Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
                        
            modelo.addColumn("Id");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Nombres");
            modelo.addColumn("Datos de contacto");
                        
            modelo.setRowCount(0);
                 
               
          for (int x = 0; x<clientes.size(); x++){  
            Vector v = new Vector();
            v.add(clientes.get(x).getId());
            v.add(clientes.get(x).getApellidos());
            v.add(clientes.get(x).getNombres());
            v.add(clientes.get(x).getContacto());
            
            modelo.addRow(v);
            
          }
       
        JFrames.Clientes.jTableClientes.setModel(modelo);   
        
          
        
        tx.commit();
        session.close();
    }
    
    public void Mostrar(){
        
              
        DefaultTableModel tm = (DefaultTableModel)  JFrames.Clientes.jTableClientes.getModel();
        //aca capturo el primer dato de la celda seleccionada 
        String dato = String.valueOf(tm.getValueAt( JFrames.Clientes.jTableClientes.getSelectedRow(),0));                       
        int Id = Integer.parseInt(dato);
        
                       
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Clientes x =(Clientes)session.get(Clientes.class,Id);
        
        txtNombres.setText(x.getNombres());
        txtApellidos.setText(x.getApellidos());
        txtContacto.setText(x.getContacto());
        
        
        tx.commit();
        session.close();
        
    }
    
}
