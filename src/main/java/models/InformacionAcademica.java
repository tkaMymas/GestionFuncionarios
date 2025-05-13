package models;

public class InformacionAcademica {
    private int idAcademico, idFuncionario;
    private String universidad, nivelEstudio, titulo;

    public InformacionAcademica(int idAcademico, int idFuncionario,
                                String universidad, String nivelEstudio, String titulo) {
        this.idAcademico = idAcademico;
        this.idFuncionario = idFuncionario;
        this.universidad = universidad;
        this.nivelEstudio = nivelEstudio;
        this.titulo = titulo;
    }
    // Id Academico
    public int getIdAcademico() {
        return idAcademico;
    }
    public void setIdAcademico(int idAcademico) {
        this.idAcademico = idAcademico;
    }

    // Id Funcionario
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    // Universidad
    public String getUniversidad() {
        return universidad;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    // Nivel Estudio
    public String getNivelEstudio() {
        return nivelEstudio;
    }
    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    // Titulo
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}