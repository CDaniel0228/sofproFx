
package Control;

import Modelo.Caracteristicas;
import Modelo.Producto;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Caracteristicas_db extends Conexion_db{
    
   public boolean registrar(Caracteristicas crear){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO Caracteristicas (nombre, descripcion, idNombre) VALUES(?,?,?)";

        try {
            
            ps = con.prepareStatement(sql);
       
            ps.setString(1, crear.getNombre());
            ps.setString(2, crear.getDescripcion()); 
            ps.setString(3, crear.getProducto()); 
    
           
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
    
    public boolean modificar(Caracteristicas editar, Producto caracteristica) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE Caracteristicas SET nombre=?, descripcion=? WHERE nombre=? && idNombre=? ";
        
        try {
           
            ps = con.prepareStatement(sql);
            
            ps.setString(1, editar.getNombre());
            ps.setString(2, editar.getDescripcion()); 
            ps.setString(3, editar.getNombre());
            ps.setString(4, caracteristica.getNombre());
            
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

    public boolean eliminar(Producto borrar, Producto caracteristica) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Caracteristicas WHERE nombre=? && idNombre=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, borrar.getNombre());
            ps.setString(2, caracteristica.getNombre());
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
