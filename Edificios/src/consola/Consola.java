
package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Edificio;

/**
 *
 * @author soxcr
 */
public class Consola {
    /**
     * Método por el cual le mostramos al usuario el menú de opciones
     */
    public void menu(){
        //Creamos el ArrayList  que maneja elementos de la Clase Edificio
        ArrayList <Edificio> bloqueEdificios = new ArrayList<>();
        Scanner pideYmuestra = new Scanner(System.in);
        Consola consola = new Consola();
        int numeroEdificios=0; 
        int confirmacion=0;
        int opcion=0; 
        //Mientras opcion sea distinto de 5, Haz:
        do {
            //Mientras confirmacion sea distinto de 1:
            while(confirmacion!=1){
                System.out.println("Por favor elige una opción: ");
                //Mostramos las opciones
                System.out.println("\t1.Introducir Edificios");
                System.out.println("\t2.Ver edificios");
                System.out.println("\t3.Escribir en Fichero");
                System.out.println("\t4.Leer el Fichero");
                System.out.println("\t5.Salir");
                
                //Guardamos en opcion lo introducido por el usuario
                opcion=pideYmuestra.nextInt();
                //Limpiamos el intro
                pideYmuestra.nextLine();
                
                //Validamos la opción que elija el usuario
                if (opcion==1) {
                    System.out.println("Has elegido la opción 1, Introducir Edificios,¿es correcto?");
                    System.out.println("\t 1.Si");
                    System.out.println("\t 2.No");
                    confirmacion=pideYmuestra.nextInt();
                    pideYmuestra.nextLine();
                }
                else if (opcion==2) {
                    System.out.println("Has elegido la opción 2, Ver Edificios,¿es correcto?");
                    System.out.println("\t 1.Si");
                    System.out.println("\t 2.No");
                    confirmacion=pideYmuestra.nextInt();
                    pideYmuestra.nextLine();
                }            
                else if (opcion==3) {
                    System.out.println("Has elegido la opción 3, Escribir en Fichero,¿es correcto?");
                    System.out.println("\t 1.Si");
                    System.out.println("\t 2.No"); 
                    confirmacion=pideYmuestra.nextInt();
                    pideYmuestra.nextLine();
                 }            
                 else if (opcion==4) {
                    System.out.println("Has elegido la opción 4, Leer Fichero,¿es correcto?");
                    System.out.println("\t 1.Si");
                    System.out.println("\t 2.No");
                    confirmacion=pideYmuestra.nextInt();
                    pideYmuestra.nextLine();                
                }            
                else if (opcion==5) {
                    System.out.println("Has elegido la opción 5, Salir,¿es correcto?");
                    System.out.println("\t 1.Si");
                    System.out.println("\t 2.No");
                    confirmacion=pideYmuestra.nextInt();
                    pideYmuestra.nextLine();
                }
            }//Fin del While
            //Reseteamos confirmacion a 0, para la siquiente vuelta
            confirmacion=0;
            //Teniendo en cuenta el contenido de la variable opcion:
            switch (opcion) {
                case 1:
                    /*Llamamos a las funciones pideNumEdificios para 
                    pedir el número de Edificios que quiere introducir 
                    el usuario, el cual retorna un int, que guardamos en
                    numeroEdificios*/
                    numeroEdificios=pideNumEdificios();
                    /*Llamamaos a la función pideYrellena, que pedirá los
                    datos y los introducirá en el arrayList, y retorna un 
                    ArrayList, que guardaremos en bloqueEdificios*/
                    bloqueEdificios=pideYrellena(numeroEdificios);
                    break;

                case 2:
                    //Si bloqueEdificios, está vacio:
                    if (bloqueEdificios.isEmpty()) {
                        System.out.println("No hay ningun Edificio");
                    }
                    //Si no:
                    else{
                        //Llamamos al método muestraArray
                        muestraArray(bloqueEdificios);
                    }
                    break;

                case 3:
                    //Si bloqueEdificios está vacio:
                    if (bloqueEdificios.isEmpty()){
                        System.out.println("No hay ningun Edificio");
                    }
                    //Si no:
                    else{
                        //Llamamos al método escribeFichero
                        escribeFichero(bloqueEdificios);
                    }
                    break;

                case 4:
                    //Llamamos al método leeFichero
                    leeFichero();
                    break;

                case 5:
                    System.out.println("Hasta lueguito coleguita");
                default:
                    System.out.println("Has introducido una opción que no existe, por favor, selecciona una de las que se muestran.");
            }//Fin del Switch
        //Mientras opcion sea distinto de 5
        } while (opcion!=5);
    }
    /**
     * Método en el cual le pedimos al usuario el número de Edificios
     * que quiere introducir
     * @return Retornamos el entero que nos indica que número de 
     * Edificios quiere introducir
     */
    public int pideNumEdificios(){
        Scanner muestra = new Scanner(System.in);
        int numEdificios=0;
        int confirmacion=0;

        //Mientras confirmacion, sea DISTINTO de 1
        while(confirmacion!=1){
            System.out.print("¿Cuantos edificios quieres introducir? ");
            //Guardamos en numEdificios, el entero que introduzca el usuario
            numEdificios=muestra.nextInt();
            //Limpiamos el intro
            muestra.nextLine();
                
            //Validamos su elección
            System.out.println("Quieres introducir "+numEdificios+" Edificios, ¿es correcto?" );
            System.out.println("\t 1.Si");
            System.out.println("\t 2.No");
            confirmacion=muestra.nextInt();

            muestra.nextLine();
        }//Fin del While
        //Devolvemos el número de edificios que quiere introducir
        return numEdificios;
    }
    /**
     * Método por el cual pedimos los datos de los edificios y los añadimos
     * al ArrayList
     * @param numeroEdififios Número de edificios totales que el usuario quiere
     * introducir
     * @return Retornamos el ArrayList rellenado
     */
    public ArrayList pideYrellena(int numeroEdififios){
        ArrayList <Edificio> setCompleto= new ArrayList<>();
        Scanner muestra = new Scanner(System.in);
        Edificio rellename= null; 
        int confirmacion= 0;
        //Para recorrido 1, Hasta que sea menor o igual a numeroEdificios, Con paso 1 Hacer:
        for(int recorrido = 0; recorrido < numeroEdififios; recorrido++) {
            //Creamos el objeto rellename de Clase Edificio
            rellename= new Edificio();
            //Mientras confirmacion sea distinto de 1
            while(confirmacion!=1){
                System.out.println("¿Cuál es la calle donde se ubica el edificio?");
                //Guardamos los datos que nos introduce el usuario en el atributo calle
                rellename.setCalle(muestra.nextLine());
            
                System.out.println("¿Cúantos pisos tiene el edificio?");
                //Guardamos los datos que nos introduce el usuario en el atributo numPisos
                rellename.setNumPisos(muestra.nextInt());
            
                muestra.nextLine();
            
                System.out.println("¿Cúal es el nombre del Presidente de la Comunidad?");
                //Guardamos los datos que nos introduce el usuario en el atributo nombrePresi
                rellename.setNombrePresi(muestra.nextLine());   
            
                System.out.println("¿Cúantas puertas hay en cada piso?");
                //Guardamos los datos que nos introduce el usuario en el atributo numPuertas
                rellename.setNumPuertas(muestra.nextInt());        
            
                muestra.nextLine();
            
                /*Llamamos al método muestraEdificio, pasandole el objeto de 
                nombre rellename, ya rellenado, para poder verlo*/
                muestraEdificio(rellename);
            
                //Validamos los datos
                System.out.println("¿Estos datos son correctos?");
                System.out.println("\t1.Si");
                System.out.println("\t2.No");
                confirmacion=muestra.nextInt();
                muestra.nextLine();
            }//Fin del While
            confirmacion= 0;
            //Añadimos el objeto al ArrayList
            setCompleto.add(rellename);         
        }//Fin del For
        //Retornamos el ArrayList
        return setCompleto;
    }
    /**
     * Método que muestra el Objeto de clase Edificio
     * @param jajaTengoUnNombreDistinto Objeto de clase Edificio muy
     * hijoputa, por que tiene otro nombre distinto, pero en esencia es el mismo
     * o eso creo ¿Qué nos hace ser nosotros? meh, da igual, me voy a comer
     * un yogurt
     */
    public void muestraEdificio(Edificio jajaTengoUnNombreDistinto){
        System.out.println("Calle: "+jajaTengoUnNombreDistinto.getCalle());
        System.out.println("Número de Pisos: "+ jajaTengoUnNombreDistinto.getNumPisos());
        System.out.println("Nombre del Presidente/a: "+ jajaTengoUnNombreDistinto.getNombrePresi());
        System.out.println("Número de Puertas: "+ jajaTengoUnNombreDistinto.getNumPuertas());
    }
    /**
     * Método por el cual mostramos todo el ArrayList
     * @param bloqueEdificios ArrayList que maneja objetos de tipo Edificio
     */
    public void muestraArray(ArrayList <Edificio> bloqueEdificios){
        //Para recorrido igual a 0, mientras recorrido, sea menor al tamaño total del ArrayList, con paso 1 Hacer:
        for (int recorrido = 0; recorrido < bloqueEdificios.size(); recorrido++) {
            System.out.println("--------------------Edificio numero "+(recorrido+1)+"--------------------");
            //Mostramos los atributos de cada edificio, en la posicion el la que se encuentre(get(recorrido))
            System.out.println("Calle: "+bloqueEdificios.get(recorrido).getCalle());
            System.out.println("Número de Pisos: "+ bloqueEdificios.get(recorrido).getNumPisos());
            System.out.println("Nombre del Presidente/a: "+ bloqueEdificios.get(recorrido).getNombrePresi());
            System.out.println("Número de Puertas: "+ bloqueEdificios.get(recorrido).getNumPuertas());
            System.out.println("--------------------------------------------------------");
        }
    }
    /**
     * Método por el cual escribimos en fichero
     * @param bloqueEdificios ArrayList de objetos de tipo Edificio
     */
    public void escribeFichero(ArrayList<Edificio> bloqueEdificios){
        File archivo= new File("Edificios.txt");
        PrintWriter pw = null;
        //Intenta
        try{
            //Abrimos el archivo para escribir
            pw= new PrintWriter(archivo);
            //Para recorrido igual a 0, mientras recorrido, sea menor al tamaño total del ArrayList, con paso 1 Hacer:
            for (int recorrido = 0; recorrido < bloqueEdificios.size(); recorrido++) {
                //Escribimos los atributos de cada edificio, en la posicion el la que se encuentre(get(recorrido))
                pw.println(bloqueEdificios.get(recorrido).getCalle());
                pw.println(bloqueEdificios.get(recorrido).getNumPisos());
                pw.println(bloqueEdificios.get(recorrido).getNombrePresi());
                pw.println(bloqueEdificios.get(recorrido).getNumPuertas());
            }
            /*Bucle de Diana
            for(Edificio hola: bloqueEdificios){
                pw.println(hola.getCalle());
                pw.println(hola.getNumPisos());
                pw.println(hola.getNombrePresi());
                pw.println(hola.getNumPuertas());
            }*/
            //Mensaje tranquilizador
            System.out.println("Se ha escrito correctamente tu fichero.");
        //Pilla
        }catch (FileNotFoundException excepciones){
            //Nos enseña las cagadas
            excepciones.printStackTrace();
        //Al final
        }finally{
            //Cerramos el fichero para escribir
            pw.close();
        }
    }
    /**
     * Método por el cual leemos de fichero
     */
    public void leeFichero(){
        FileReader archivo;
        BufferedReader br;
        String linea;
        //Intenta
        try{
            //Seleccionamos el archivo que queremos leer
            archivo = new FileReader("Edificios.txt");
            //Nos ponemos las gafas para leer
            br= new BufferedReader(archivo);
            //Si la linea que leamos es null (Esta vacio):
            if (br.readLine()==null) {
                System.out.println("El fichero está vacio o no se ha creado");
            //Si no:
            }else{
                //Mientras la linea que leamos, sea distinta de Null:
                while((linea=br.readLine())!=null){
                    System.out.println("Calle: "+linea); 
                    linea=br.readLine();
                    System.out.println("Número de pisos: "+linea);
                    linea=br.readLine();
                    System.out.println("Nombre del Presidente: "+linea);
                    linea=br.readLine();
                    System.out.println("Número de puertas: "+linea);
                }
            }
            br.close();
        //Pilla 
        }catch(FileNotFoundException excepciones){
            excepciones.printStackTrace();
        //Pilla
        }catch(IOException excepciones){
            excepciones.printStackTrace();
        }
    }
}
