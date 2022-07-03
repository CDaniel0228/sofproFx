
package Control;

import Modelo.Producto;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Producto_db extends Conexion_db{
    
    public boolean registrar(Producto crear){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO Producto (idNombre, descripcion, mercadoObjetivo) VALUES(?,?,?)";

        try {
            
            ps = con.prepareStatement(sql);
         
            ps.setString(1, crear.getNombre());
            ps.setString(2, crear.getDescripcion()); 
            ps.setString(3, crear.getMercadoObjetivo());
           
           ps.execute();
            
            return true;
        } catch (SQLException e)  {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Producto editar) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE Producto SET descripcion=?, mercadoObjetivo=? WHERE idNombre=? ";
        
        try {
           
            ps = con.prepareStatement(sql);
            
            ps.setString(1, editar.getDescripcion());
            ps.setString(2, editar.getMercadoObjetivo()); 
            ps.setString(3, editar.getNombre());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Producto borrar) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Producto WHERE idNombre=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, borrar.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
     public boolean buscarInformacion(Producto buscar) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT nombre FROM Caracteristicas WHERE idNombre=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, buscar.getNombre());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               buscar.setNombre(rs.getString("nombre"));
               
               return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
}
