/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.io.Serializable;

/**
 *
 * @author Mar
 */
public class Personal implements Serializable
{

    public static final long SerialVersionUID = 1L;
    private String nombre;
    private String direccion;
    private int cveEmpleado;
    private boolean jefe;

    public Personal()
    {
    }

    public Personal(String nombre, String direccion, int cveEmpleado, boolean jefe)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cveEmpleado = cveEmpleado;
        this.jefe = jefe;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    /**
     * @return the cveEmpleado
     */
    public int getCveEmpleado()
    {
        return cveEmpleado;
    }

    /**
     * @param cveEmpleado the cveEmpleado to set
     */
    public void setCveEmpleado(int cveEmpleado)
    {
        this.cveEmpleado = cveEmpleado;
    }

    /**
     * @return the jefe
     */
    public boolean isJefe()
    {
        return jefe;
    }

    /**
     * @param jefe the jefe to set
     */
    public void setJefe(boolean jefe)
    {
        this.jefe = jefe;
    }

    public String desp()
    {
        return "Nombre: " + getNombre() + "\n"
                + "Clave empelado: " + getCveEmpleado() + "\n"
                + "Direccion: " + getDireccion() + "\n";
    }
}
