package Clases;

import java.io.Serializable;


public class Propiedades implements Serializable
{

    private Nodo r = null;
    TablasHash arr = new TablasHash(26);
    
    public Propiedades()
    {
    }
    public Propiedades(Nodo r, TablasHash arr)
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
    public TablasHash getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(TablasHash arr) {
        this.arr = arr;
    }
}
