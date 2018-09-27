import java.sql.*;
import Terceros.*;

public class Terceros extends TerceroPOA{
    Conexion objConexion = new Conexion();

    @Override
    public boolean insertarTercero(String nombre, String apellido, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarTercero(int id, String nombre, String apellido, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTercero(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarTercero(int id) {
           String resultado ="";
             
        try {
            String sqlConsultar = "Select  * from terceros where id = "+id;
            objConexion.conectar();
            Statement  st= objConexion.conectar().createStatement();
            ResultSet rs= st.executeQuery(sqlConsultar);
            
            while (rs.next()) {
                resultado +=rs.getString(2)+ "-"
                        +rs.getString(3)+ "-"
                        +rs.getString(4);
            }
        } catch (Exception e) {
        }
        return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
