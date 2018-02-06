
package controlstock.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Gastos implements Serializable {
  
    
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
@Column(name="Importe")
     private int importe;
@Column(name="Fecha")
     private String fecha;

    public Gastos() {
    }

    public Gastos(String descripcion, int importe, String fecha) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.fecha = fecha;
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

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    
}
