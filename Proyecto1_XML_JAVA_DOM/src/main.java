
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class main {

    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        File fichero=new File("Books.xml");
        MetodosDOMyXML a=new MetodosDOMyXML();
        a.generarDOM(fichero);
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("");
        a.recorrerYMostrarDOM();
        
        
    }
    
}
