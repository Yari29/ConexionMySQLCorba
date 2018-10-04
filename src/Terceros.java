import java.sql.*;
import Terceros.*;
import javax.swing.JOptionPane;

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
            rs.close();
            //cerrar las conexiones
            objConexion.conex.close();
        } catch (Exception e) {
        }
        return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTercero(){
        ResultSet resultado = null;
        
        try {
            String sql = "Select nombres,apellidos,telefono from terceros"
                    + "";
            objConexion.conectar(); //abrir la conexión
            Statement st = objConexion.conex.createStatement();
            resultado = st.executeQuery(sql);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
        }
        
        return resultado;
    }
    
}
