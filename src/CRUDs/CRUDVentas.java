package CRUDs;

/*import static JFrames.Venta.displayVenta;
import static JFrames.Venta.txtCantidad;
import static JFrames.Venta.jComboBoxCerveza;
import static JFrames.Venta.jComboBoxClientes;
import static JFrames.Venta.txtPrecio;*/
import static JFrames.Ventas.displayVenta;
import static JFrames.Ventas.jComboBoxCerveza;
import static JFrames.Ventas.jComboBoxClientes;
import static JFrames.Ventas.txtCantidad;
import static JFrames.Ventas.txtPrecio;
import controlstock.Entidades.Cervezas;
import controlstock.Entidades.Clientes;
import controlstock.Entidades.Transacciones;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDVentas {

    public void MostrarRegistroVentas() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        org.hibernate.Query query = session.createQuery("FROM Transacciones");
        List<Transacciones> transacciones = query.list();

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("Id");
        modelo.addColumn("Cliente");
        modelo.addColumn("Cerveza");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Importe");
        modelo.addColumn("Estado de la venta");

        modelo.setRowCount(0);

        for (int x = 0; x < transacciones.size(); x++) {
            Vector v = new Vector();
            v.add(transacciones.get(x).getId());
            v.add(transacciones.get(x).getCliente());
            v.add(transacciones.get(x).getCerveza());
            v.add(transacciones.get(x).getCantidad());
            v.add(transacciones.get(x).getFecha());
            v.add("$ " + transacciones.get(x).getPrecio());

            if (transacciones.get(x).getEstado() == false) {
                v.add("Pendiente");
            } else {
                v.add("Finalizada");
            }

            modelo.addRow(v);

        }

        JFrames.Ventas.jTableRegistroVentas.setModel(modelo);

        tx.commit();
        session.close();

    }

    public void GenerarComboBox() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        org.hibernate.Query query = session.createQuery("FROM Clientes");

        List<Clientes> clientes = query.list();

        jComboBoxClientes.removeAllItems();

        for (int i = 0; i <= clientes.size() - 1; i++) {

            jComboBoxClientes.addItem(clientes.get(i).getApellidos() + ", " + clientes.get(i).getNombres());

        }

        org.hibernate.Query query1 = session.createQuery("FROM Cervezas");

        List<Cervezas> cervezas = query1.list();

        jComboBoxCerveza.removeAllItems();

        for (int i = 0; i <= cervezas.size() - 1; i++) {

            jComboBoxCerveza.addItem(cervezas.get(i).getDescripcion());

        }

        tx.commit();
        session.close();

    }

    public void IniciarVenta() {
        String cliente = jComboBoxClientes.getSelectedItem().toString();
        String cerveza = jComboBoxCerveza.getSelectedItem().toString();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int precio = cantidad * Integer.parseInt(txtPrecio.getText());
        java.util.Date fecha = new Date();

        Transacciones x = new Transacciones(cliente, cerveza, cantidad, precio, fecha, false);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.save(x);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }

        org.hibernate.Query query1 = session.createQuery("FROM Cervezas");

        List<Cervezas> cervezas = query1.list();

        int id = 0;

        for (int i = 0; i <= cervezas.size() - 1; i++) {
            if (cervezas.get(i).getDescripcion().equals(cerveza)) {
                id = cervezas.get(i).getId();

            }
        }

        Cervezas y = (Cervezas) session.get(Cervezas.class, id);

        int CantidadActual = y.getCantidad();

        y.setCantidad(CantidadActual - cantidad);

        try {
            session.save(y);
            displayVenta.setText("Los datos de la venta han sido cargados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }

        session.getTransaction().commit();
        session.close();

    }

    public void FinalizarVenta() {

        DefaultTableModel tm = (DefaultTableModel) JFrames.Ventas.jTableRegistroVentas.getModel();

        //aca capturo el primer dato de la celda seleccionada 
        String dato = String.valueOf(tm.getValueAt(JFrames.Ventas.jTableRegistroVentas.getSelectedRow(), 0));

        int id = Integer.parseInt(dato);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Transacciones x = (Transacciones) session.get(Transacciones.class, id);

        x.setEstado(true);

        try {
            session.update(x);
            displayVenta.setText("La venta con el Nº de ID: " + id + ",ha finalizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }

        session.getTransaction().commit();
        session.close();

    }

    public void CancelarVenta() {
        DefaultTableModel tm = (DefaultTableModel) JFrames.Ventas.jTableRegistroVentas.getModel();

        //aca capturo el primer dato de la celda seleccionada 
        String dato = String.valueOf(tm.getValueAt(JFrames.Ventas.jTableRegistroVentas.getSelectedRow(), 0));

        int id = Integer.parseInt(dato);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Transacciones x = (Transacciones) session.get(Transacciones.class, id);

        int cantidadVendidas = x.getCantidad();

        org.hibernate.Query query1 = session.createQuery("FROM Cervezas");

        List<Cervezas> cervezas = query1.list();

        boolean referencia = false;

        for (int i = 0; i <= cervezas.size() - 1; i++) {

            if (cervezas.get(i).getDescripcion().equals(x.getCerveza()) && x.getEstado() != true) {

                int ID = cervezas.get(i).getId();

                Cervezas y = (Cervezas) session.get(Cervezas.class, ID);

                int CantidadActual = y.getCantidad();

                y.setCantidad(CantidadActual + cantidadVendidas);

                int seleccion = JOptionPane.showConfirmDialog(null,
                        "Estás seguro que deseas cancelar la venta?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (seleccion == 0) {
                    try {
                        session.delete(x);

                        session.save(y);

                        referencia = true;

                        displayVenta.setText("La venta ha sido cancelada");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
                    }
                }

            }
        }

        if (referencia == false) {
            try {
                session.delete(x);

                displayVenta.setText("La venta ha sido cancelada");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
            }
        }

        session.getTransaction().commit();
        session.close();

    }

    public int MostrarDisponibles() {
        String cerveza = jComboBoxCerveza.getSelectedItem().toString();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        org.hibernate.Query query1 = session.createQuery("FROM Cervezas");

        List<Cervezas> cervezas = query1.list();

        int id = 0;

        for (int i = 0; i <= cervezas.size() - 1; i++) {
            if (cervezas.get(i).getDescripcion().equals(cerveza)) {
                id = cervezas.get(i).getId();

            }
        }

        Cervezas y = (Cervezas) session.get(Cervezas.class, id);

        int CantidadActual = y.getCantidad();

        session.getTransaction().commit();
        session.close();

        return CantidadActual;

    }

}
