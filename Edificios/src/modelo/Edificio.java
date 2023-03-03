/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author soxcr
 */
public class Edificio {
    private String calle;
    private int numPisos;
    private String nombrePresi;
    private int numPuertas;
    
    /*-------------------------------------------------------------------------
                            Constructor por Defecto
    --------------------------------------------------------------------------*/
    /**
     * Método Constructor por defecto que tiene los valores:
     * calle="Glorieta del Mercado";
     * numPisos=3;
     * nombrePresi="Gilberto Origeda";
     * numPuertas=5;
     */
    public Edificio(){
        calle="Glorieta del Mercado";
        numPisos=3;
        nombrePresi="Gilberto Origeda";
        numPuertas=5;
    }
    /*-------------------------------------------------------------------------
                            Constructor por Parámetros
    --------------------------------------------------------------------------*/    

    /**
     * Método Cosntructor por parámetros, en el cual le pasamos el literal o
     * las variables correspondientes
     * @param calle String en el que introducimos la calle
     * @param pisos int en el que introducimos el número de pisos
     * @param presidente String en el que damos en nombre del Presidente 
     * @param puertas int en el que introducimos el número de puertas en cada piso
     */
    public Edificio(String calle, int pisos, String presidente, int puertas){
        this.calle=calle;
        this.numPisos=pisos;
        this.nombrePresi=presidente;
        this.numPuertas=puertas;
    }
    /*-------------------------------------------------------------------------
                                Getter y Setter
    --------------------------------------------------------------------------*/
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public String getNombrePresi() {
        return nombrePresi;
    }

    public void setNombrePresi(String nombrePresi) {
        this.nombrePresi = nombrePresi;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    
}
