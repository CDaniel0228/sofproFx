
package Control;

import Modelo.Calificacion;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Calificacion_db extends Conexion_db{
    
public boolean registrar(Calificacion crear){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO Calificacion (asesor, tecnico, ventas, total, idCaracteristicas) VALUES(?,?,?,?,?)";

        try {
            
            ps = con.prepareStatement(sql);
         
            ps.setInt(1, crear.getAsesor());
            ps.setInt(2, crear.getTecnico()); 
            ps.setInt(3, crear.getVentas());
            ps.setInt(4, crear.getTotal());
            ps.setInt(5, crear.getCaracteristicas());
           
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
    
}
