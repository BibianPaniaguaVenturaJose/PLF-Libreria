/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import model.Autor;
import model.Genero;
import model.Libreria;
import model.Libro;
/**
 *
 * @author LMC1
 */
public class PLF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Libreria  libreria = new Libreria("Ocho Libros");
        
        ArrayList<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Craig Larman",70, Genero.HOMBRE));
        Libro libro = new Libro("UML y Patrones", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        
        autor = new ArrayList<>();
        autor.add(new Autor("Maria Jimenes",36, Genero.MUJER));
        libro = new Libro("Saca las frias", autor, "4ta","79834542");
        libreria.agregarLibro(libro);
        
        autor = new ArrayList<>();
        autor.add(new Autor("Jane Austen",100, Genero.MUJER));
        libro = new Libro("Orgullo y Prejuicio", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        
        autor = new ArrayList<>();
        autor.add(new Autor("Pablo Escobar",56, Genero.HOMBRE));
        libro = new Libro("Plata o Plomo", autor, "7ma","1789734251");
        libreria.agregarLibro(libro);
        
        autor = new ArrayList<>();
        autor.add(new Autor("Chabelo",1000, Genero.OTRO));
        libro = new Libro("El camino de la inmortalidad", autor, "10ma","0984734251");
        libreria.agregarLibro(libro);
        
        //Obtener todos los nombres de todos los libros
        List<String> libros = libreria.obtenerLibros();
        System.out.println("Titulos disponibles: " + libros);
        
        System.out.println("Autores mujeres: " + libreria.getAutores(Genero.MUJER));
        System.out.println("Autores hombres: " + libreria.getAutores(Genero.HOMBRE));
        System.out.println("Autores otros: " + libreria.getAutores(Genero.OTRO));
        
        System.out.println("Obtener edad total de autores: " + libreria.obteneredadautores());
        
        System.out.println("Obtener genero de autores " + libreria.getAutoresagrupadorgenero(Genero.MUJER));
        
        int suma = IntStream.range(0, 100).sum();
        System.out.println("Suma del 1 al 100 "+ suma);
        
        //IntStream.iterate(0, valor -> valor + 1)
    }
    
}
