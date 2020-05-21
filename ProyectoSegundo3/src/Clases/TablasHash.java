/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author zgame
 */
public class TablasHash {

    public static NodoArbol[] arr = new NodoArbol[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null};

    public static int posicion(NodoArbol n) {

        String posC = n.getEtq();

        int pos = 0;

        for (int i = 65; i < 91; i++) {

            if (i == posC.toUpperCase().codePointAt(0)) {
                pos = i - 65;
            }
        }
        System.out.println("La posicion es "+ pos);
        return pos;
    }
}
