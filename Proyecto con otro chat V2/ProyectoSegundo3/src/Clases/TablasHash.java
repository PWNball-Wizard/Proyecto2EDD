/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author zgame
 */
public class TablasHash implements Serializable{

    public static NodoArbol[] arr = new NodoArbol[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null};

    public static int posicion(NodoArbol b) {

        String posC = b.getEtq();
        ////////////para ayudar a ir a la ventana con las conve en caso de que se encuentre puede usarse n.getPredecesores;
        ///////////////////////////////////////////////////////////////////
        int pos = 0;

        for (int i = 65; i < 91; i++) {

            if (i == posC.toUpperCase().codePointAt(0)) {
                pos = i - 65;
            }
        }
        System.out.println("La posicion es "+ pos);
        return pos;
    }
    
    public static String muestra(){
    
        String s = "";
        
        for (int i = 0; i < 26; i++) {
            if (arr[i] != null) {
                s += arr[i].getEtq()+ "\n";
            }
        }
    
        return s;
    }
}
