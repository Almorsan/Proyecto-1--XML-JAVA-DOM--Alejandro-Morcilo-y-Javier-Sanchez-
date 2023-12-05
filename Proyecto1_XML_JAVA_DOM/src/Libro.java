//usamos esta clase para, de forma cómoda, insertar un nuevo libro en el DOM

public class Libro {
    
    String id, autor, titulo, genero, fecha, descripcion;
    double precio;

    public Libro(String id, String autor, String titulo, String genero, String fecha, String descripcion, double precio) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

    
    
}
