/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Vistas.VtnGrupo;
import Vistas.vtnChat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;

/**
 *
 * @author josea
 */
public class Archivos {

    public static void guardar(Propiedades obj, JFrame jf) throws FileNotFoundException {

        try {
            FileOutputStream fos = new FileOutputStream("datos.dat");
            ObjectOutputStream arch = new ObjectOutputStream(fos);

            arch.writeObject(obj);

            arch.close();
        } catch (FileNotFoundException ex) {
//            Mensaje.error(jf, "No se encontro el archivo");
        } catch (Exception er) {
//            Mensaje.error(jf, "Error..." + er.toString());
        }
    }

    public static void carga(JFrame jf) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("datos.dat");
            ObjectInputStream arch = new ObjectInputStream(fis);

            
            Propiedades p = (Propiedades) arch.readObject();
            
            vtnChat.cd = p.c;
            
            VtnGrupo.r = p.getR();
            
            TablasHash.arr = p.getArr();
          
            
//            Object[] aux = (Object[]) arch.readObject();
//            //
//            for (int i = 0; i < aux.length; i++) {
//                if (aux[i] instanceof ColaDinamica) {
//                    vtnChat.cd = (ColaDinamica) aux[i];
//                } else {
//
//                    VtnGrupo.r = (Nodo) aux[i];
//
//                }
//            }

//            if (arch.readObject() instanceof ColaDinamica) {
//                vtnChat.cd = (ColaDinamica)arch.readObject();
//            }else{
//                
//                VtnGrupo.r = (Nodo) arch.readObject();
//                
//            }
            arch.close();

        } catch (FileNotFoundException ex) {
//            Mensaje.error(jf, "No se encontró el archivo para carga");
        } catch (Exception er) {
//            Mensaje.error(jf, "Error..." + er.toString());
        }
    }

}
