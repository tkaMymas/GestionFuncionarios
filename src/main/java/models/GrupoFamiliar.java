package models;

public class GrupoFamiliar {
    private int idFamiliar, idFuncionario, edad;
    private String nombres, apellidos, parentesco;

    public GrupoFamiliar(int idFamiliar, int idFuncionario, String nombres,
                         String apellidos, String parentesco, int edad) {
        this.idFamiliar = idFamiliar;
        this.idFuncionario = idFuncionario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.parentesco = parentesco;
        this.edad = edad;
    }
    // Id Familiar
    public int getIdFamiliar() {
        return idFamiliar;
    }
    public void setIdFamiliar(int idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    // Id Funcionario
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    // Parentesco
    public String getParentesco() {
        return parentesco;
    }
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    // Edad
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}