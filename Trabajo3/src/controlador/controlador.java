package controlador;

import ConexionBD.Conexion; // importa la clase exacta
import modelo.Seguro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para operaciones CRUD de seguros
 * @author Central Gamer
 */
public class Controlador {

    public boolean agregarSeguro(Seguro seguro) {
        String sql = "INSERT INTO Seguro (nombre, descripcionGeneral, descripcionDetallada, porcentajeCobertura) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, seguro.getNombre());
            ps.setString(2, seguro.getDescripcionGeneral());
            ps.setString(3, seguro.getDescripcionDetallada());
            ps.setDouble(4, seguro.getPorcentajeCobertura());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al agregar Seguro: " + e.getMessage());
            return false;
        }
    }

    public List<Seguro> listarSeguros() {
        List<Seguro> seguros = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcionGeneral, descripcionDetallada, porcentajeCobertura FROM Seguro ORDER BY id DESC";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Seguro s = new Seguro(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcionGeneral"),
                        rs.getString("descripcionDetallada"),
                        rs.getDouble("porcentajeCobertura")
                );
                seguros.add(s);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar Seguros: " + e.getMessage());
        }
        return seguros;
    }

    public boolean eliminarSeguro(Seguro seguro) {
        String sql = "DELETE FROM Seguro WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, seguro.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar Seguro: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarSeguro(Seguro seguro) {
        String sql = "UPDATE Seguro SET nombre = ?, descripcionGeneral = ?, descripcionDetallada = ?, porcentajeCobertura = ? WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, seguro.getNombre());
            ps.setString(2, seguro.getDescripcionGeneral());
            ps.setString(3, seguro.getDescripcionDetallada());
            ps.setDouble(4, seguro.getPorcentajeCobertura());
            ps.setInt(5, seguro.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar Seguro: " + e.getMessage());
            return false;
        }
    }
}
