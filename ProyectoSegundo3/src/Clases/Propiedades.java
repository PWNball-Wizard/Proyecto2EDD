package Clases;

import java.io.Serializable;


public class Propiedades implements Serializable
{

    public ColaDinamica c = new ColaDinamica();
    private Nodo r = null;
    
    
    //ACUMULADOR PARA CADA QUE ENTRA UN NUEVO MENSAJE
    

    public Propiedades()
    {
    }

    public Propiedades(ColaDinamica c, Nodo r)
    {
        this.c = c;
        this.r = r;
    }

    public ColaDinamica getC() {
        return c;
    }

    public void setC(ColaDinamica c) {
        this.c = c;
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
    

}
