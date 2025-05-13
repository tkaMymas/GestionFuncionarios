package models;

import java.util.Date;

public class Funcionario {
    private int idFuncionario, edad;
    private String tipoIdentifidacion, numeroIdentificacion;
    private String nombres, apellidos, estadoCivil, sexo, direccion, telefono;
    private Date fechaNacimiento;

    public Funcionario(int idFuncionario, String tipoIdentifidacion, String numeroIdentificacion, String nombres,
                       String apellidos, String estadoCivil, int edad, String sexo, String direccion,
                       String telefono, Date fechaNacimiento) {
        this.idFuncionario = idFuncionario;
        this.tipoIdentifidacion = tipoIdentifidacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estadoCivil = estadoCivil;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Funcionario() {

    }

    // ID Funcionario
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    // Tipo Identificación
    public String getTipoIdentificacion() {
        return tipoIdentifidacion;
    }
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentifidacion = tipoIdentificacion;
    }

    // Número Identificación
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    // Nombres
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Apellidos
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Estado Civil
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    // Edad
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    // Sexo
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Dirección
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Telefono
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Fecha Nacimiiento
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}