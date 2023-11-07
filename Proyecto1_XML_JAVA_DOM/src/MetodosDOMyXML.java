
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("");
            
            
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
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("");
        
    }
    
    
    public int insertarLibroEnDom(Libro unLibro) {
        
        try {
            System.out.println("Añaiendo al árbol el siguiente libro: \n");
            System.out.println("Título: " +unLibro.getTitulo()+ "\n");
            System.out.println("id: " +unLibro.getId() + "\n");
            System.out.println("Autor: " +unLibro.getAutor() + "\n");
            System.out.println("Género: " +unLibro.getGenero() + "\n");
            System.out.println("Precio: " +unLibro.getPrecio() + "\n");
            System.out.println("Fecha de publicación: " +unLibro.getFecha()+ "\n");
            System.out.println("Descripción: " + unLibro.getDescripcion() + "\n");
            System.out.println("--------");
            System.out.println("");
            
            
            
             //Añadimos el autor
        Node nodoAutor=documento.createElement("author");
        Node nodoAutor_text=documento.createTextNode(unLibro.getAutor());
        nodoAutor.appendChild(nodoAutor_text);
        
        
        
            //Añadimos el título 
            
        Node nodoTitulo=documento.createElement("title");
        Node nodoTitulo_text=documento.createTextNode(unLibro.getTitulo());
        nodoTitulo.appendChild( nodoTitulo_text);
            
            
            //Añadimos el género
        Node nodoGenero=documento.createElement("genre");
        Node nodoGenero_text=documento.createTextNode(unLibro.getGenero());
        nodoGenero.appendChild(  nodoGenero_text);
            
            
            //Añadimos el precio
            
            //para eso,  parseamos el double del pecio a String
            
            String precio = String.valueOf(unLibro.getPrecio());
        
        Node nodoPrecio=documento.createElement("price");
        Node nodoPrecio_text=documento.createTextNode(precio);
        nodoPrecio.appendChild(  nodoPrecio_text);
            
        
       
            //Añadimos la fecha de publicación
            
        Node nodoFecha=documento.createElement("publish_date");
        Node nodoFecha_text=documento.createTextNode(unLibro.getFecha());
        nodoFecha.appendChild(  nodoFecha_text);
            
            
            //Añadimos la descipción
            
        Node nodoDescripcion=documento.createElement("publish_date");
        Node nodoDescripcion_text=documento.createTextNode(unLibro.getDescripcion());
        nodoDescripcion.appendChild(  nodoDescripcion_text);
            
            
            //Añadimos el libro con el atributo id
            
          Node nodoLibro=documento.createElement("book");
          ((Element)nodoLibro).setAttribute("id",unLibro.getId());
          nodoLibro.appendChild(nodoAutor);
          nodoLibro.appendChild(nodoTitulo);
          nodoLibro.appendChild(nodoGenero);
          nodoLibro.appendChild(nodoPrecio);
          nodoLibro.appendChild(nodoFecha);
          nodoLibro.appendChild(nodoDescripcion);
          
          
          nodoLibro.appendChild(documento.createTextNode("\n"));
          Node raiz=documento.getFirstChild();//tb. doc.getChildNodes().item(0)
          raiz.appendChild(nodoLibro);
          System.out.println("Libro insertado en DOM.");
          System.out.println("---------------------------------");
          System.out.println("---------------------------------");
          System.out.println("---------------------------------");
          System.out.println("---------------------------------");
          System.out.println("---------------------------------");
          System.out.println("---------------------------------");
          System.out.println("");
        
        
            
            
            
          return 0;  
        } catch (DOMException e) {
            System.out.println("Error, no se ha podido insertar el libro"+e);
            return -1; 
           }
        
        
        
        
    }
    
    
    public int borrarNodo(String titulo) {
        
        System.out.println("Se procederá a borrar el siguiente libro :"+titulo);
        
        try{
            Node raiz=documento.getDocumentElement();
            NodeList listaNodo=documento.getElementsByTagName("title");
            Node nodo;
            
            
            
            for (int i = 0; i < listaNodo.getLength(); i++) {
                
                nodo=listaNodo.item(i);
                
                if(nodo.getNodeType()==Node.ELEMENT_NODE) {
                    if(nodo.getChildNodes().item(0).getNodeValue().equals(titulo)) {
                        System.out.println("Borrando el nodo <book> con título: "+titulo);
                        nodo.getParentNode().getParentNode().removeChild(nodo.getParentNode());
                    }
                }
                
            }
            
            System.out.println("Se ha borrado el nodo correspondiente al libro "+titulo);
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("");
            
            return 0;
        }catch (DOMException e) {
            System.out.println(e);
            e.printStackTrace();
            return -1;
        }
        
    }
    
    void guardarFicheroDOM (String nombreArchivo) {
        
        try {
            Source src = new DOMSource(documento);
            StreamResult rst = new StreamResult(new File(nombreArchivo));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            
            //Opcion para indentar el archivo
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            transformer.transform(src, (javax.xml.transform.Result)rst);
            System.out.println("\n SE HA CREADO EL FICHERO "+nombreArchivo+" CON LA ESTRUCTURA DEL DOM\n");
            
        } catch (IllegalArgumentException | TransformerException e) {
            System.out.println(e);
        }
    }
    
    String obtenerID (Document doc) {
        
        NodeList nodeList = doc.getElementsByTagName("book");
        
        int ultimaPos = nodeList.getLength()-1;
        
        //Cogemos el ultimo nodo del DOM
        Node nodo = nodeList.item(ultimaPos);
        
        //Debemos castear a Element para usar el método getAttribute
        Element element = (Element)nodo;
        
        //obtenemos la cadena de id y cogemos solo el numero
        String aux = element.getAttribute("id");
        String idNodo = aux.substring(2, aux.length());
        
        //Convertimos a numero y sumamos 1
        int nID = Integer.parseInt(idNodo)+1;
        idNodo = "bk"+nID;
        return idNodo;
        
    }
    
}
