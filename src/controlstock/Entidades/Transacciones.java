
package controlstock.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;


@Entity
public class Transacciones implements Serializable {

@Id
@Column(name="ID")
@GeneratedValue(generator = "generador_propietario_hibernate_increment")
@org.hibernate.annotations.GenericGenerator(
            name = "generador_propietario_hibernate_increment",
            strategy = "increment"
            )
     private int id;
@Column(name="Clientes")
     private String cliente;
@Column(name="Cerveza")
     private String cerveza;
@Column(name="Cantidad")
     private int cantidad;
@Column(name="Precio")
     private int precio;
@Column(name="Fecha")
@Temporal(javax.persistence.TemporalType.DATE)
     private Date fecha;
@Column(columnDefinition = "TINYINT")
@Type(type = "org.hibernate.type.NumericBooleanType")
     private boolean estado;

    public Transacciones() {
    }

    public Transacciones(String cliente, String cerveza, int cantidad, int precio, Date fecha, boolean estado) {
        this.cliente = cliente;
        this.cerveza = cerveza;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.estado = estado;
    }
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCerveza() {
        return cerveza;
    }

    public void setCerveza(String cerveza) {
        this.cerveza = cerveza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    

}
