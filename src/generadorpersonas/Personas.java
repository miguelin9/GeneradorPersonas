/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpersonas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@XmlRootElement
public class Personas {

    @XmlElement(name="persona")
    public static List<Persona> personas;
    
    static final String cadenaDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    public Personas() {
        personas = new ArrayList<Persona>();
    }

    public static List<Persona> getPersonas() {
        return personas;
    }

    public static void setPersonas(List<Persona> personas) {
        Personas.personas = personas;
    }

    public void addHombre() {
        Persona aux = new Persona(
                Datos.nombreHombre[generarNumeroRandom(0,Datos.nombreHombre.length-1)],
                Datos.apellidos[generarNumeroRandom(0,Datos.apellidos.length-1)],
                Datos.apellidos[generarNumeroRandom(0,Datos.apellidos.length-1)],
                calcularDNI(),
                "Hombre"
        );
        personas.add(aux);
    }

    public void addMujer() {
        Persona aux = new Persona(
                Datos.nombreMujer[generarNumeroRandom(0,Datos.nombreMujer.length-1)],
                Datos.apellidos[generarNumeroRandom(0,Datos.apellidos.length-1)],
                Datos.apellidos[generarNumeroRandom(0,Datos.apellidos.length-1)],
                calcularDNI(),
                "Mujer"
        );
        personas.add(aux);
    }
    
    public void addPersona(){
        int moneda = generarNumeroRandom(0, 1);
        if (moneda == 1) {
            addHombre();
        }else{
            addMujer();
        }
    }

    public static int generarNumeroRandom(int menor, int mayor) {
        int random = (int) (Math.random() * (mayor - menor + 1)) + menor;

        return random;
    }

    public static String calcularDNI() {
        String nif = "";
        int dni;
        int resto;
        char letra;

        dni = generarNumeroRandom(1_000_000, 99_999_999);
        resto = dni % 23;
        letra = cadenaDNI.charAt(resto);
        nif = String.valueOf(dni) + letra;
        return nif;
    }

}
