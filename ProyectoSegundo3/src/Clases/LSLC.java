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
     private Nodo r = null; //raiz

    //@Override
    public boolean vacia()
    {
        return r == null;
    }

    //@Override
    public boolean llena()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void inserta(Object obj)
    {
        if (obj != null)
        {
            if (r == null)
            {
                r = (Nodo) obj;
                r.setSig(r);
            } else
            {
                Nodo n = (Nodo) obj;
                if (n.getEtq().compareTo(r.getSig().getEtq()) < 0
                        || n.getEtq().compareTo(r.getEtq()) >= 0)
                {
                    n.setSig(r.getSig());
                    r.setSig(n);
                    if (n.getEtq().compareTo(r.getEtq()) >= 0)
                    {
                        r = n;
                    }
                } else
                {
                    boolean b = true;
                    Nodo aux = r.getSig();
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
    public Object inserta(Object obj, Object r)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public Object elimina()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public Object elimina(Object obj)
    {
        if (r == null)
        {
            System.out.println("Lista vacia !!!No hay datos!!!");
            return null;
        } else
        {
            Nodo aux = null;
            String s = (String) obj;
            if (s.compareTo(r.getSig().getEtq()) >=0
                    && s.compareTo(r.getEtq()) <=0)
            {
                if (r.getSig().getEtq().equals(s))
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
                        if (s.compareTo(aux2.getSig().getEtq()) == 0)
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

    //@Override
    public Object elimina(Object obj, Object r)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public Object elimina(Object obj, Object r, Object b)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public String desp()
    {
        String s = "";
        if (r != null)
        {
            Nodo aux = r.getSig();
            do
            {
                s += aux.getEtq() + "\n";
                aux.getSig();
            } while (aux != r.getSig());
        } else
        {
            s = "No hay datos";
        }
        return s;
    }
}
