package Clases;

import java.io.Serializable;

public class Nodo implements Serializable
{

    private Object obj;
    private Object pila1;
    private Object pila2;
    private String etq="null"; //IDENTIFICA LO QUE HAY DENTRO DE LA CAJA
    private Nodo sig = null;
    private Nodo abj=null;
    private Nodo ant = null;
    private int tipo;
    private Nodo arb=null;//APUNTADOR HACIA ARRIBA
    private int num = 0;
    
    
    
    
    public Nodo(Object obj)
    {
        this.obj = obj;
    }

    public Nodo(Object obj, String etq) //para la multilista
    {
        this.obj = obj;
        this.etq = etq;
    }
    
    public Nodo(Object obj, String etq, int num, Object pila1, Object pila2) //para la multilista
    {
        this.obj = obj;
        this.etq = etq;
        this.num = num;
        this.pila1 = pila1;
        this.pila2 = pila2;
        
    }

    public Nodo(int tipo, Object obj) {//para  la cola
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

    public Nodo getArb() {
        return arb;
    }

    public void setArb(Nodo arb) {
        this.arb = arb;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the pila1
     */
    public Object getPila1() {
        return pila1;
    }

    /**
     * @param pila1 the pila1 to set
     */
    public void setPila1(Object pila1) {
        this.pila1 = pila1;
    }

    /**
     * @return the pila2
     */
    public Object getPila2() {
        return pila2;
    }

    /**
     * @param pila2 the pila2 to set
     */
    public void setPila2(Object pila2) {
        this.pila2 = pila2;
    }
}
