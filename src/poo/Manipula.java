/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;

import java.util.Scanner;

/**
 *
 * @author Mar
 */
public class Manipula
{

    public static final String LEYENDA_ALTA = "Ingresa el presupuesto para el departamento: ";
    public static final String LEYENDA_MODIFICA = "Ingresa el presupuesto nuevo para el departamento: ";
    public static final String LEYENDA_ALTA_TELEFONO = "Ingresa el telefono para el departamento: ";
    public static final String LEYENDA_MODIFICA_TELEFONO = "Ingresa el telefono nuevo para el departamento: ";
    public static final String CLAVE = "Clave";
    public static final String NOMBRE = "Nombre";
    public static final String DIRECCION = "Direccion";
    public static final String PRESUPUESTO = "Presupuesto";
    public static final String TELEFONO = "Telefono";
    public static final String DEPARTAMENTO = "Departamento";
    public static final String JEFE = "Jefe";

    private Departamento departamentos[] = null;
    private Personal empleados[][] = null;

    Scanner sc = new Scanner(System.in);

    public Manipula()
    {
    }

    public Departamento[] getDepartamentos()
    {
        return departamentos;
    }

    public void setDepartamentos(Departamento[] departamentos)
    {
        this.departamentos = departamentos;
    }

    public Personal[][] getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(Personal[][] empleados)
    {
        this.empleados = empleados;
    }

    public void registrarDepto(Departamento dep)
    {
        if (departamentos == null)
        {
            departamentos = new Departamento[1];
            departamentos[0] = dep;
        } else
        {
            Departamento[] tmp = new Departamento[departamentos.length + 1];
            System.arraycopy(departamentos, 0, tmp, 0, departamentos.length);
            tmp[departamentos.length] = dep;
            departamentos = tmp;
        }
    }

    public void ingresarDepto()
    {
        Departamento dep = new Departamento();

        dep.setNombre(leerNombre());
        dep.setCve(leerClave());
        dep.setPresupuesto(leerPresupuesto(LEYENDA_ALTA));
        dep.setTelefono(leerTelefono(LEYENDA_ALTA_TELEFONO));

        registrarDepto(dep);
        System.out.println("Departamento registrado correctamente.\n");
    }

    public String leerNombre()
    {
        String nombre = null;
        boolean valido = false;

        do
        {
            System.out.print("\nIngresa el nombre del departamento: ");
            nombre = sc.nextLine().trim();

            if (existeNombre(nombre))
            {
                System.out.println("***El nombre del departamento ya existe.***");
            } else
            {
                valido = true;
            }
        } while (!valido);

        return nombre;
    }

    public int leerClave()
    {
        boolean valido = false;
        int clave = -1;

        do
        {
            System.out.print("Ingresa la clave del departamento: ");
            while (!sc.hasNextInt())
            {
                System.out.println("***Debes ingresar un numero valido.***");
                sc.next();
            }
            clave = sc.nextInt();
            sc.nextLine();

            if (clave < 0)
            {
                System.out.println("***La clave no pude ser negativa***");
            } else if (existeClave(clave))
            {
                System.out.println("***La clave del departamento ya existe.***\n");
            } else
            {
                valido = true;
            }
        } while (!valido);

        return clave;
    }

    public float leerPresupuesto(String leyenda)
    {
        boolean valido = false;
        float presupuesto = -1;

        do
        {
            System.out.print(leyenda);
            while (!sc.hasNextFloat())
            {
                System.out.println("Debes ingresar un numero valido para el presupuesto.");
                sc.next();
            }
            presupuesto = sc.nextFloat();

            if (presupuesto < 0)
            {
                System.out.println("***El presupuesto no puede ser negativo.***\n");
            } else
            {
                valido = true;
            }
        } while (!valido);

        return presupuesto;
    }

    public long leerTelefono(String leyenda)
    {
        boolean valido = false;
        long telefono = -1;

        do
        {
            System.out.print(leyenda);
            while (!sc.hasNextLong())
            {
                System.out.println("***Debes ingresar un numero valido para el telefono.***");
                sc.next();
            }
            telefono = sc.nextLong();
            if (String.valueOf(telefono).length() != 10)
            {
                System.out.println("***El telefono debe tener exactamente 10 digitos.***\n");
            } else if (telefono < 0)
            {
                System.out.println("***Telefono no valido.***\n");
            } else
            {
                valido = true;
            }
        } while (!valido);
        sc.nextLine();
        return telefono;
    }

    public boolean existeNombre(String nombre)
    {
        if (departamentos == null)
        {
            return false;
        }

        for (Departamento d : departamentos)
        {
            if (d != null && d.getNombre().equalsIgnoreCase(nombre))
            {
                return true;
            }
        }
        return false;
    }

    public boolean existeClave(int clave)
    {
        if (departamentos == null)
        {
            return false;
        }

        for (Departamento d : departamentos)
        {
            if (d != null && d.getCve() == clave)
            {
                return true;
            }
        }

        return false;
    }

    public void modificar()
    {
        int clv;
        boolean encontrado = false;

        if (departamentos != null && departamentos.length > 0)
        {
            do
            {
                System.out.print("\nIngresa la clave del departamento: ");
                clv = sc.nextInt();
                sc.nextLine();
                int ind = busca(clv);

                if (ind == -1)
                {
                    System.out.println("***No se encontro el departamento.***");
                } else
                {
                    menuModifica(ind);
                    encontrado = true;
                }
            } while (!encontrado);
        } else
        {
            System.out.println("\n***Aun no se ha ingresado ningun departamento.***\n");
        }
    }

    public void menuModifica(int ind)
    {
        int opc;
        boolean continua = false;

        do
        {
            System.out.println("\n-------Menu para modificar-------");
            System.out.println("1. Modificar presupuesto.");
            System.out.println("2. Modificar telefono.");
            System.out.println("-1. Salir.");
            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();

            switch (opc)
            {
                case 1:
                    float presupuesto = leerPresupuesto(LEYENDA_MODIFICA);
                    departamentos[ind].setPresupuesto(presupuesto);
                    continua = true;
                    break;

                case 2:
                    long telefono = leerTelefono(LEYENDA_MODIFICA_TELEFONO);
                    departamentos[ind].setTelefono(telefono);
                    continua = true;
                    break;

                case -1:
                    System.out.println("\nSaliendo...");
                    continua = true;
                    break;

                default:
                    System.out.println("\n***Opcion incorrecta, intente de nuevo.***");
                    break;
            }

        } while (!continua);
        System.out.print("Presione una tecla para continuar...\n");
        sc.nextLine();
    }

    public void mostrarDepartamentos()
    {
        if (departamentos == null || departamentos.length == 0)
        {
            System.out.println("\n***No hay departamentos para mostrar.***");
        } else
        {
            System.out.println(formato(CLAVE) + formato(NOMBRE) + formato(PRESUPUESTO) + formato(TELEFONO));
            System.out.println("--------------------------------------------------------------------------------");

            for (Departamento dep : departamentos)
            {
                if (dep != null)
                {
                    System.out.println(
                            formato(String.valueOf(dep.getCve()))
                            + formato(dep.getNombre())
                            + formato(String.format("%.2f", dep.getPresupuesto()))
                            + formato(String.valueOf(dep.getTelefono()))
                    );
                }
            }
        }
        System.out.print("Presione una tecla para continuar...\n");
        sc.nextLine();
    }

    public void registrarPersonal()
    {
        if (departamentos == null)
        {
            System.out.println("***No se puede ingresar un empleado sin haber ingresado un departamento...***");
            return;
        }
        Personal per = new Personal();
        boolean valido = false;

        System.out.print("\nIngresa el nombre del empleado: ");
        per.setNombre(sc.nextLine());

        per.setCveEmpleado(leerClaveEmpleado());

        per.setJefe(esJefe());

        sc.nextLine();
        System.out.print("Ingresa la direccion del empleado: ");
        per.setDireccion(sc.nextLine());

        do
        {
            System.out.print("Ingresa la clave del departamento: ");
            String inputDepto = sc.nextLine();
            int claveDepto = Integer.parseInt(inputDepto.trim());

            int ind = busca(claveDepto);

            if (ind == -1)
            {
                System.out.println("***No se encontro el departamento.***");
            } else
            {
                valido = true;

                boolean existeJefe = false;
                if (empleados != null && empleados[ind] != null)
                {
                    for (Personal perTmp : empleados[ind])
                    {
                        if (perTmp != null && perTmp.isJefe())
                        {
                            existeJefe = true;
                            break;
                        }
                    }
                }

                if (per.isJefe() && existeJefe)
                {
                    System.out.println("***Ya existe un jefe en el departamento.***");
                    per.setJefe(false);
                }

                insertarEmpleados(ind, per);
                System.out.println("Empleado registrado correctamente.\n");
            }
        } while (!valido);
    }

    public void insertarEmpleados(int indice, Personal empleado)
    {
        if (empleados == null)
        {
            empleados = new Personal[departamentos.length][];
        }

        if (empleados[indice] == null)
        {
            empleados[indice] = new Personal[1];
            empleados[indice][0] = empleado;
        } else
        {
            Personal[] tmpRow = new Personal[empleados[indice].length + 1];
            System.arraycopy(empleados[indice], 0, tmpRow, 0, empleados[indice].length);
            tmpRow[tmpRow.length - 1] = empleado;
            empleados[indice] = tmpRow;
        }

    }

    public int busca(int clv)
    {
        if (departamentos == null || departamentos.length == 0)
        {
            return -1;
        }

        for (int i = 0; i < departamentos.length; i++)
        {
            if (departamentos[i].getCve() == clv)
            {
                return i;
            }
        }

        return -1;
    }

    public boolean esJefe()
    {
        char resp;
        boolean jefe = false;

        do
        {
            System.out.print("Es jefe (S/N): ");
            resp = sc.next().charAt(0);
            if (resp == 'S' || resp == 's')
            {
                jefe = true;
            } else if (resp == 'N' || resp == 'n')
            {
                jefe = false;
            } else
            {
                System.out.println("***Opcion invalida, intenta de nuevo.***");
            }
        } while (resp != 'S' && resp != 's' && resp != 'N' && resp != 'n');

        return jefe;
    }

    public void consultarPersonal()
    {
        if (empleados == null || empleados.length == 0)
        {
            System.out.println("\n***No hay empleados registrados.***\n");
            return;
        }

        System.out.print("Ingresa la clave del departamento: ");
        int claveDepto = sc.nextInt();
        int indice = busca(claveDepto);

        if (indice == -1)
        {
            System.out.println("***No se encontró el departamento.***");
            return;
        }

        System.out.println("\nCve departamento: " + departamentos[indice].getCve());
        System.out.println("Nombre departamento: " + departamentos[indice].getNombre() + "\n");
        System.out.println(formato(CLAVE) + formato(NOMBRE) + formato(DIRECCION));
        System.out.println("------------------------------------------------------------");

        for (Personal emp : empleados[indice])
        {
            if (emp != null && emp.isJefe())
            {
                System.out.println(formato(String.valueOf(emp.getCveEmpleado())) + formato(emp.getNombre()) + formato(emp.getDireccion()));
            }
        }

        for (Personal emp : empleados[indice])
        {
            if (emp != null && !emp.isJefe())
            {
                System.out.println(formato(String.valueOf(emp.getCveEmpleado())) + formato(emp.getNombre()) + formato(emp.getDireccion()));
            }
        }

        System.out.print("Presione una tecla para continuar...\n");
        sc.nextLine();
        sc.nextLine();
    }

    public void consultarJefes()
    {
        if (empleados == null || empleados.length == 0)
        {
            System.out.println("\n***No hay empleados registrados.***\n");
            return;
        }

        System.out.println("Lista de jefes por departamento:");
        System.out.println(formato(DEPARTAMENTO) + formato(JEFE));
        System.out.println("----------------------------------------");

        for (int i = 0; i < empleados.length; i++)
        {
            if (empleados[i] != null)
            {
                System.out.print(formato(departamentos[i].getNombre()));
                boolean hayJefe = false;
                for (Personal emp : empleados[i])
                {
                    if (emp != null && emp.isJefe())
                    {
                        System.out.print(formato(emp.getNombre()));
                        hayJefe = true;
                    }
                }
                if (!hayJefe)
                {
                    System.out.print(formato("No hay jefe registrado"));
                }
                System.out.println();
            }
        }
        System.out.print("Presione una tecla para continuar...\n");
        sc.nextLine();
    }

    public int leerClaveEmpleado()
    {
        boolean valido = false;
        int clave = -1;

        do
        {
            System.out.print("Ingresa la clave del empleado: ");
            while (!sc.hasNextInt())
            {
                System.out.println("***Debes ingresar un numero valido.***");
                sc.next();
            }
            clave = sc.nextInt();

            if (clave < 0)
            {
                System.out.println("***La clave no puede ser negativa.***");
            } else if (existeClaveEmpleado(clave))
            {
                System.out.println("***La clave del empleado ya existe.***");
            } else
            {
                valido = true;
            }
        } while (!valido);

        return clave;
    }

    public boolean existeClaveEmpleado(int clave)
    {
        if (empleados == null)
        {
            return false;
        }

        for (Personal[] emp : empleados)
        {
            if (emp != null)
            {
                for (Personal p : emp)
                {
                    if (p != null && p.getCveEmpleado() == clave)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String formato(String cadena)
    {

        for (int i = cadena.length(); i < 20; i++)
        {
            cadena += " ";
        }

        return cadena;
    }

    public void cambiarJefe(int clv)
    {
        int ind = busca(clv);

        if (ind == -1)
        {
            System.out.println("Departamento no encontrado");
            return;
        }

        if (empleados == null || empleados[ind] == null || empleados[ind].length == 0)
        {
            System.out.println("Aun no hay empleados registrados en el departamento.");
            return;
        }

        boolean jefeEncontrado = false;

        for (int j = 0; j < empleados[ind].length; j++)
        {
            if (empleados[ind][j] != null)
            {
                if (empleados[ind][j].isJefe())
                {
                    System.out.println("Jefe actual: " + empleados[ind][j].getNombre() + " (Clave: " + empleados[ind][j].getCveEmpleado() + ")");
                    jefeEncontrado = true;
                } else
                {
                    System.out.println("Empleado: " + empleados[ind][j].getNombre() + " (Clave: " + empleados[ind][j].getCveEmpleado() + ")");
                }
            }
        }

        if (!jefeEncontrado)
        {
            System.out.println("No hay jefe registrado en este momento.");
        }

        System.out.println("Ingresa la clave del nuevo jefe: ");
        int nuevaClave = sc.nextInt();
        sc.nextLine();

        boolean empleadoExiste = false;

        for (int j = 0; j < empleados[ind].length; j++)
        {
            if (empleados[ind][j] != null)
            {
                if (empleados[ind][j].getCveEmpleado() == nuevaClave)
                {
                    empleados[ind][j].setJefe(true);
                    empleadoExiste = true;
                } else
                {
                    empleados[ind][j].setJefe(false);
                }
            }
        }

        if (!empleadoExiste)
        {
            System.out.println("No se encontro un empleado con la clave proporcionada en este departamento.");
        }

        System.out.print("Presione una tecla para continuar...\n");
        sc.nextLine();
    }

    public void masEmpleados()
    {
        if (departamentos == null || departamentos.length == 0)
        {
            System.out.println("Aun no se ha registrado ningun departamento");
            return;
        }

        if (empleados == null || empleados.length == 0)
        {
            System.out.println("Aun no hay empleados registrados.");
            return;
        }

        int maxEmpleados = 0;
        String nombreDepartamento = "";

        for (int i = 0; i < empleados.length; i++)
        {
            int cantidadEmpleados = 0;
            for (Personal emp : empleados[i])
            {
                if (emp != null)
                {
                    cantidadEmpleados++;
                }
            }

            if (cantidadEmpleados > maxEmpleados)
            {
                maxEmpleados = cantidadEmpleados;
                nombreDepartamento = departamentos[i].getNombre();
            }
        }

        if (maxEmpleados > 0)
        {
            System.out.println("El departamento con mas empleados es: " + nombreDepartamento + " con " + maxEmpleados + " empleados.");
        } else
        {
            System.out.println("No hay empleados registrados.");
        }
    }

    public void coincidencias(String nombre)
    {
        if (departamentos == null || departamentos.length == 0)
        {
            System.out.println("Aun no se ha registrado ningun departamento");
            return;
        }

        if (empleados == null || empleados.length == 0)
        {
            System.out.println("Aun no hay empleados registrados.");
            return;
        }

        int contador = 0;

        for (int i = 0; i < empleados.length; i++)
        {
            for (Personal emp : empleados[i])
            {
                if (emp != null && emp.getNombre().equalsIgnoreCase(nombre))
                {
                    contador++;
                    System.out.println("Coincidencia encontrada en el departamento: " + departamentos[i].getNombre());
                }
            }
        }

        if (contador > 0)
        {
            System.out.println("Se ha encontrado " + contador + " coincidencias con el nombre proporcionado.");
        } else
        {
            System.out.println("No se encontraron coincidencias.");
        }
    }
    //No hagas olas - pelicula francesa :)
}
