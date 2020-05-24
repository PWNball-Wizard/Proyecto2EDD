package Clases;

import java.io.Serializable;
import javax.swing.JOptionPane;


public class Multilistas implements Serializable
{

    private static Nodo mov = null;//guarda un dato eliminado para hacer el movimiento 
    //para eliminar una lista se necesita elimnar y crear otra lista
    
//*****************************************************
    public static Nodo inserta(Nodo r, Nodo n, int nivel, String etqs[]/*,Nodo ra*/) 
    //r=nodo raiz general o del nivel ya que es un metodo recursivo
    //n=nodo a ingresar
    //n=nivel,se recibe en 0 y cuando hace la recursion aumenta en uno para saber que ya esta en otro niel
    //etqs=arreglo de etiquetas que nos dira en que nivel va
    //ra=RAIZ ANTERIOR es el aux cuando sea el primer nivel es null y cuando sea niveles de abajo, si se quiere hacer LDL para conectar todos los nodos a la raiz de arriba
    {
        if (nivel == etqs.length - 1)
        //VALIDA QUE ESTE EN EL NIVEL
        //nivel 0 = etqs[1] 
        {
            LSL ls = new LSL();//crea una nueva lista para insertar los datos
            //LSLC ls = new LSLC(); //HACE QUE LA LISTA SEA circular
            //LDL ldl = new LDL();
            ls.setR(r);//la lista recibe como parametro a la raiz de la multilista
            ls.inserta(n);//inserta el dato en la lista //EL METODO INSERTA ES DE LA LSL
            r = ls.getR();//reconecta la r que mando a insertar pero ahora con la lista
            return r;//REGRESA LA R MODIFICADA
        } else
        {
            Nodo aux = busca(r, etqs[nivel]);//SI NO ESTA EN EL PRIMER NIVEL RECORRE EL ARBOL EN BUSCA DE LA ETIQUETA
            //a partir de aux va hacia abajo
            
            //aux.getAbj().setArb(aux);//CONECTA CON LA RAIZ DE ARRIBA
            
            if (aux != null)//quiere decir que si encontro el Nodo
            {
                //PROCESO DE RECURSIVIDAD PARA BUSCAR EN LOS NIVELES INFERIORES
                aux.setAbj(inserta(aux.getAbj(), n, nivel + 1, etqs/*,aux*/));//Si encuentra el dato lo inserta
                //el aux sera la raiz anterior en caso de que sea LDL
            } else
            {
                System.out.println("No se encontro " + etqs[nivel] + " En el nivel " + nivel);
            }
            return r;//REGRESA UN NODO
        }
    }
    
    

    public static Nodo elimina(Nodo r, int nivel, String etqs[])
    {
        if (nivel == etqs.length - 1)
        {
            LSL ls = new LSL();
            ls.setR(r);
            Nodo aux = ls.eliminar(etqs[nivel]);
            mov = aux;
            if (aux == null)
            {
                JOptionPane.showMessageDialog(null, "No se encontro el dato", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else
            {
                r = ls.getR();
                System.out.println("La lista del nivel [" + nivel + "]= " + ls.can());
            }
            return r;
        } else
        {
            Nodo aux = busca(r, etqs[nivel]);
            if (aux != null)
            {
                aux.setAbj(elimina(aux.getAbj(), nivel + 1, etqs));//recursion
            } else
            {
                System.out.println("No se encontro " + etqs[nivel] + " En el nivel " + nivel);
            }
            return r;
        }
    }

    public static Nodo mover(Nodo r, int nivel, String etqsE[], String etqsI[])
    {
        r = elimina(r, nivel, etqsE);
        if (mov != null)
        {
            r = inserta(r, mov, nivel, etqsI);
        }
        return r;
    }

    public static Nodo busca(Nodo r, String etq)
    //METODO RECURSIVO QUE BUSCA EN LA LISTA
    //r=raiz donde va a buscar
    //recibe la etiqueta que va a buscar dentro del arreglo
    {
        Nodo aux = null;//Nodo aux que va a regresar lo que encontro
        while (r != null)//quiere decir que no ha llegado al final
         //si fuera una LSLC seria mientras r sea diferente de el nodo que tiene al principio
        {
            if (r.getEtq().equals(etq))//si es igual
            {
                aux = r;//retorna la posicion que encontre 
                break;
            } else
            {
                r = r.getSig();
            }
        }
        return aux;//retorna lo que encontro
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
