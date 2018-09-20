import java.sql.*;

public class Conexion{
    public Connection conex;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //llama la ruta de la libreria agregada
            conex = DriverManager.getConnection("jdbc:mysql://localhost/conexionmysqlcorba","root","");
            System.out.println("Conexión Establecida");
        } catch (Exception e) {
        }
        return conex;
    }
}
