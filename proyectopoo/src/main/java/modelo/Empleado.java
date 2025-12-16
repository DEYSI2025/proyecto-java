package modelo;

import java.sql.Date;

public class Empleado {

    private int id;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String correo;
    private String cargo;
    private double sueldo;
    private String estado;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
