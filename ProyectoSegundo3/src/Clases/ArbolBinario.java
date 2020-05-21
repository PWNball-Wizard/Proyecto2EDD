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
public class ArbolBinario implements Serializable
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

    public void elimina(NodoArbol r, String etq, NodoArbol arr[]) {

        if (r == null) {
            arr[0] = null;
            arr[1] = r;
        } else {
            if (r.getEtq().equals(etq)) {//encontre el dato a eliminar

                arr[0] = r;//porque no importa si tiene un hijo, o dos, o ninguno el dato a eliminar SIEMPRE es r

                if (r.getDer() == null && r.getIzq() == null) {//Cuando no tiene hijos
                    arr[0] = r;
                    arr[1] = null; //para que se reconecte con un nulo
                } else {
                    //cuando tiene un hijo
                    if (!(r.getDer() != null && r.getIzq() != null)) {//si los dos son nulos tiene dos hijos, y para que de un V
                        //cuando uno de los dos de falso y el otro verdad entonces al evaluar en && e invertirse los signos 
                        //significa que uno tiene un solo hijo
                        //asi se evita que que entre cuando tiene 2 hijos
                        if (r.getDer() != null) {//para ver de que lado esta el nodo hijo**para ver si esta ala derecha
                            arr[1] = r.getDer();
                        } else {
                            arr[1] = r.getIzq();
                        }

                    } else {
                        //tiene dos hijos
                        //el sucesor enOrden es el que esta a la derecha mas a la izquierda
                        if (r.getDer().getIzq() == null) {//si a la izquierda hay un nulo entonces toma el que esta a la derecha
                            NodoArbol se = r.getDer();
                            se.setIzq(r.getIzq());//conecta lo que tenia el Nodo eliminado a su izquierda, a el nodo sucesor en su izquierda
                            r.setDer(null);
                            r.setIzq(null);
                            arr[1] = se;
                        } else {
                            NodoArbol aux = sucesorE(r.getDer());
                            NodoArbol se = aux.getIzq();
                            aux.setIzq(se.getDer());//aux en izquierda conecta con el derecho del sucesor en orden
                            se.setDer(r.getDer());
                            se.setIzq(r.getIzq());
                            arr[1] = se;
                        }
                        r.setDer(null);
                        r.setIzq(null);
                    }
                }
            } else {
                if (r.getEtq().compareTo(etq) > 0) {
                    elimina(r.getIzq(), etq, arr);
                    r.setIzq(arr[1]);
                } else {
                    elimina(r.getDer(), etq, arr);
                    r.setDer(arr[1]);
                }
                arr[1] = r;
            }
        }

    }

    public NodoArbol sucesorE(NodoArbol r) {

        if (r.getIzq().getIzq() != null) {
            return sucesorE(r.getIzq());
        } else {
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
