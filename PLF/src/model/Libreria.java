package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import model.Libro;
import model.Autor;


public class Libreria {
    private List<Libro> libros;
    private String nombre;
    
    public Libreria(String nom) {
        libros = new ArrayList<>();
        this.nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean agregarLibro(Libro l) {
        libros.add(l);
        return true;
    }
    
    public List<String> obtenerLibros() {
        List<String> nomLibros = libros.stream()
                                .map(libro -> libro.getTitulo())
                                .collect(Collectors.toList());
        return nomLibros;
    }
    
    public List<Autor> getAutores (Genero genero){
        return libros.parallelStream() //mejora el rentimiento, manejarlo de manera paralela
                //.stream() usado anteriormente
                .map(libro -> libro.getAutores())
                .flatMap(autores -> autores.stream())
                .filter(autor -> autor.getGenero() == genero)
                .distinct()
                .collect(Collectors.toList());
    }
    
    public int obteneredadautores(){
        return libros.stream()
                //.map(libro -> libro.getAutores())
                .map(Libro::getAutores)
                .flatMap(autores -> autores.stream())
                .distinct()
                .map(Autor::getEdad)
                .reduce(0, (base, edad) -> base + edad);
    }
    
        public Map<Genero,List<Autor>> getAutoresagrupadorgenero( Genero genero){
        return libros.parallelStream() //mejora el rentimiento, manejarlo de manera paralela
                //.stream() usado anteriormente
                .map(Libro::getAutores)
                .flatMap(List<Autor>::parallelStream)
                .collect(groupingBy(Autor::getGenero));
    }

    /*public int obteneredadautoresrango(){
        return libros.stream()
                //.map(libro -> libro.getAutores())
                .map(Libro::getAutores)
                .flatMap(autores -> autores.stream())
                .distinct()
                .map(Autor::getEdad)
                .reduce(0, (base, edad) -> base + edad);
    }*/
}
