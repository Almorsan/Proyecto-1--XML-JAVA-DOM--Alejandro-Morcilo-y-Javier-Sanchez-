
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class MetodosDOMyXML {
    
            Document documento;
    public int generarDOM (File fichero) throws ParserConfigurationException, SAXException, IOException {
        

        
        try {
            System.out.println("Abriendo archivo XML file y generando DOM\n");
            DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);
            DocumentBuilder db=dbf.newDocumentBuilder();
            documento=db.parse(fichero);
            System.out.println("DOM generado con éxito\n");
            
            
            return 0;
             
            
            
            
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        
    }
        
    }
    
    
    public void recorrerYMostrarDOM (){
        String [] datos = new String [7];
        Node nodo =null;
        Node raiz=documento.getFirstChild();
        NodeList listaNodo=raiz.getChildNodes();
        
        
        for (int i = 0; i < listaNodo.getLength(); i++) {
            
            nodo=listaNodo.item(i);
            
            if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                
                Node otroNodo = null;
                int contador = 1;

                datos[0] = nodo.getAttributes().item(0).getNodeValue();
                NodeList otraListaNodo = nodo.getChildNodes();
                
                for (int j = 0; j < otraListaNodo.getLength(); j++) {
                    
                    otroNodo=otraListaNodo.item(j);
                    
                    if (otroNodo.getNodeType() == Node.ELEMENT_NODE) {
                        
                        datos[contador] = otroNodo.getTextContent();
                        
                        contador++;
                        
                    }
                    
                }
                
                 System.out.println("Título: " + datos[2] + "\n");
                 System.out.println("id: " + datos[0] + "\n");
                 System.out.println("Autor: " + datos[1] + "\n");
                 System.out.println("Género: " + datos[3] + "\n");
                 System.out.println("Precio: " + datos[4] + "\n");
                 System.out.println("Fecha de publicación: " + datos[5] + "\n");
                 System.out.println("Descripción: " + datos[6] + "\n");
                 System.out.println("--------");
                 System.out.println("");
            }
            
        }
        
    }
    
    
    
    
    
}
