package Clases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Archivos 
{
    public void guardar(Propiedades obj)
    {
        FileOutputStream archivo = null;
        try
        {
            archivo = new FileOutputStream("Mensajes.dat");
            try
            {
                ObjectOutputStream objarchivo = new ObjectOutputStream(archivo);
                try
                {
                    objarchivo.writeObject(obj);
                } catch (Exception e) //QUITAR EL IO SI NO FUNCIONA
                {
                    System.out.println("Error al guardar informacion");
                }
            } catch (IOException ex)
            {
                System.out.println("No se puede abrir el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se puede abrir archivo");
        } finally
        {
            try
            {
                archivo.close();
            } catch (IOException ex)
            {
                System.out.println("No se pudo cerrar el archivo");
            }
        }
    }
}
