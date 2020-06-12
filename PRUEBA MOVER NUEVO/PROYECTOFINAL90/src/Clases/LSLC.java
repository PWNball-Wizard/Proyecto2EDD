
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
public class LSLC 
{
     private Nodo raiz = null; //raiz


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
    }
    

    //@Override
    public Object elimina(Object obj)
    {
        if (raiz == null)
        {
            System.out.println("Lista vacia !!!No hay datos!!!");
            return null;
        } else
        {
            Nodo aux = null;
            String s = (String) obj;
            if (s.compareTo(raiz.getSig().getEtq()) >=0
                    && s.compareTo(raiz.getEtq()) <=0)
            {
                if (raiz.getSig().getEtq().equals(s))
                {
                    aux = raiz.getSig();
                    if (raiz == aux)
                    {
                        raiz = null;
                    } else
                    {
                        raiz.setSig(aux.getSig());
                    }
                } else
                {
                    Nodo aux2 = raiz.getSig();
                    boolean b = true;
                    while (aux2 != raiz && b)
                    {
                        if (s.compareTo(aux2.getSig().getEtq()) == 0)
                        {
                            aux = aux2.getSig();
                            aux2.setSig(aux.getSig());
                            if (aux == raiz)
                            {
                                raiz = aux2;
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
    public Nodo getRaiz()
    {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo raiz)
    {
        this.raiz = raiz;
    }

    public String desp()
    {
        String s = "";
        if (raiz != null)
        {
            Nodo aux = raiz.getSig();
            do
            {
                s += aux.getEtq() + "\n";
                aux.getSig();
            } while (aux != raiz.getSig());
        } else
        {
            s = "No hay datos";
        }
        return s;
    }
}
