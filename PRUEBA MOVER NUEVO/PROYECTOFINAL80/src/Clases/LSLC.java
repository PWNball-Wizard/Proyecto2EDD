
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

    public Nodo eliminar(String etq)
    {
        if (r == null)
        {
            System.out.println("La lista se encuentra vacia");
            return null;
        } else
        {
            Nodo aux = null;
            
            if (etq.compareToIgnoreCase(r.getSig().getEtq()) >=0
                    && etq.compareToIgnoreCase(r.getEtq()) <=0)
            {
                if (r.getSig().getEtq().equalsIgnoreCase(etq))
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
                        if (etq.compareToIgnoreCase(aux2.getSig().getEtq()) == 0)
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
    
    public String desp() 
    {
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

    
}
