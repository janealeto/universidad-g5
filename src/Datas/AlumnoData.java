
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pro.universidad.modelo.Alumno;
import pro.universidad.modelo.Conexion;





public class AlumnoData {
    private Connection conexion;

    public AlumnoData(Conexion conexion) {
        try {
            this.conexion = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al abrir al obtener la conexion");
        }
    }
    
    
    public void ingresoAlumno(Alumno alumno){
        String sql = "INSERT INTO alumno (legajo,apellido, nombre, fechaNac, estado) VALUES ( ?,?,?,?,?);";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
            ps.setInt(1,alumno.getLegajo());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setBoolean(4,alumno.isActivo());
            ps.setDate(5, Date.valueOf(alumno.getFechaNac()));
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
            alumno.setIdAlumno(rs.getInt(1));
        }
        ps.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en ingresoAlumno: "+ex.getMessage());
    }
    }
            
    
    public List<Alumno> obtenerAlumnos(){
        Alumno alumno;
    
        List<Alumno> alumnos = new ArrayList<Alumno>();
            
        String sql = "SELECT * FROM alumno;";
        try {
            
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
             
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setActivo(rs.getBoolean("activo"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());

                alumnos.add(alumno);
            }      
//            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return alumnos;
    }
    public void borrarAlumno(int id){
    try {
            
            String sql = "DELETE FROM alumno WHERE id =?;";

            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
    
    }
    //De Pedro Ernesto Blanco para todos:  11:53 AM
    public void actualizarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET apellido = ?,nombre = ?, fechaNac = ?  WHERE idAlumno = ?;";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getApellido());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(4, alumno.getLegajo());
            ps.executeUpdate();
            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    
    }
    public Alumno buscarAlumno(int id){
    Alumno alumno=null;
    String sql = "SELECT * FROM alumno WHERE idAlumno =?;";
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));

                
            }      
            ps.close();
             
           
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return alumno;
    }
}
