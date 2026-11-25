package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static final String URL_BD = "jdbc:mysql://localhost:3306/sistema_prematricula?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO_BD = "root";
   private static final String CLAVE_BD = "1234";
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL_BD, USUARIO_BD, CLAVE_BD);
    }
}