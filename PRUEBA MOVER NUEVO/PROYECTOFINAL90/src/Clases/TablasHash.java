/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author zgame
 */
public class TablasHash implements Serializable {

    private ArbolBinario arr[];

    public TablasHash(int n) {
        arr = new ArbolBinario[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArbolBinario();
        }
    }

    public static int posicion(NodoArbol b) {

        String posC = b.getEtq(); //nombre que se acaba de ingresar

        int pos = 0;
        String prueba = "Ñ";

        for (int i = 65; i < 91; i++) {
            if (i == posC.toUpperCase().codePointAt(0)) {
                pos = i - 65;
            } else if (posC.toUpperCase().codePointAt(0) == prueba.codePointAt(0)) {
                pos = 14;
            }
        }

        System.out.println("La posicion es " + pos);
        return pos;
    }

    public void insertaTH(String etq, NodoArbol nuevo) {

        int pos = posicion(nuevo);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Nombre no aceptado");
        } else {
            arr[pos].setR(arr[pos].inserta(arr[pos].getR(), nuevo));
        }
    }

    public void elimina(String etq) {
        NodoArbol nodE = new NodoArbol(etq, null);

        int pos = posicion(nodE);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Nombre no aceptado");
        } else {
            NodoArbol[] arrE = new NodoArbol[2];
            arr[pos].elimina(arr[pos].getR(), etq, arrE);
            arr[pos].setR(arrE[1]);
        }
    }

    public void verarboles() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Arbol [" + i + "] " + arr[i].preOrden(arr[i].getR()) + "\n");
        }
    }

    /**
     * @return the arr
     */
    public ArbolBinario[] getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(ArbolBinario[] arr) {
        this.arr = arr;
    }
}
