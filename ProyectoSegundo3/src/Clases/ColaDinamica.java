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
public class ColaDinamica implements Serializable{
    //frente y atras

    public static final long serialVersionUID = 1L;
    
    private Nodo frente = null;

    private Nodo atras = null;

    /**
     * @return the frente
     */
    public Nodo getFrente() {
        return frente;
    }

    /**
     * @param frente the frente to set
     */
    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    /**
     * @return the atras
     */
    public Nodo getAtras() {
        return atras;
    }

    /**
     * @param atras the atras to set
     */
    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    public boolean Inserta(Nodo n) {
        if (n == null) {
            System.out.println("No se pueden insertar más datos :´(");
            return false;
        } else if (frente == null) {
            frente = atras = n;
        } else {
            atras.setSig(n);
            atras = n;
        }
        return true;
    }

    public Nodo Elimina() {
        if (frente == null) {
            System.out.println("Cola vacía");
            return null;
        } else {
            Nodo aux = frente;
            if (frente == atras) {
                frente = atras = null;
            } else {
                frente = frente.getSig();
                aux.setSig(null);
            }
            return aux;
        }
    }

}
