/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Mar
 */
public class ManipulaArchivos
{

    public static void guarda(Object obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("Datos/" + cad);
            try
            {
                ObjectOutputStream arc = new ObjectOutputStream(fos);
                arc.writeObject(obj);
                arc.close();
            } catch (IOException e)
            {
                System.out.println("Error en la entrada salida de datos.");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("No se encontro el archivo.");
        }
    }
    
    public static void guarda(Object[][] obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("Datos/" + cad);
            try
            {
                ObjectOutputStream arc = new ObjectOutputStream(fos);
                arc.writeObject(obj);
                arc.close();
            } catch (IOException e)
            {
                System.out.println("Error en la entrada salida de datos.");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("No se encontro el archivo.");
        }
    }

    public static Object carga(String cad)
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream("Datos/" + cad);
            try
            {
                ObjectInputStream arc = new ObjectInputStream(fis);
                try
                {
                    obj = (Object) arc.readObject();
                } catch (IOException | ClassNotFoundException e)
                {
                    System.out.println("Objeto no encontrado.");
                }
                arc.close();
            } catch (IOException e)
            {
                System.out.println("No se pudo leer el archivo.");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("No se encontro el archivo.");
        }

        return obj;
    }
    
    public static Object[][] carga(String cad, boolean b)
    {
        Object obj[][] = null;
        try
        {
            FileInputStream fis = new FileInputStream("Datos/" + cad);
            try
            {
                ObjectInputStream arc = new ObjectInputStream(fis);
                try
                {
                    obj = (Object[][]) arc.readObject();
                } catch (IOException | ClassNotFoundException e)
                {
                    System.out.println("Objeto no encontrado.");
                }
                arc.close();
            } catch (IOException e)
            {
                System.out.println("No se pudo leer el archivo.");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("No se encontro el archivo.");
        }

        return obj;
    }
}
