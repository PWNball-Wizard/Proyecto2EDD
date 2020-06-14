
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
public class LSLC {

    private Nodo r = null;

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

    public boolean inserta(Nodo n) {
        if (n == null) {
            return false;
        } else {
            //el primero en la lista 
            //se apunta a si mismo para mantener la cricularidad
            if (r == null) {
                r = n;
                r.setSig(r);//el nodo siguiente va a ser el mismo
            } else {
                //menor al primero de la lista
                //último de la lista
                //son las mismas condiciones cuando va al inicio y cuando va al final
                if (n.getEtq().compareTo(r.getSig().getEtq()) <= 0
                        ||/*esta primer comparacion es cuando va al inicio de la lista*/ /* raiz ya no es el primer elemento, ahora el primero es el siguiente de raiz*/ n.getEtq().compareTo(r.getEtq()) >= 0)//esta condicion va cuando inserta al final de la lista
                /**/ {
                    n.setSig(r.getSig());
                    r.setSig(n);

                    if (n.getEtq().compareTo(r.getEtq()) >= 0) {
                        r = n;
                    }

                } else {
                    //cuando el dato va en medio de la lista
                    Nodo aux = r;
                    boolean b = true;
                    while (b) {
                        if (n.getEtq().compareTo(aux.getSig().getEtq()) < 0) {
                            n.setSig(aux.getSig());
                            aux.setSig(n);
                            b = false;
                        } else {
                            aux = aux.getSig();
                        }
                    }
                }
            }
            return true;
        }
    }

    /*public Nodo eliminar(String etq) {
        if (r == null) {
            return null;
        } else {
            Nodo aux = null;
            if (etq.trim().compareToIgnoreCase(r.getSig().getEtq()) >= 0
                    && etq.trim().compareToIgnoreCase(r.getEtq()) <= 0) {
                if (r.getSig().getEtq().equalsIgnoreCase(etq.trim())) {
                    aux = r.getSig();
                    r.setSig(aux.getSig());
                    aux.setSig(null);
                    if (r == aux) {
                        r = null;
                    }
                } else {
                    Nodo aux2 = r.getSig();
                    boolean b = true;
                    while (b) {
                        if (etq.trim().compareToIgnoreCase(aux2.getSig().getEtq()) <= 0) {
                            if (aux2.getSig().getEtq().equalsIgnoreCase(etq.trim())) {
                                aux = aux2.getSig();
                                aux2.setSig(aux.getSig());
                                aux.setSig(null);
                                b = false;
                                if (r == aux) {
                                    r = aux2;
                                }
                            } else {
                                aux2 = aux2.getSig();
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            return aux;
        }
    }*/

    /*private Nodo raiz = null; //raiz


    //@Override
    public void inserta(Object obj)
    {
        if (obj != null)
        {
            if (raiz == null)
            {
                raiz = (Nodo) obj;
                raiz.setSig(raiz);
            } else
            {
                Nodo n = (Nodo) obj;
                if (n.getEtq().compareTo(raiz.getSig().getEtq()) < 0
                        || n.getEtq().compareTo(raiz.getEtq()) >= 0)
                {
                    n.setSig(raiz.getSig());
                    raiz.setSig(n);
                    if (n.getEtq().compareTo(raiz.getEtq()) >= 0)
                    {
                        raiz = n;
                    }
                } else
                {
                    boolean b = true;
                    Nodo aux = raiz.getSig();
                    while (b)
                    {
                        if (n.getEtq().compareTo(aux.getSig().getEtq()) <= 0)
                        {
                            n.setSig(aux.getSig());
                            aux.setSig(n);
                            b = false;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                }
            }
        }
    }*/
    

    public Nodo eliminar(String etq)
    {
        if (r == null)
        {
            System.out.println("La lista se encuentra vacia");
            return null;
        } else
        {
            Nodo aux = null;
            
            if (etq.compareTo(r.getSig().getEtq()) >=0
                    && etq.compareTo(r.getEtq()) <=0)
            {
                if (r.getSig().getEtq().equals(etq))
                {
                    aux = r.getSig();
                    if (r == aux)
                    {
                        r = null;
                    } else
                    {
                        r.setSig(aux.getSig());
                    }
                } else
                {
                    Nodo aux2 = r.getSig();
                    boolean b = true;
                    while (aux2 != r && b)
                    {
                        if (etq.compareTo(aux2.getSig().getEtq()) == 0)
                        {
                            aux = aux2.getSig();
                            aux2.setSig(aux.getSig());
                            if (aux == r)
                            {
                                r = aux2;
                            }
                            b = false;
                        } else
                        {
                            aux2 = aux2.getSig();
                        }
                    }
                }
            }
            if (aux != null)
            {
                aux.setSig(null);
            }
            return aux;
        }
    }
    /**
     * @return the raiz
     */
    /*public Nodo getRaiz()
    {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
 /*public void setRaiz(Nodo raiz)
    {
        this.raiz = raiz;
    }*/
    public String desp() {
        String s = "";
        if (r != null) {
            Nodo aux = r.getSig();
            do {
                s += aux.getEtq() + "\n";
                aux.getSig();
            } while (aux != r.getSig());
        } else {
            s = "No hay datos";
        }
        return s;
    }

    public int can() {
        int cont = 0;
        Nodo aux = r;
        aux = aux.getSig();
        do{
            cont++;
            aux = aux.getSig();
        }while(aux != r.getSig());
        return cont;
    }
}
