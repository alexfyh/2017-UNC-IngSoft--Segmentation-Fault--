/**
 * Created by YepezHinostroza on 17/6/2017.
 */
import java.util.Date;
public class Biblioteca {
    BibliotecaModel modelo;

    public static void main(String[] args) {
        BibliotecaModel modelo = BibliotecaModel.getUniqueInstance();
        inicializarModelo(modelo);
        Ventana ventana = new Ventana(  modelo);
        Ventana ventana2 = new Ventana(  modelo);


    }

    public static void inicializarModelo(BibliotecaModel modelo){
        try {

            modelo.getAfiliados().addAfiliado("19004246", "Fabrizio", "Perez", "4731541", "Jesus Maria");
            modelo.getAfiliados().addAfiliado("19004247","David", "Lazos","4731542","Cordoba");
            modelo.getAfiliados().addAfiliado("19004248","Cristian", "Mellibosky","4731543","Cordoba");
            modelo.getAfiliados().addAfiliado("93762652","Franz","Yepez","4731540","Martin Garcia");

            EjemplarLibro esdla = new EjemplarLibro("El señor de los anillos I","Tolkien",new Date(50,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro harry = new EjemplarLibro("Harry Potter 8","Rowling",new Date(100,2,29),Categoria.LITERATURA,2,"desconocida");
            EjemplarLibro fisica = new EjemplarLibro("Fisica I","Sears Zemansky",new Date(110,8,15),Categoria.FISICA,7,"Pearson");
            EjemplarRevista user = new EjemplarRevista("Electronica Aplicada ","Users",new Date(117,1,24),Categoria.ELECTRONICA);
            EjemplarAudioVisual video = new EjemplarAudioVisual("Adios Nonino","Astor Piazzolla",new Date(85,2,29),Categoria.MUSICA,2,"Musicor",300);
            EjemplarAudioVisual video2 = new EjemplarAudioVisual("Adios Nonino","Astor Piazzolla",new Date(85,2,29),Categoria.MUSICA,2,"Musicor",300);

            EjemplarLibro esdla2 = new EjemplarLibro("El señor de los anillos II","Tolkien",new Date(51,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla3 = new EjemplarLibro("El señor de los anillos III","Tolkien",new Date(52,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla4 = new EjemplarLibro("El señor de los anillos II","Tolkien",new Date(51,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla5 = new EjemplarLibro("El señor de los anillos III","Tolkien",new Date(52,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla6 = new EjemplarLibro("El señor de los anillos II","Tolkien",new Date(51,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla7 = new EjemplarLibro("El señor de los anillos III","Tolkien",new Date(52,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla8 = new EjemplarLibro("El señor de los anillos II","Tolkien",new Date(51,1,5),Categoria.LITERATURA,1,"desconocida");
            EjemplarLibro esdla9 = new EjemplarLibro("El señor de los anillos III","Tolkien",new Date(52,1,5),Categoria.LITERATURA,1,"desconocida");


            EjemplarTesis tesina = new EjemplarTesis("Procesamiento Digital de Señales estocássticas en canales LIT","Fabri",new Date(118,10,10),Categoria.COMPUTACION);
            EjemplarLibro proakis = new EjemplarLibro("Comunicaciones Digitales con MatLab","Proakis",new Date(100,11,06),Categoria.COMPUTACION,3,"Pearson");
            EjemplarLibro proakis2 = new EjemplarLibro("Comunicaciones Digitales con MatLab","Proakis",new Date(100,11,06),Categoria.COMPUTACION,3,"Pearson");
            EjemplarRevista user2 = new EjemplarRevista("Redes de Computadoras ","Users",new Date(113,3,13),Categoria.COMPUTACION);
            EjemplarRevista user3 = new EjemplarRevista("Redes de Computadoras ","Users",new Date(113,3,13),Categoria.COMPUTACION);
            EjemplarRevista user4 = new EjemplarRevista("Redes de Computadoras ","Users",new Date(113,3,13),Categoria.COMPUTACION);

            EjemplarLibro gui = new EjemplarLibro("Como hacer una GUI decente","Alex YH",new Date(117,6,26),Categoria.COMPUTACION,1,"Brujas");
            EjemplarLibro gui2 = new EjemplarLibro("Como hacer una GUI decente","Alex YH",new Date(117,6,26),Categoria.COMPUTACION,1,"Brujas");
            EjemplarLibro gui3 = new EjemplarLibro("Como hacer una GUI decente","Alex YH",new Date(117,6,26),Categoria.COMPUTACION,1,"Brujas");
            EjemplarLibro gui4 = new EjemplarLibro("Como hacer una GUI decente","Alex YH",new Date(117,6,26),Categoria.COMPUTACION,1,"Brujas");

            modelo.agregarEjemplar(esdla);
            modelo.agregarEjemplar(harry);
            modelo.agregarEjemplar(fisica);
            modelo.agregarEjemplar(user);
            modelo.agregarEjemplar(video);
            modelo.agregarEjemplar(video2);
            modelo.agregarEjemplar(esdla2);
            modelo.agregarEjemplar(esdla3);
            modelo.agregarEjemplar(proakis);
            modelo.agregarEjemplar(proakis2);
            modelo.agregarEjemplar(user2);
            modelo.agregarEjemplar(user3);
            modelo.agregarEjemplar(gui);
            modelo.agregarEjemplar(gui2);
            modelo.agregarEjemplar(gui3);
            modelo.agregarEjemplar(gui4);
            modelo.agregarEjemplar(tesina);
            modelo.agregarEjemplar(esdla4);
            modelo.agregarEjemplar(esdla5);
            modelo.agregarEjemplar(esdla6);
            modelo.agregarEjemplar(esdla7);
            modelo.agregarEjemplar(esdla8);
            modelo.agregarEjemplar(esdla9);




        }
        catch(Exception e){

        }



    }

}
