package Clases;

import java.io.Serializable;

public class Nodo implements Serializable
{

    private Object obj;
    private String etq="null"; //IDENTIFICA LO QUE HAY DENTRO DE LA CAJA
    private Nodo sig = null;
    private Nodo abj=null;
    private Nodo ant = null;
    private int tipo;
    
    public Nodo(Object obj)
    {
        this.obj = obj;
    }

    public Nodo(Object obj, String etq)
    {
        this.obj = obj;
        this.etq = etq;
    }

    public Nodo(int tipo, Object obj) {
        this.obj = obj;
        this.tipo = tipo;
    }
    

    /**
     * @return the obj
     */
    public Object getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    /**
     * @return the sig
     */
    public Nodo getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig)
    {
        this.sig = sig;
    }

    /**
     * @return the etq
     */
    public String getEtq()
    {
        return etq;
    }

    /**
     * @param etq the etq to set
     */
    public void setEtq(String etq)
    {
        this.etq = etq;
    }

    /**
     * @return the ant
     */
    public Nodo getAnt()
    {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(Nodo ant)
    {
        this.ant = ant;
    }

    /**
     * @return the abj
     */
    public Nodo getAbj()
    {
        return abj;
    }

    /**
     * @param abj the abj to set
     */
    public void setAbj(Nodo abj)
    {
        this.abj = abj;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    

}
