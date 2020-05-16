/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Mauro
 */
public class ArbolBinario
{
    private NodoArbol r=null;
    
    
    
    
    public NodoArbol inserta(NodoArbol r, NodoArbol n)
    {
        if(r==null)
        {
            return n;
        }else
        {
            if(r.getEtq().compareTo(n.getEtq())>0)
            {
                r.setIzq(inserta(r.getIzq(), n));
            }else
            {
                r.setDer(inserta(r.getDer(), n));
            }
            return r;
        }
    }

    /**
     * @return the r
     */
    public NodoArbol getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArbol r)
    {
        this.r = r;
    }
    
    public String enOrden(NodoArbol r)
    {
        String s="";
        if(r != null)
        {
            s+=enOrden(r.getIzq());
            s+=r.getEtq();
            s+=enOrden(r.getDer());
        }
        return s;
    }
    
    
    public String preOrden(NodoArbol r)
    {
        String s="";
        if(r != null)
        {
            s+=r.getEtq();
            s+=preOrden(r.getIzq());
            s+=preOrden(r.getDer());
        }
        return s;
    }
    
    public String postOrden(NodoArbol r)
    {
        String s="";
        if(r != null)
        {
            s+=postOrden(r.getIzq());
            s+=postOrden(r.getDer());
            s+=r.getEtq();
        }
        return s;
    }
}
