package Clases;

import java.io.Serializable;


public class Propiedades implements Serializable
{

//    public ColaDinamica c = new ColaDinamica();
    private Nodo r = null;
    private  NodoArbol[] arr = new NodoArbol[27];
    
    

    public Propiedades()
    {
    }
    public Propiedades(Nodo r, NodoArbol arr[])
    {
        this.r = r;
        this.arr = arr;
    }

    /**
     * @return the r
     */
    public Nodo getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r) {
        this.r = r;
    }

    /**
     * @return the arr
     */
    public NodoArbol[] getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(NodoArbol[] arr) {
        this.arr = arr;
    }

    /**
     * @return the num
     */
    
    /**
     * @return the nar
     */
   
}
