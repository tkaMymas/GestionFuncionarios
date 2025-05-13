package dao;

import models.Funcionario;
import services.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public boolean createFuncionario(Funcionario funcionario) {
        String query = "INSERT INTO funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, edad, sexo, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, funcionario.getTipoIdentificacion());
            stmt.setString(2, funcionario.getNumeroIdentificacion());
            stmt.setString(3, funcionario.getNombres());
            stmt.setString(4, funcionario.getApellidos());
            stmt.setString(5, funcionario.getEstadoCivil());
            stmt.setInt(6, funcionario.getEdad());
            stmt.setString(7, funcionario.getSexo());
            stmt.setString(8, funcionario.getDireccion());
            stmt.setString(9, funcionario.getTelefono());
            stmt.setDate(10, new java.sql.Date(funcionario.getFechaNacimiento().getTime()));

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar funcionario: " + e.getMessage());
            return false;
        }
    }

    public Funcionario getFuncionarioById(int id) {
        String query = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("tipo_identificacion"),
                        rs.getString("numero_identificacion"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("estado_civil"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_nacimiento")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener funcionario: " + e.getMessage());
        }
        return null;
    }

    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM funcionarios";

        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                funcionarios.add(new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("tipo_identificacion"),
                        rs.getString("numero_identificacion"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("estado_civil"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_nacimiento")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar funcionarios: " + e.getMessage());
        }
        return funcionarios;
    }

    public boolean updateFuncionario(Funcionario funcionario) {
        String query = "UPDATE funcionarios SET tipo_identificacion = ?, numero_identificacion = ?, nombres = ?, apellidos = ?, estado_civil = ?, edad = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ? WHERE id_funcionario = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, funcionario.getTipoIdentificacion());
            stmt.setString(2, funcionario.getNumeroIdentificacion());
            stmt.setString(3, funcionario.getNombres());
            stmt.setString(4, funcionario.getApellidos());
            stmt.setString(5, funcionario.getEstadoCivil());
            stmt.setInt(6, funcionario.getEdad());
            stmt.setString(7, funcionario.getSexo());
            stmt.setString(8, funcionario.getDireccion());
            stmt.setString(9, funcionario.getTelefono());
            stmt.setDate(10, new java.sql.Date(funcionario.getFechaNacimiento().getTime()));
            stmt.setInt(11, funcionario.getIdFuncionario());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar funcionario: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteFuncionario(int id) {
        String query = "DELETE FROM funcionarios WHERE id_funcionario = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar funcionario: " + e.getMessage());
            return false;
        }
    }
}