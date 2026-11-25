package controllers;

import config.ConexionBaseDatos;
import models.SolicitudMatricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitudMatriculaDAO {

    public boolean insertarSolicitud(SolicitudMatricula solicitud) {
        String sql = "INSERT INTO solicitudes_matricula (numero_documento, nombre_aspirante, grado_solicitado, estado_matricula) VALUES (?, ?, ?, ?)";
        try (Connection conexion = ConexionBaseDatos.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, solicitud.getNumeroDocumento());
            sentencia.setString(2, solicitud.getNombreAspirante());
            sentencia.setString(3, solicitud.getGradoSolicitado());
            sentencia.setString(4, solicitud.getEstadoMatricula());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar la solicitud: " + e.getMessage());
            return false;
        }
    }

    public List<SolicitudMatricula> consultarSolicitudes() {
        List<SolicitudMatricula> solicitudes = new ArrayList<>();
        String sql = "SELECT id, numero_documento, nombre_aspirante, grado_solicitado, estado_matricula FROM solicitudes_matricula";

        try (Connection conexion = ConexionBaseDatos.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                solicitudes.add(new SolicitudMatricula(
                    resultado.getInt("id"),
                    resultado.getString("numero_documento"),
                    resultado.getString("nombre_aspirante"),
                    resultado.getString("grado_solicitado"),
                    resultado.getString("estado_matricula")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar las solicitudes: " + e.getMessage());
        }
        return solicitudes;
    }

    public boolean actualizarEstadoSolicitud(int idSolicitud, String nuevoEstado) {
        String sql = "UPDATE solicitudes_matricula SET estado_matricula = ? WHERE id = ?";
        try (Connection conexion = ConexionBaseDatos.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, nuevoEstado);
            sentencia.setInt(2, idSolicitud);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el estado: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarSolicitud(SolicitudMatricula solicitud) {
        String sql = "UPDATE solicitudes_matricula "
                   + "SET nombre_aspirante = ?, grado_solicitado = ?, estado_matricula = ? "
                   + "WHERE numero_documento = ?";

        try (Connection conexion = ConexionBaseDatos.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, solicitud.getNombreAspirante());
            sentencia.setString(2, solicitud.getGradoSolicitado());
            sentencia.setString(3, solicitud.getEstadoMatricula());
            sentencia.setString(4, solicitud.getNumeroDocumento());

            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la solicitud: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarSolicitud(int idSolicitud) {
        String sql = "DELETE FROM solicitudes_matricula WHERE id = ?";
        try (Connection conexion = ConexionBaseDatos.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idSolicitud);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la solicitud: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarSolicitud(String numeroDocumento) {
        String sql = "DELETE FROM solicitudes_matricula WHERE numero_documento = ?";

        try (Connection conexion = ConexionBaseDatos.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, numeroDocumento);

            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la solicitud: " + e.getMessage());
            return false;
        }
    }
}