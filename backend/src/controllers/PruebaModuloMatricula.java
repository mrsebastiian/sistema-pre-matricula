
package controllers;

import models.SolicitudMatricula;
import java.util.List;

public class PruebaModuloMatricula {

    public static void main(String[] args) {
        SolicitudMatriculaDAO dao = new SolicitudMatriculaDAO();

        // 1. Inserción (Create)
        SolicitudMatricula nuevaSolicitud = new SolicitudMatricula(
            0,
            "1012345678",
            "Carlos Perez",
            "Decimo",
            "PENDIENTE"
        );
        boolean insertado = dao.insertarSolicitud(nuevaSolicitud);
        System.out.println("Insertado: " + insertado);

        // 2. Consulta (Read)
        List<SolicitudMatricula> lista = dao.consultarSolicitudes();
        System.out.println("Total registros consultados: " + lista.size());
        for (SolicitudMatricula item : lista) {
            System.out.println(
                item.getId() + " | " +
                item.getNumeroDocumento() + " | " +
                item.getNombreAspirante() + " | " +
                item.getGradoSolicitado() + " | " +
                item.getEstadoMatricula()
            );
        }

        // 3. Actualización (Update) y 4. Eliminación (Delete) sobre el último registro insertado
        if (!lista.isEmpty()) {
            int idObjetivo = lista.get(lista.size() - 1).getId();

            boolean actualizado = dao.actualizarEstadoSolicitud(idObjetivo, "APROBADA");
            System.out.println("Actualizado ID " + idObjetivo + ": " + actualizado);

            boolean eliminado = dao.eliminarSolicitud(idObjetivo);
            System.out.println("Eliminado ID " + idObjetivo + ": " + eliminado);
        }
    }
}