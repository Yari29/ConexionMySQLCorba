import java.sql.*;
import Terceros.*;
import javax.swing.JOptionPane;

public class Terceros extends TerceroPOA{
    Conexion objConexion = new Conexion();

    @Override
    public boolean insertarTercero(String nombre, String apellido, String telefono) {
        boolean resultado = false;
        try {
            String sqlInsertar="insert into terceros (nombres,apellidos,telefono)"
                    + "values ('"+nombre+"','"+apellido+"','"+telefono+"')";
            
            objConexion.conectar(); //abrir la conexión
            Statement st = objConexion.conex.createStatement();//Ejecución de statement
            int valor = st.executeUpdate(sqlInsertar);//Indica si insertó o no 
            
            if (valor>0) {
                resultado=true;
            } //se cierran las conexiones
            objConexion.conex.close();
            st.close();
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar."+ e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public boolean actualizarTercero(int id, String nombre, String apellido, String telefono) {
        boolean resultado = false;
        try {
            String sqlActualizar = "update terceros set nombres ='"+nombre+"',apellidos='"+apellido+"',telefono='"+telefono+"' where id = '"+id+"' ";
            Statement st = objConexion.conex.createStatement();//Ejecución de statement
            int valor = st.executeUpdate(sqlActualizar);//Indica si insertó o no 
            
            if (valor>0) {
                resultado=true;
            } //se cierran las conexiones
            objConexion.conex.close();
            st.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar."+ e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarTercero(int id) {
        boolean resultado = false;
        try {
            String sqlEliminar = "Delete from terceros where id = "+id;
            
            Statement st = objConexion.conex.createStatement();//Ejecución de statement
            int valor = st.executeUpdate(sqlEliminar);//Indica si insertó o no 
            
            if (valor>0) {
                resultado=true;
            } //se cierran las conexiones
            objConexion.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar."+ e.getMessage());
        }
        return resultado;
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
            String sql = "Select nombres,apellidos,telefono from terceros";
            objConexion.conectar(); //abrir la conexión
            Statement st = objConexion.conex.createStatement();
            resultado = st.executeQuery(sql);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
        }
        
        return resultado;
    }
    
}
