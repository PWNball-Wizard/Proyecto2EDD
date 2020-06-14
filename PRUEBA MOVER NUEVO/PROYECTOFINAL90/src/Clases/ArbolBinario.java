
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
public class ArbolBinario implements Serializable {

    private NodoArbol r = null;

    //GETTERS Y SETTERS
    /**
     * @return the r
     */
    public NodoArbol getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArbol r) {
        this.r = r;
    }

    /*>>>>>>>>>>>>>>>>INSERTA Y ELIMINA<<<<<<<<<<<<<<<<<*///****************************
    public NodoArbol inserta(NodoArbol r, NodoArbol n, Nodo hilo) {
        if (r == null) {
           n.setHilo(hilo);
            return n;
        } else {
            if (r.getEtq().compareTo(n.getEtq()) > 0) {
                r.setIzq(inserta(r.getIzq(), n, hilo));
                
            } else {
                r.setDer(inserta(r.getDer(), n, hilo));
            }
            r = balancear(r);//BALANCEA EL ARBOL DESPUES DE INSERTAR////////////////////
            return r;
        }
    }

    public void elimina(NodoArbol r, String etq, NodoArbol arr[]) {

        if (r == null) {
            arr[0] = null;
            arr[1] = r;
        } else {
            if (r.getEtq().equalsIgnoreCase(etq.trim())) {//encontre el dato a eliminar

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
                        arr[1]=balancear(arr[1]);//BALANCEA EL ARBOL CUANDO TIENE UN HIJO////////////////////

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
                        arr[1]=balancear(arr[1]);//BALANCEA DESPUES DE ELIMINAR CON DOS HIJOS///////////////
                        r.setDer(null);
                        r.setIzq(null);
                    }
                }
            } else {
                if (r.getEtq().compareToIgnoreCase(etq.trim()) > 0)//compara la etiqueta que recibe con la de la raiz para saber hacia que lado comenzara a buscar
                {
                    //COMIENZA LA RECURSION
                    System.out.println("Etiquet en raiz " + r.getEtq() + "etiqueta original" + etq);
                    elimina(r.getIzq(), etq, arr);
                    r.setIzq(arr[1]);//se reconecta con lo que tenga arr, ya que esa es la nueva raiz

                } else {
                    System.out.println("Etiquet en raiz " + r.getEtq() + "etiqueta original" + etq);
                    elimina(r.getDer(), etq, arr);
                    r.setDer(arr[1]);//se reconecta con lo que tenga arr, ya que esa es la nueva raiz
                }
                arr[1] = r;//la posicion 1 va a ser sustituida por la nueva raiz

            }
        }

    }

    public NodoArbol sucesorE(NodoArbol r) {//muestra el sucesor en orden

        if (r.getIzq().getIzq() != null) {
            return sucesorE(r.getIzq());
        } else {
            return r;
        }

    }

    /*>>>>>>>>>>>>>>>>>METODOS DE ORDENAMIENTO<<<<<<<<<<<<<<<<<<<<<<*/
    public String enOrden(NodoArbol r) {
        String s = "";
        if (r != null) {
            s += enOrden(r.getIzq());
            s += r.getEtq();
            s += enOrden(r.getDer());
        }
        return s;
    }

    public String preOrden(NodoArbol r) {
        String s = "";
        if (r != null) {
            s += r.getEtq();
            s += preOrden(r.getIzq());
            s += preOrden(r.getDer());
        }
        return s;
    }

    public String postOrden(NodoArbol r) {
        String s = "";
        if (r != null) {
            s += postOrden(r.getIzq());
            s += postOrden(r.getDer());
            s += r.getEtq();
        }
        return s;
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>METODOS DE BALANCEO<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    public NodoArbol balancear(NodoArbol r)
    {
        if (r != null)
        {
            if (altura(r.getIzq(), 0) - altura(r.getDer(), 0) == 2)
            {
                /* desequilibrio hacia la izquierda! */
                if (altura(r.getIzq().getIzq(), 0) >= altura(r.getIzq().getDer(), 0))
                /* desequilibrio simple hacia la izquierda */
                {
                    r = rotar_s(r, true);
                } else
                /* desequilibrio doble hacia la izquierda */
                {
                    r = rotar_d(r, true);
                }
            } else if (altura(r.getDer(), 0) - altura(r.getIzq(), 0) == 2)
            {
                /* desequilibrio hacia la derecha! */
                if (altura(r.getDer().getDer(), 0) >= altura(r.getDer().getIzq(), 0))
                /* desequilibrio simple hacia la derecha */
                {
                    r = rotar_s(r, false);
                } else
                /* desequilibrio doble hacia la derecha */
                {
                    r = rotar_d(r, false);
                }
            }
        }
        return r;
    }

    public NodoArbol rotar_d(NodoArbol r, boolean izq)
    {
        if (izq)
        /* rotación izquierda */
        {
            r.setIzq(rotar_s(r.getIzq(), false));
            r = rotar_s(r, true);
        } else
        /* rotación derecha */
        {
            r.setDer(rotar_s(r.getDer(), true));
            r = rotar_s(r, false);
        }

        return r;
    }

    public NodoArbol rotar_s(NodoArbol r, boolean izq)
    {
        NodoArbol tmp;
        if (izq)
        /* rotación izquierda */
        {
            tmp = r.getIzq();
            r.setIzq(tmp.getDer());
            tmp.setDer(r);
        } else
        /* rotación derecha */
        {
            tmp = r.getDer();
            r.setDer(tmp.getIzq());
            tmp.setIzq(r);
        }
        return tmp;
    }

    public int altura(NodoArbol r, int a)
    {
        if (r == null)
        {
            return a;
        } else
        {
            return max(altura(r.getIzq(), a + 1), altura(r.getDer(), a + 1));
        }

    }

    public int max(int a, int b)
    {
        return a > b ? a : b;
    }

    /*>>>>>>>>>>>>>>>>METODOS DE BUSQUEDA<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    public NodoArbol busca(NodoArbol r, String etq) //dos parametros: el arbol y la palabra a buscar
    //regresa el nodo encontrado o en caso de no encontrarlo regresa null
    {
        NodoArbol aux = null;//aux almacena el elemento a buscar

        if (r == null)//si el arbol esta vacio
        {
            System.out.println("El arbol se encuentra vacio");//FUNCIONA 
            return null;
        } else {
            if (r.getEtq().equalsIgnoreCase(etq.trim()))//compara y si lo encuentra en la raiz del arbol da true 
            {
                aux = r;

                System.out.println("EL DATO ENCONTRADO ES: " + aux.getEtq());
            } else//el dato no se encuentra en la raiz del arbol
            {
                //COMIENZA LA RECURSIVIDAD
                if (r.getEtq().compareToIgnoreCase(etq.trim()) > 0)//si el dato es mayor que la raiz 
                //compareTo da valor mayor a 0 si la cadena 1 es mayor que la cadena 2
                {
                    aux = busca(r.getIzq(), etq);
                } else//si el dato es menor que la raiz
                {
                    aux = busca(r.getDer(), etq);

                }
            }
        }
        return aux;//regresa la raiz
    }
}
