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
public class Departamento implements Serializable
{

    public static final long SerialVersionUID = 1L;
    private String nombre;
    private int cve;
    private double presupuesto;
    private long telefono;

    public Departamento()
    {
    }

    public Departamento(String nombre, int cve, double presupuesto, long telefono)
    {
        this.nombre = nombre;
        this.cve = cve;
        this.presupuesto = presupuesto;
        this.telefono = telefono;
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
     * @return the cve
     */
    public int getCve()
    {
        return cve;
    }

    /**
     * @param cve the cve to set
     */
    public void setCve(int cve)
    {
        this.cve = cve;
    }

    /**
     * @return the presupuesto
     */
    public double getPresupuesto()
    {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(double presupuesto)
    {
        this.presupuesto = presupuesto;
    }

    /**
     * @return the telefono
     */
    public long getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono)
    {
        this.telefono = telefono;
    }

}
