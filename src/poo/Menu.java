/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.util.Scanner;

/**
 *
 * @author Mar
 */
public class Menu
{

    String[] menu =
    {
        "Registrar departamento.", "Modificar presupuesto o telefono.", "Consultar departamentos.", "Registrar personal.", "Consultar personal por departamento.", "Consultar jefes.", "Cambiar jefe.", "Mostrar el departamento con mas empleados.", "Coincidencias de nombre.", "Salir."
    };
    Scanner sc = new Scanner(System.in);
    Manipula man = new Manipula();

    public void menu()
    {
        int opc;

        do
        {
            System.out.println("********************Menu*********************");
            for (int i = 0; i < menu.length; i++)
            {
                System.out.println((i + 1) + ") " + menu[i]);
            }
            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();
            sc.nextLine();
            System.out.println("*********************************************");

            opciones(opc);
        } while (opc != menu.length);
    }

    public void opciones(int opc)
    {
        int clave;
        String nombre;

        switch (opc)
        {
            case 1:
                man.ingresarDepto();
                break;
            case 2:
                man.modificar();
                break;
            case 3:
                man.mostrarDepartamentos();
                break;
            case 4:
                man.registrarPersonal();
                break;
            case 5:
                man.consultarPersonal();
                break;
            case 6:
                man.consultarJefes();
                break;
            case 7:
                System.out.println("Ingresa la clave del departamento: ");
                clave = sc.nextInt();
                man.cambiarJefe(clave);
                break;
            case 8:
                man.masEmpleados();
                break;

            case 9:
                System.out.println("Ingresa el nombre: ");
                nombre = sc.nextLine();
                man.coincidencias(nombre);
                break;

            case 10:
                System.out.println("\nSaliendo...\n");
                break;

            default:
                System.out.println("\nOpcion invalida\n");
        }
    }
}
