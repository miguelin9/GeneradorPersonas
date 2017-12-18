/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpersonas;

import java.io.File;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Miguel
 */
public class GeneradorPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Personas array = new Personas();
        Scanner teclado = new Scanner(System.in);

        //Crear personas
        System.out.println("¿Cuantas personas quieres crear?");
        int numeroPersonas;
        do {
            try {
                numeroPersonas = teclado.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Ingresar solo un número entero");
                teclado.nextLine();
            }
        }while(true);

        for (int i = 0; i < numeroPersonas; i++) {
            array.addPersona();
        }
        for (int i = 0; i < numeroPersonas; i++) {
            System.out.println(array.personas.get(i).toString());
        }

        //Generar XML
        try {
            // Instanciamos el contexto, indicando la clase que será el RootElement
            JAXBContext jbc = JAXBContext.newInstance(array.getClass());
            System.out.println("Creado JAXBContext");
            // Creamos un Marshaller, que es la clase capaz de convertir nuestro java bean en una cadena XML
            Marshaller jbcm = jbc.createMarshaller();
            System.out.println("Creado marshaller");
            // Indicamos que vamos a querer el XML con un formato amigable.
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            System.out.println("Asignado propiedades para formato amigable");
            // Hacemos la conversión llamando al método marshall, pasando como instancia del java bean que queremos convertir a XML y un OutputStream donde dará la salida.
            jbcm.marshal(array, new File("personas.xml"));
            System.out.println("creado fichero en el raiz del proyecto con nombre personas.xml");
        } catch (JAXBException ex) {
            System.out.println(ex.getLocalizedMessage() + "jopeta");
        }

    }

}
