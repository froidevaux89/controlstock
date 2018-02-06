package controlstock.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Balance implements Serializable {
  
    
@Id
@Column(name="ID")
@GeneratedValue(strategy=GenerationType.AUTO)
     private int id;
@Column(name="Total_de_gastos")
     private int totalGastos;
@Column(name="Total_de_ingresos")
     private int totalIngresos;
@Column(name="Diferencia")
     private int diferencia;

    public Balance() {
    }

    public Balance(int totalGastos, int totalIngresos, int diferencia) {
        this.totalGastos = totalGastos;
        this.totalIngresos = totalIngresos;
        this.diferencia = diferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalGastos() {
        return totalGastos;
    }

    public void setTotalGastos(int totalGastos) {
        this.totalGastos = totalGastos;
    }

    public int getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(int totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }




    
}
