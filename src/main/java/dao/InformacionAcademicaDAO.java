package dao;

import models.InformacionAcademica;
import services.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformacionAcademicaDAO {
    public boolean createInformacionAcademica(InformacionAcademica infoAcademica) {
        String query = "INSERT INTO informacion_academica (id_funcionario, universidad, nivel_estudio, titulo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, infoAcademica.getIdFuncionario());
            stmt.setString(2, infoAcademica.getUniversidad());
            stmt.setString(3, infoAcademica.getNivelEstudio());
            stmt.setString(4, infoAcademica.getTitulo());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar información académica: " + e.getMessage());
            return false;
        }
    }

    public InformacionAcademica getInformacionAcademicaById(int id) {
        String query = "SELECT * FROM informacion_academica WHERE id_academico = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new InformacionAcademica(
                        rs.getInt("id_academico"),
                        rs.getInt("id_funcionario"),
                        rs.getString("universidad"),
                        rs.getString("nivel_estudio"),
                        rs.getString("titulo")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener información académica: " + e.getMessage());
        }
        return null;
    }

    public List<InformacionAcademica> getAllInformacionAcademica() {
        List<InformacionAcademica> listaAcademica = new ArrayList<>();
        String query = "SELECT * FROM informacion_academica";

        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                listaAcademica.add(new InformacionAcademica(
                        rs.getInt("id_academico"),
                        rs.getInt("id_funcionario"),
                        rs.getString("universidad"),
                        rs.getString("nivel_estudio"),
                        rs.getString("titulo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar información académica: " + e.getMessage());
        }
        return listaAcademica;
    }

    public boolean updateInformacionAcademica(InformacionAcademica infoAcademica) {
        String query = "UPDATE informacion_academica SET id_funcionario = ?, universidad = ?, nivel_estudio = ?, titulo = ? WHERE id_academico = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, infoAcademica.getIdFuncionario());
            stmt.setString(2, infoAcademica.getUniversidad());
            stmt.setString(3, infoAcademica.getNivelEstudio());
            stmt.setString(4, infoAcademica.getTitulo());
            stmt.setInt(5, infoAcademica.getIdAcademico());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar información académica: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteInformacionAcademica(int id) {
        String query = "DELETE FROM informacion_academica WHERE id_academico = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar información académica: " + e.getMessage());
            return false;
        }
    }
}