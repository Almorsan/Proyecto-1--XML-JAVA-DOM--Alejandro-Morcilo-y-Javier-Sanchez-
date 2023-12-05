
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
         //Con este m�todo abrimos el archivo xml y generamos el DOM mediante un objeto de tipo File
        //que le pasamos por par�metro. Para ello, usamos las clases DocumentBuilder y DocumentBuilder factory

        
        try {
            System.out.println("Abriendo archivo XML file y generando DOM\n");
            DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true); //con esto, se ignoran comentarios
            dbf.setIgnoringElementContentWhitespace(true); //con esto, se ignoran espacios en blanco
            DocumentBuilder db=dbf.newDocumentBuilder();
            documento=db.parse(fichero); //se parsea el documento
            System.out.println("DOM generado con �xito\n");
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
        //Con este m�todo, recorremos el DOM y mostramos el contenido de cada l�nea.
        //Para ello, usamos las clases Node y NodeList
        String [] datos = new String [7]; //en este array guardamos la informaci�n  de cada libro seg�n el �ndice
        Node nodo =null; 
        Node raiz=documento.getFirstChild(); //obtenemos el nodo ra�z
        NodeList listaNodo=raiz.getChildNodes(); //obtenemos los hijos del nodo ra�z
        
        
        for (int i = 0; i < listaNodo.getLength(); i++) { //recorremos la lista de nodos de tipo libro
            
            nodo=listaNodo.item(i); //guardamos que hay en la posici�n i de la lista 
            
            if(nodo.getNodeType() == Node.ELEMENT_NODE) { //si el nodo es correcto
                
                Node otroNodo = null;
                int contador = 1;

                datos[0] = nodo.getAttributes().item(0).getNodeValue(); //guardamos el valor del atributo en la posici�n cero
                NodeList otraListaNodo = nodo.getChildNodes();
                
                for (int j = 0; j < otraListaNodo.getLength(); j++) { //en este bucle recorremos todos los nodos de un libro 
                    //en concreto y le asignamos valor a los �ndices del array de String (menos al �ndice 0, que es el atributo)
                    
                    otroNodo=otraListaNodo.item(j); //asignamos a ntem el �tem del �ndice de j
                    
                    if (otroNodo.getNodeType() == Node.ELEMENT_NODE) { //si el nodo es correcto
                        
                        datos[contador] = otroNodo.getTextContent();//guardamos el valor del nodo
                        //en la posici�n del array correspondiente al contador.
                        //en la primera �vuelta�, se  guarda el valor en el �ndice 1.
                        
                        contador++;
                        
                    }
                    
                }
                
                 System.out.println("T�tulo: " + datos[2] + "\n");
                 System.out.println("id: " + datos[0] + "\n");
                 System.out.println("Autor: " + datos[1] + "\n");
                 System.out.println("G�nero: " + datos[3] + "\n");
                 System.out.println("Precio: " + datos[4] + "\n");
                 System.out.println("Fecha de publicaci�n: " + datos[5] + "\n");
                 System.out.println("Descripci�n: " + datos[6] + "\n");
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
        //con este m�todo, introducimos un nuevo libro en el DOM mediante un objeto de
        //tipo libro pasado por par�metro
        
        String id = obtenerID(documento);
        
        try {
            System.out.println("A�aiendo al �rbol el siguiente libro: \n");
            System.out.println("T�tulo: " +unLibro.getTitulo()+ "\n");
            System.out.println("id: " + id + "\n");
            System.out.println("Autor: " +unLibro.getAutor() + "\n");
            System.out.println("G�nero: " +unLibro.getGenero() + "\n");
            System.out.println("Precio: " +unLibro.getPrecio() + "\n");
            System.out.println("Fecha de publicaci�n: " +unLibro.getFecha()+ "\n");
            System.out.println("Descripci�n: " + unLibro.getDescripcion() + "\n");
            System.out.println("--------");
            System.out.println("");
            
            
            
             //A�adimos el autor
        Node nodoAutor=documento.createElement("author");
        Node nodoAutor_text=documento.createTextNode(unLibro.getAutor());
        nodoAutor.appendChild(nodoAutor_text);
        
        
        
            //A�adimos el t�tulo 
            
        Node nodoTitulo=documento.createElement("title");
        Node nodoTitulo_text=documento.createTextNode(unLibro.getTitulo());
        nodoTitulo.appendChild( nodoTitulo_text);
            
            
            //A�adimos el g�nero
        Node nodoGenero=documento.createElement("genre");
        Node nodoGenero_text=documento.createTextNode(unLibro.getGenero());
        nodoGenero.appendChild(  nodoGenero_text);
            
            
            //A�adimos el precio
            
            //para eso,  parseamos el double del pecio a String
            
            String precio = String.valueOf(unLibro.getPrecio());
        
        Node nodoPrecio=documento.createElement("price");
        Node nodoPrecio_text=documento.createTextNode(precio);
        nodoPrecio.appendChild(  nodoPrecio_text);
            
        
       
            //A�adimos la fecha de publicaci�n
            
        Node nodoFecha=documento.createElement("publish_date");
        Node nodoFecha_text=documento.createTextNode(unLibro.getFecha());
        nodoFecha.appendChild(  nodoFecha_text);
            
            
            //A�adimos la descripci�n
            
        Node nodoDescripcion=documento.createElement("publish_date");
        Node nodoDescripcion_text=documento.createTextNode(unLibro.getDescripcion());
        nodoDescripcion.appendChild(  nodoDescripcion_text);
            
            
            //A�adimos el libro con el atributo id
            
          Node nodoLibro=documento.createElement("book");
          ((Element)nodoLibro).setAttribute("id",id);
          nodoLibro.appendChild(nodoAutor);
          nodoLibro.appendChild(nodoTitulo);
          nodoLibro.appendChild(nodoGenero);
          nodoLibro.appendChild(nodoPrecio);
          nodoLibro.appendChild(nodoFecha);
          nodoLibro.appendChild(nodoDescripcion);
          nodoLibro.appendChild(documento.createTextNode("\n"));
          Node raiz=documento.getFirstChild();
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
        //con este m�todo, borramos un nodo (libro) mediante un t�tulo pasado como par�metro
        System.out.println("Se proceder� a borrar el siguiente libro :"+titulo);
        
        try{
            Node raiz=documento.getDocumentElement();
            NodeList listaNodo=documento.getElementsByTagName("title"); //creamos un NodeList  con todos los t�tulos 
            Node nodo;
            
            
            
            for (int i = 0; i < listaNodo.getLength(); i++) { //recorremos el NodeList de t�tulos 
                
                nodo=listaNodo.item(i); //asignamos al nodo el valor de la posici�n i
                
                if(nodo.getNodeType()==Node.ELEMENT_NODE) { //si es un nodo v�lido
                    if(nodo.getChildNodes().item(0).getNodeValue().equals(titulo)) {  //si el t�tulo pasado por par�metro
                        //coincide con el de la posici�n i
                        System.out.println("Borrando el nodo <book> con t�tulo: "+titulo);
                        nodo.getParentNode().getParentNode().removeChild(nodo.getParentNode()); //borramos el nodo
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
         //con este m�todo, guardamos el dom como un archivo xml
        //mediante un String pasado por par�metro que se corresponde con el nombre y extensi�n de dicho
        //archivo (por ejemplo, "LibrosDeDom.xml").
        //utilizaremos las clases Source, StreamResult y Transformer.
        
        try {
            Source src = new DOMSource(documento); // Definimos el origen
            StreamResult rst = new StreamResult(new File(nombreArchivo));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            
            //Opcion para indentar el archivo
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            transformer.transform(src, (javax.xml.transform.Result)rst); //se crea el archivo xml
            System.out.println("\n SE HA CREADO EL FICHERO "+nombreArchivo+" CON LA ESTRUCTURA DEL DOM\n");
            
        } catch (IllegalArgumentException | TransformerException e) {
            System.out.println(e);
        }
    }
    
    //Crear id Autoincremental
    String obtenerID (Document doc) {
        
        NodeList nodeList = doc.getElementsByTagName("book");
        
        int ultimaPos = nodeList.getLength()-1;
        
        //Cogemos el ultimo nodo del DOM
        Node nodo = nodeList.item(ultimaPos);
        
        //Debemos castear a Element para usar el m�todo getAttribute
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
