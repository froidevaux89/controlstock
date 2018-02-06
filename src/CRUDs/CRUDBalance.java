/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import controlstock.Entidades.Gastos;
import controlstock.Entidades.Transacciones;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Hugo
 */
public class CRUDBalance {
    
    
    public void ObtenerBalance(){
        
        int totalIngresos = 0;
        int totalGastos = 0;
        int diferencia;
        
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        
         
        org.hibernate.Query query = session.createQuery("FROM Transacciones");
                       
        List<Transacciones> transacciones = query.list();
            
        int precio;
            
        for (int i=0;i<=transacciones.size()-1; i++){
            precio = transacciones.get(i).getPrecio();
            totalIngresos = totalIngresos + precio;
              
            
        }
        
        org.hibernate.Query query1 = session.createQuery("FROM Gastos");
                       
        List<Gastos> gastos = query1.list();
            
        int gasto;
            
        for (int i=0;i<=gastos.size()-1; i++){
            gasto = gastos.get(i).getImporte();
            totalGastos = totalGastos + gasto;
              
            
        }
        
        diferencia = totalIngresos - totalGastos;
        
                
        DefaultTableModel modelo = new DefaultTableModel(){
            
            @Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
                        
            modelo.addColumn("Gastos");
            modelo.addColumn("Ingresos");
            modelo.addColumn("Diferencia");
           
            modelo.setRowCount(0);
            
        
            Vector v = new Vector();
            v.add("$ "+totalGastos);
            v.add("$ "+totalIngresos);
            v.add("$ "+diferencia);
            
            
            
            modelo.addRow(v);
            
          
       
        JFrames.Balances.TablaBalance.setModel(modelo); 
        
        
        
        session.close();    
                 
     
        
        
    }
    
    
    
}
