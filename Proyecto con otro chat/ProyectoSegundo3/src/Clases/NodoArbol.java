/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Mauro
 */
public class NodoArbol implements Serializable
{
    private String etq;
    private Object obj;
    private NodoArbol izq = null;
    private NodoArbol der = null;
    private String predecesores[] = new String[2];
    
    ////////////////////////////////////////////////////
    
    public NodoArbol(String etq, Object obj)
    {
        this.etq=etq;
        this.obj=obj;
    }

    public NodoArbol(String etq, Object obj, String predecesores[])
    {
        this.etq=etq;
        this.obj=obj;
        this.predecesores = predecesores;
    }
    
    /**
     * @return the etq
     */
    public String getEtq()
    {
        return etq;
    }

    /**
     * @param etq the etq to set
     */
    public void setEtq(String etq)
    {
        this.etq = etq;
    }

    /**
     * @return the obj
     */
    public Object getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    /**
     * @return the izq
     */
    public NodoArbol getIzq()
    {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoArbol izq)
    {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoArbol getDer()
    {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoArbol der)
    {
        this.der = der;
    }

    /**
     * @return the predecesores
     */
    public String[] getPredecesores() {
        return predecesores;
    }

    /**
     * @param predecesores the predecesores to set
     */
    public void setPredecesores(String[] predecesores) {
        this.predecesores = predecesores;
    }
    
    
    
}
