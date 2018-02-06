package controlstock.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Cervezas implements Serializable {
  
    
@Id
@Column(name="ID")
@GeneratedValue(generator = "generador_propietario_hibernate_increment")
@org.hibernate.annotations.GenericGenerator(
            name = "generador_propietario_hibernate_increment",
            strategy = "increment"
            )
     private int id;
@Column(name="Descripcion")
     private String descripcion;
@Column(name="Cantidad")
     private int cantidad;


    public Cervezas() {
    }

    public Cervezas(String descripcion, int cantidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
