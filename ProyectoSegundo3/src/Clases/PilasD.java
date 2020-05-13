package Clases;

import java.io.Serializable;


public class PilasD implements Serializable
{

    private Nodo tope = null;
    //public int n=0;
    
    public Nodo getTope()
    {
        return tope;
    }

    public void setTope(Nodo tope)
    {
        this.tope = tope;
    }

    public boolean inserta(Nodo n)
    {
        if (n == null)
        {
            return false;
        } else
        {
            n.setSig(tope);
            tope = n;
            System.out.println("DATO INSERTADO CORRECTAMENTE EN LA PILA EN LA POSICION " +n);
            return true;
        }
    }

    public Nodo elimina()
    {
        if (tope == null)
        {
            return null;
        } else
        {
            Nodo aux = tope;
            tope = aux.getSig();
            aux.setSig(null);
            //n=n+1; 
            return aux;
        }
    }
    
        public Nodo busca(Object busca)
    {
        if (tope==null) 
        {
            return null;
        } else 
        {
            Nodo aux = tope;
            if (aux.getObj().equals(busca)) 
            {
                return aux;
                
            }else
            {
                tope= aux.getSig();
                aux.setSig(null);
                
            }
            
            return null;
            
        }
    }

}
