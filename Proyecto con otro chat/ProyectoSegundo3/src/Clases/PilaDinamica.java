/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author josea
 */
public class PilaDinamica implements Serializable{
    //atras

    //////////////////////////////////////////////////
    public static final long serialVersionUID = 1L;
    
    private Nodo tope = null;

    /**
     * @return the tope
     */
    public Nodo getTope() {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(Nodo tope) {
        this.tope = tope;
    }

    public boolean Inserta(Nodo n) {
        if (n == null) {
            System.out.println("No se pueden insertar más datos");
            return false;
        } else {
            n.setSig(tope);
            tope = n;
            return true;
        }
    }

    public Nodo Elimina() {
        if (tope == null) {
            System.out.println("Pila vacía");
            return null;
        } else {
            Nodo aux = tope;
            tope = aux.getSig();
            aux.setSig(null);
            return aux;
        }
    }

}
