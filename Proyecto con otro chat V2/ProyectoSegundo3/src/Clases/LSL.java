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
public class LSL implements Serializable
{
    private Nodo r=null; //RAIZ DE LA LISTA 
    //EN EL LIBRO VIENE COMO CABEZA DE LA LISTA Y SE INICIALIZA EN null YA QUE NO APUNTA A NINGUN LADO 

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }
    
    public boolean inserta(Nodo n) //RECIBE EL ELEMENTO A INSERTAR
    {
        //SE NECESITAN 5 VALIDACIONES PARA INSERTAR EN LA LISTA
        if (n==null) //1. si el nodo es null no inserta nada
        {
            return false;
        } else
        {
            //2.el primero en la lista
            if (r==null)
            {
                r=n; //el primero de la lista pasa a ser la raiz
            } else
            {
                //3.menor al primero de la lista
                //Si el nodo a insertar es el primero de la lista
                
                if (n.getEtq().compareTo(r.getEtq())<0) 
                // compara lo que tiene r con el dato que llego 
                //si es mayor a 0 lo que esta en n es mayor a r
                //si es igual a 0 quiere decir que tienen lo mismo
                //si es menor a 0 lo que esta en n es menor a r
                {
                    n.setSig(r);//ahora el dato insertado pasa a ser el primero de la lista, por lo tanto
                    //la raiz pasa a ser el siguiente
                    r=n;//la raiz se mueve hacia donde esta el dato que llego
                } else
                {
                    //4.cuando el dato va en medio de la lista
                    Nodo aux=r; //declara un auxiliar para almacenar la raiz
                    
                    boolean b=true; //bandera para recorrer la lista 
                    //si se inserta en medio ya no recorrre la lista
                    //en caso contrario seguira recorriendo hasta insertar el dato al final
                    
                    while (aux.getSig()!=null && b)
                    //recorrido de la lista mientras no llegue al final
                    {
                        if(n.getEtq().compareTo(aux.getSig().getEtq())<0)//se utiliza la misma condicion que se utilizo arriba
                        {
                            n.setSig(aux.getSig()); //conecta al que llego
                            aux.setSig(n); //la raiz se va a conectar al que esta llegando
                            b=false; //para que detenga el ciclo
                        }else
                        {
                            aux=aux.getSig();//mueve al siguiente del que el mismo aux apunta
                        }
                    }
                    //5.va al final de la lista
                    if (b)//significa que no inserto enmedio y ahora tiene que insertar al final
                    {
                        aux.setSig(n);//se conecta al ultimo dato de la lista
                    }
                }
            }
            return true;
        }
    }
    
    public Nodo eliminar(String etq)
    {
        //EXISTEN 5 CASOS PARA ELIMINAR UN ELEMENTO DE UNA LISTA
        if (r==null)//1.no hay nada que eliminar
        {
            return null;
        } else
        {
            Nodo aux=null; //aux es el elemento a eliminar 
            
            if(etq.compareTo(r.getEtq())>= 0)//SE UTILIZA PARA OPTIMIZAR EL CODIGO
            {
                if (r.getEtq().equals(etq))//Si se encuentra en la primera posicion
                {
                    aux=r; //aux se coloca en el primer elemento
                    r=r.getSig();//r se mueve a la siguiente posicion
                    aux.setSig(null);//desconecta al que se va a ir
                } else
                {
                    //cuando va enmedio
                    //Nodo aux2 recorre toda la lista
                    Nodo aux2=r;
                    boolean b=true;//rompe el ciclo una vez cumplida la condicion
                    while (aux2.getSig() != null && b)//cuando es diferente de null significa que no ha recorrido la lista
                    {
                        if (aux2.getSig().getEtq().equals(etq))//compara el dato a eliminar con las otras etiquetas
                        {
                            aux=aux2.getSig();//mueve a la siguiente posicion
                            aux2.setSig(aux.getSig());//desconecta el que se queda
                            aux.setSig(null);//desconecta el que se va
                            b=false;//rompe el ciclo
                        } else
                        {
                            //cuando esta al final
                            aux2=aux2.getSig();
                        }
                    }
                }  
            }
            return aux;
        }
    }
    
    public String desp(Nodo r)
    {
        String s="";
        while (r!=null)
        {
            s+=r.getEtq();
            r=r.getSig();
        }
        return s;
    }
    
    public int can()
    {
        int cont=0;
        while (r != null)
        {            
            cont++;
            r=r.getSig();
        }
        return cont;
    }
}
