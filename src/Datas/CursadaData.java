/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Mauri
 */
public class CursadaData {
      private Connection con =null;
      private Conexion conexion; // nose para que pero estaba en clase
      public CursadaData(Conexion conexion){
        try {
            this.conexion= conexion;
            con= conexion.getConexion();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en Cursada Data: "+ex.getMessage());
        }
    }
      
 public void guardarCursada(Cursada cursada){
     String sql="INSERT INTO cursada ( idAlumno, idMateria, nota) values (?,?,?)";
     
     
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);    
            System.out.println("id alumno:"+cursada.getAlumno().getIdAlumno());
            ps.setInt(1,cursada.getAlumno().getIdAlumno());
            System.out.println("id Materia:"+cursada.getMateria().getIdMateria());
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
 public List<Cursada> obtenerCursadas(){
     List<Cursada>cursadas= new ArrayList<>();
     Cursada cu= null;
     String sql="SELECT * FROM cursada";
     
       try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while( rs.next()){
                cu= new Cursada();
                cu.setIdCursada(rs.getInt("idCursada"));
                AlumnoData alum = new AlumnoData(conexion);
                Alumno alumno = alum.buscarAlumno(rs.getInt("idAlumno"));
                cu.setAlumno(alumno);
                MateriaData mat= new MateriaData(conexion);
                Materia materia= mat.buscarMateria(rs.getInt("idMateria"));
                cu.setMateria(materia);
                cu.setNota(rs.getFloat("nota"));
                cursadas.add(cu);
            }
            ps.close();
     
    }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en ObtenerCursadas: "+ex.getMessage());
}
       return cursadas;
 }
 public List<Cursada> obtenerCursadasxAlumno(int id){
     List<Cursada>cursadas= new ArrayList<>();
     Cursada cu= null;
     String sql="SELECT * FROM cursada WHERE idAlumno=?";
     
       try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while( rs.next()){
                cu= new Cursada();
                cu.setIdCursada(rs.getInt("idCursada"));
                AlumnoData alum = new AlumnoData(conexion);
                Alumno alumno = alum.buscarAlumno(rs.getInt("idAlumno"));
                cu.setAlumno(alumno);
                MateriaData mat= new MateriaData(conexion);
                Materia materia= mat.buscarMateria(rs.getInt("idMateria"));
                cu.setMateria(materia);
                cu.setNota(rs.getFloat("nota"));
                cursadas.add(cu);
            }
            ps.close();
     
    }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en ObtenerCursadas: "+ex.getMessage());
}
       return cursadas;
 }
 /*
 public Alumno buscarAlumno(int id){
    
        AlumnoData ad=new AlumnoData(con);    
        return ad.buscarAlumno(id);
        
    }
    
    public Materia buscarMateria(int id){
    
        MateriaData md=new MateriaData(con);
        return md.buscarMateria(id);
    */
    public List<Materia>obtenerMateriasCursadas(int id){
        List<Materia>noCursada=new ArrayList<>();
        Materia m = null;
        String sql= "SELECT materia.idMateria,materia.nombre,materia.anio,materia.estado FROM cursada,materia "
                + "WHERE cursada.idMateria = materia.idMateria AND idAlumno=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);//no se generan claves aca
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

   public List<Materia>obtenerMateriasNOCursadas(int idAlumno){
        List<Materia>noCursada=new ArrayList<>();
        Materia m = null;
        String sql="SELECT * FROM materia WHERE idMateria NOT IN (SELECT materia.idMateria "
                + "FROM materia,cursada WHERE materia.idMateria=cursada.idMateria AND cursada.idAlumno=?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);//no se generan claves aca
            ps.setInt(1, idAlumno);
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
        
 public void borrarCursadaDeUnaMateriaDeUnAlumno(int idAlumno, int idMateria){
     
     String sql="DELETE FROM cursada WHERE idAlumno=? AND idMateria=?";
      try{
            PreparedStatement ps = con.prepareStatement(sql);//no se generan claves aca
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ps.executeUpdate();
            ps.close();
      }catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al Borrar: "+ex.getMessage());

          }
 }
 public void actualizarNotaCursada(int idAlumno, int idMateria,float nota){
     String sql= " UPDATE cursada Set nota=? WHERE idAlumno=? AND idMateria=? ";
      try{
            PreparedStatement ps = con.prepareStatement(sql);//no se generan claves aca
            ps.setFloat(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            ps.executeUpdate();
            ps.close();
      }catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al Actualizar: "+ex.getMessage());

          }
     
 }
}
        
