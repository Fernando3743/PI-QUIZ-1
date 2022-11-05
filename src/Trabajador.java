/*
* Clase que representa a un trabajador de la empresa Rica Empanada
 */

/**
 *
 * @author LeovivianaM
 */
public class Trabajador {
    
    /**
     * Atributos de la clase Trabajador
     */
    private String nombre, cc, cargo;
    private double salario;
    private int aVinculacion,mesVinculacion, diaVinculacion;
    
    /**
     * Constructor de la clase trabajador
     * @param nombre
     * @param cc
     * @param cargo
     * @param salario
     * @param aVinculacion 
     * @param mesVinculacion 
     * @param diaVinculacion 
     */
    public Trabajador(String nombre, String cc, String cargo, double salario, int aVinculacion, int mesVinculacion, int diaVinculacion) {
        this.nombre = nombre;
        this.cc = cc;
        this.cargo = cargo;
        this.salario = salario;
        this.aVinculacion = aVinculacion;
        this.mesVinculacion = mesVinculacion;
        this.diaVinculacion = diaVinculacion;
    }

    public int getMesVinculacion() {
        return mesVinculacion;
    }

    public int getDiaVinculacion() {
        return diaVinculacion;
    }

    /**
     * Método que retorna el nombre del trabajador
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que retorna la identificación del trabajador
     * @return 
     */
    public String getCc() {
        return cc;
    }

    /**
     * Método que retorna el cargo del trabajador
     * @return 
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Método que retorna el salario del trabajador
     * @return 
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Método que retorna el año de vinculación del trabajador
     * @return 
     */
    public int getaVinculacion() {
        return aVinculacion;
    }
    
    public String getFechaVinculacion () {
        return String.format("%s/%s/%s", diaVinculacion, mesVinculacion, aVinculacion);
    }
    
    /**
     * Método que retorna todos los datos de un trabajador
     * @return 
     */
    public String getDatosTrabajador()
    {
        return nombre+"\t"+cc+"\t"+cargo+"\t"+salario+"\t"+aVinculacion+"\t"+mesVinculacion+"\t"+diaVinculacion;        
    }
    
}
