package DAO;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */


import java.sql.*;

class SQLiteDAO {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:mibasededatos.db";

        try {
            Connection conexion = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con SQLite.");

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void crearTablaEjemplo(Connection conexion) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "email TEXT UNIQUE," +
                "edad INTEGER" +
                ");";

        try (Statement stmt = conexion.createStatement()) {
            stmt.execute(sql);
        }
    }

    private static void insertarDatosEjemplo(Connection conexion) throws SQLException {
        // Limpiar datos existentes
        try (Statement stmt = conexion.createStatement()) {
            stmt.execute("DELETE FROM usuarios");
        }

        // Insertar con PreparedStatement
        String sql = "INSERT INTO usuarios (nombre, email, edad) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Usuario 1
            pstmt.setString(1, "Ana");
            pstmt.setString(2, "ana@ejemplo.com");
            pstmt.setInt(3, 28);
            pstmt.executeUpdate();

            // Usuario 2
            pstmt.setString(1, "Carlos");
            pstmt.setString(2, "carlos@ejemplo.com");
            pstmt.setInt(3, 35);
            pstmt.executeUpdate();

            // Usuario 3
            pstmt.setString(1, "María");
            pstmt.setString(2, "maria@ejemplo.com");
            pstmt.setInt(3, 42);
            pstmt.executeUpdate();

            // Usuario 4
            pstmt.setString(1, "Juan");
            pstmt.setString(2, "juan@ejemplo.com");
            pstmt.setInt(3, 19);
            pstmt.executeUpdate();

            System.out.println("Datos de ejemplo insertados.");
        }
    }

    // Búsqueda por nombre exacto
    private static void buscarPorNombre(Connection conexion, String nombre) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Usuarios con nombre: " + nombre + " ---");
                mostrarResultados(rs);
            }
        }
    }

    // Búsqueda por edad mínima
    private static void buscarPorEdadMinima(Connection conexion, int edadMinima) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE edad >= ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, edadMinima);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Usuarios con edad mínima de " + edadMinima + " años ---");
                mostrarResultados(rs);
            }
        }
    }

    // Búsqueda por rango de edad
    private static void buscarPorRangoDeEdad(Connection conexion, int edadMin, int edadMax) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE edad BETWEEN ? AND ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, edadMin);
            pstmt.setInt(2, edadMax);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Usuarios con edad entre " + edadMin + " y " + edadMax + " años ---");
                mostrarResultados(rs);
            }
        }
    }

    // Método auxiliar para mostrar resultados
    private static void mostrarResultados(ResultSet rs) throws SQLException {
        boolean hayResultados = false;

        while (rs.next()) {
            hayResultados = true;
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String email = rs.getString("email");
            int edad = rs.getInt("edad");

            System.out.printf("ID: %d, Nombre: %s, Email: %s, Edad: %d\n",
                    id, nombre, email, edad);
        }

        if (!hayResultados) {
            System.out.println("No se encontraron resultados.");
        }
    }
}