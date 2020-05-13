package Clases;

import java.io.Serializable;


public class ColasD implements Serializable
{

    private Nodo f;
    private Nodo a;

    
    public Nodo getF()
    {
        return f;
    }

    
    public void setF(Nodo f)
    {
        this.f = f;
    }

    public Nodo getA()
    {
        return a;
    }

    public void setA(Nodo a)
    {
        this.a = a;
    }

    public boolean inserta(Nodo n)
    {
        if (n == null)
        {
            return false;
        } else
        {
            if (f == null)
            {
                f = a = n;
            } else
            {
                a.setSig(n);
                a = n;
            }
            System.out.println("DATO INSERTADO CORRECTAMENTE EN LA COLA");
            return true;
            
        }
    }

    public Nodo elimina()
    {
        if (f == null)
        {
            return null;
        } else
        {
            Nodo aux = f;
            if (f == a)
            {
                f = a = null;
            } else
            {
                f = aux.getSig();
                aux.setSig(null);
            }
            return aux;
        }
    }

}
