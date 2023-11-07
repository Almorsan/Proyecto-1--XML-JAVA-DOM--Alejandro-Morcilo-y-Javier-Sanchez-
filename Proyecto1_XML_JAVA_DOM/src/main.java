
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class main {

    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        File fichero=new File("Books.xml");
        MetodosDOMyXML a=new MetodosDOMyXML();
        a.generarDOM(fichero);
        a.recorrerYMostrarDOM();
        
        
        
        String titulo="titulo de prueba";
        String autor="autor de prueba";
        String id="idprueba";
        String fecha="fecha prueba";
        String descripcion="descripcion de prueba";
        String genero="genero de prueba";
        double precio=1;
        
        
        Libro unLibro=new Libro(id,autor,titulo,genero,fecha,descripcion,precio);
        
        a.insertarLibroEnDom(unLibro);
        
        System.out.println("");
        a.recorrerYMostrarDOM();
        
        
        System.out.println("");
        a.borrarNodo(titulo);
        
        System.out.println("");
         a.recorrerYMostrarDOM();
        
        
        
        
    }
    
}
