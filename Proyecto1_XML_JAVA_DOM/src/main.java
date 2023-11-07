
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class main {

    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        File fichero=new File("Books.xml");
        MetodosDOMyXML a=new MetodosDOMyXML();
        a.generarDOM(fichero);
        
        //Creamos un libro
        String titulo="titulo de prueba";
        String autor="autor de prueba";
        String id="idprueba"; //este id ya no se utiliza
        String fecha="fecha prueba";
        String descripcion="descripcion de prueba";
        String genero="genero de prueba";
        double precio=1;
        
        //añadimos el id ya que nos lo pide el constructor del libro, pero luego
        //no lo utilizaremos en el método insertarLibroEnDom
        Libro unLibro=new Libro(id,autor,titulo,genero,fecha,descripcion,precio);
        
         while (opcion != 5) {
         
            System.out.println("Bienvenido al gestor de librerías");
            System.out.println("Seleccione una de las siguientes opciones:\n"
                    + "[1] Mostrar todos los libros\n"
                    + "[2] 2Añadir un libro a la librería\n"
                    + "[3] Borrar un libro de la librería\n"
                    + "[4] Guardar el DOM de la librería en un fichero\n"
                    + "[5] Para salir\n"
                    + "Opcion: ");
           opcion = teclado.nextInt();
        
            switch (opcion) {
                case 1 -> a.recorrerYMostrarDOM();
                case 2 -> a.insertarLibroEnDom(unLibro);
                case 3 -> a.borrarNodo(titulo);
                case 4 -> a.guardarFicheroDOM("NuevoFichero.xml");
                case 5 -> System.out.println("EL PROGRAMA HA FINALIZADO");
                default -> System.out.println("\nNo has seleccionado una opcion valida\n");
            }

        }
        
    }
    
}
