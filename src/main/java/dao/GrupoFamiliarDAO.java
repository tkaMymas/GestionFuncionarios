package dao;

import models.GrupoFamiliar;
import services.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoFamiliarDAO {
    public boolean createGrupoFamiliar(GrupoFamiliar familiar) {
        String query = "INSERT INTO grupo_familiar (id_funcionario, nombres, apellidos, parentesco, edad) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, familiar.getIdFuncionario());
            stmt.setString(2, familiar.getNombres());
            stmt.setString(3, familiar.getApellidos());
            stmt.setString(4, familiar.getParentesco());
            stmt.setInt(5, familiar.getEdad());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar familiar: " + e.getMessage());
            return false;
        }
    }

    public GrupoFamiliar getGrupoFamiliarById(int id) {
        String query = "SELECT * FROM grupo_familiar WHERE id_familiar = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new GrupoFamiliar(
                        rs.getInt("id_familiar"),
                        rs.getInt("id_funcionario"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("parentesco"),
                        rs.getInt("edad")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener familiar: " + e.getMessage());
        }
        return null;
    }

    public List<GrupoFamiliar> getAllFamiliares() {
        List<GrupoFamiliar> familiares = new ArrayList<>();
        String query = "SELECT * FROM grupo_familiar";

        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                familiares.add(new GrupoFamiliar(
                        rs.getInt("id_familiar"),
                        rs.getInt("id_funcionario"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("parentesco"),
                        rs.getInt("edad")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar familiares: " + e.getMessage());
        }
        return familiares;
    }

    public boolean updateGrupoFamiliar(GrupoFamiliar familiar) {
        String query = "UPDATE grupo_familiar SET id_funcionario = ?, nombres = ?, apellidos = ?,  parentesco = ?, edad = ? WHERE id_familiar = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, familiar.getIdFuncionario());
            stmt.setString(2, familiar.getNombres());
            stmt.setString(3, familiar.getApellidos());
            stmt.setString(4, familiar.getParentesco());
            stmt.setInt(5, familiar.getEdad());
            stmt.setInt(6, familiar.getIdFamiliar());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar familiar: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteGrupoFamiliar(int id) {
        String query = "DELETE FROM grupo_familiar WHERE id_familiar = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar familiar: " + e.getMessage());
            return false;
        }
    }
}