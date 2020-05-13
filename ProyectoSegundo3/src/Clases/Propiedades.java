package Clases;

import java.io.Serializable;


public class Propiedades implements Serializable
{

    public PilasD p1 = new PilasD();
    private PilasD p2 = new PilasD();
    public ColasD c = new ColasD();
    
    //ACUMULADOR PARA CADA QUE ENTRA UN NUEVO MENSAJE
    private int num = 0;

    public Propiedades()
    {
    }

    public Propiedades(PilasD p1, PilasD p2, ColasD c, int num)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.c = c;
        this.num = num;
    }

    public PilasD getP1() {
        return p1;
    }

    public void setP1(PilasD p1) {
        this.p1 = p1;
    }

    public PilasD getP2() {
        return p2;
    }

    public void setP2(PilasD p2) {
        this.p2 = p2;
    }

    public ColasD getC() {
        return c;
    }

    public void setC(ColasD c) {
        this.c = c;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
