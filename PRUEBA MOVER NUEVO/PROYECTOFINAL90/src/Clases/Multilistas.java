package Clases;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class Multilistas implements Serializable {

    private static Nodo mov = null;//guarda un dato eliminado para hacer el movimiento 
    //para eliminar una lista se necesita elimnar y crear otra lista

    public static Nodo inserta(Nodo r, Nodo n, int nivel, String etqs[]) //nodo raiz,nodo a ingresar,nivel,etiqueta
    {
        if (nivel == etqs.length - 1)//VALIDA QUE ESTEMOS EN EL NIVEL CORRECTO
        {
            LSLC ls = new LSLC();//crea una nueva lista
            ls.setR(r);//define la raiz en base a la que recibira como parametro
            ls.inserta(n);//inserta el dato en la lista
            r = ls.getR();//reconecta
            return r;
        } else {
            Nodo aux = busca(r, etqs[nivel]);//RECORRE EL ARBOL EN BUSCA DE LA ETIQUETA

            if (aux != null) {
                aux.setAbj(inserta(aux.getAbj(), n, nivel + 1, etqs));//Si encuentra el dato lo inserta
                aux.getAbj().setArb(aux);
            } else {
                System.out.println("No se encontro " + etqs[nivel] + " En el nivel " + nivel);
            }
            return r;
        }
    }

    public static Nodo elimina(Nodo r, int nivel, String etqs[]) {
        if (nivel == etqs.length - 1) {
            LSLC ls = new LSLC();
            ls.setR(r);
            Nodo aux = ls.eliminar(etqs[nivel]);
            mov = aux;
            if (aux == null) {
                JOptionPane.showMessageDialog(null, "No se encontro el dato", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else {
                r = ls.getR();
                System.out.println("La lista del nivel [" + nivel + "]= " + ls.can());
            }
            return r;
        } else {
            Nodo aux = busca(r, etqs[nivel]);
            if (aux != null) {
                aux.setAbj(elimina(aux.getAbj(), nivel + 1, etqs));//recursion
            } else {
                System.out.println("No se encontro " + etqs[nivel] + " En el nivel " + nivel);
            }
            return r;
        }
    }

    public static Nodo mover(Nodo r, int nivel, String etqsE[], String etqsI[]) {
        r = elimina(r, nivel, etqsE);
        if (mov != null) {
            r = inserta(r, mov, nivel, etqsI);
        }
        return r;
    }

    public static Nodo busca(Nodo r, String etq) {
        Nodo aux2 = r;
        boolean encontrado = false;
        Nodo aux = null;
        do {
            if (aux2.getEtq().equalsIgnoreCase(etq.trim())) {
                aux = aux2;
                encontrado = true;
            } else {
                aux2 = aux2.getSig();
            }
        } while (aux2 != r && encontrado != true);
        System.out.println("EL DATO QUE ENCONTRE FUE:" + aux);
        return aux;
    }

    public static String desp(Nodo r, int nivel) {

        String s = "";

        while (r != null) {

            String ss = "";

            for (int i = 0; i < nivel; i++) {
                ss = "\t";
            }

            s += ss + " nivel " + String.valueOf(nivel) + "\n";

            s += ss + r.getEtq() + "\n";

            s += desp(r.getAbj(), nivel + 1);

            r = r.getSig();

        }
        return s;
    }
}
