package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String email;
    protected LocalDate fechaNacimiento;
    protected String contrasena;

    public Usuario(int id, String nombre, String email, LocalDate fechaNacimiento, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDatos() {
        return "ID: " + id + ", Nombre: " + nombre + ", Email: " + email+ "FechaNacimiento: "+ fechaNacimiento;
    }
}