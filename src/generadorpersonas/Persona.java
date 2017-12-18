/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpersonas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Miguel
 */
public class Persona {
    
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String dni;
    private String sexo;

    public Persona() {
    }

    public Persona(String nombre, String pApellido, String sApellido, String dni, String sexo) {
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", pApellido=" + pApellido + ", sApellido=" + sApellido + ", dni=" + dni + ", sexo=" + sexo + '}';
    }

}
