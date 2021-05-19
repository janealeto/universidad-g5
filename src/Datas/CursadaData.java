package Datas;
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
import pro.universidad.modelo.Cursada;
import pro.universidad.modelo.Materia;

/**
 *
 
 */
public class CursadaData {
      private Connection conexion;
      //private Conexion con; // nose para que pero estaba en clase
      public CursadaData(Conexion conexion){
        try {
            this.conexion= conexion.getConexion();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en Cursada Data: "+ex.getMessage());
        }
    }
      
 public void guardarCursada(Cursada cursada){
     String sql="INSERT INTO cursada values (null,?,?,?)";
     
     
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
            ps.setInt(1,cursada.getAlumno().getIdAlumno());
            ps.setInt(2,cursada.getMateria().getIdMateria());
            ps.setFloat(3,cursada.getNota());
          
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
            cursada.setIdCursada(rs.getInt("idCursada"));
        }
        ps.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en guardarCursada: "+ex.getMessage());
    }
 }
// public List<Cursada> obtenerCursadas(){
//     List<Cursada>cursadas= new ArrayList<>();
//     Cursada cu;
//     String sql="SELECT * FROM cursada";
//     
//       try {
//            
//            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = ps.executeQuery();
//            while( rs.next()){
//                cu= new Cursada();
//                cu.setIdCursada(rs.getInt("idCursada"));
//                AlumnoData alum = new AlumnoData(con);
//                Alumno alumno = alum.buscarAlumno(rs.getInt("idAlumno"));
//                cu.setAlumno(alumno);
//                MateriaData mat= new MateriaData(con);
//                Materia materia= mat.buscarMateria(rs.getInt("idMateria"));
//                cu.setMateria(materia);
//                cu.setNota(rs.getInt("nota"));
//                cursadas.add(cu);
//            }
//            ps.close();
//     
//    }catch (SQLException ex){
//            JOptionPane.showMessageDialog(null, "Error de conexion en ObtenerCursadas: "+ex.getMessage());
//}
//       return cursadas;
// }
 
    public List<Materia>obtenerMateriasNOCursadas(int id){
        List<Materia>noCursada=new ArrayList<>();
        Materia m = null;
        String sql="SELECT * FROM materia WHERE idMateria NOT IN (SELECT materia.idMateria "
                + "FROM materia,cursada WHERE materia.idMateria=cursada.idMateria AND cursada.idAlumno=?);";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);//no se generan claves aca
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m=new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));//get---String nombre columna o---- int= number
                
                noCursada.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al consultar la tabla: "+ex.getMessage());

          }
          return noCursada;  
    }
        
}