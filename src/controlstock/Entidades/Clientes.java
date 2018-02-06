
package controlstock.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Clientes implements Serializable {

@Id
@Column(name="ID")
@GeneratedValue(generator = "generador_propietario_hibernate_increment")
@org.hibernate.annotations.GenericGenerator(
            name = "generador_propietario_hibernate_increment",
            strategy = "increment"
            )
     private int id;
@Column(name="Apellidos")
     private String apellidos;
@Column(name="Nombres")
     private String nombres;
@Column(name="Contacto")
     private String contacto;

    public Clientes() {
    }

    public Clientes(String apellidos, String nombres, String contacto) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }




}
