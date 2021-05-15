package Datas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pro.universidad.modelo.Conexion;
import pro.universidad.modelo.Conexion;
import pro.universidad.modelo.Materia;
import pro.universidad.modelo.Materia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jannete
 */
public class MateriaData {
    private Connection conexion;
    
    public MateriaData(Conexion conexion){
        try {
            this.conexion= conexion.getConexion();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en Materia Data: "+ex.getMessage());//les puse un getMessage para saber donde tiraba el error
        }
    }
    
    public void ingresoMateria(Materia ma){
        String sql="INSERT INTO materia(nombre,anio,estado) VALUES(?,?,?)";
    
        try{ 
        PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//clave, autonumerica
        ps.setString(1,ma.getNombre());
        ps.setInt(2, ma.getAnio());
        ps.setBoolean(3,ma.isEstado());
        ps.executeUpdate();//para guardar, SE GENERA EL AUTONUMERICO, EL ID
        ResultSet rs = ps.getGeneratedKeys();//me devuelve todas las claves
        if(rs.next()){
        ma.setIdMateria(rs.getInt(1));//aca materia ahora tiene el id (la que recibe por parametro)
        }
        ps.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en ingresoMateria: "+ex.getMessage());
    }
    }
    
    public void desactivarMateria(int id){
        
        String sql="UPDATE `materia` SET `estado`=false WHERE idMateria=?";
        try{
             PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, id);
             ps.executeUpdate();
             ps.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en desactivarMateria: "+ex.getMessage());
    }
    }
    public void actualizarMateria(Materia ma){
        String sql="UPDATE `materia` SET `nombre`=?, `anio`=? WHERE idMateria=?";
        try{
             PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1,ma.getNombre());
             ps.setInt(2, ma.getAnio());
             ps.setInt(3,ma.getIdMateria());
             ps.executeUpdate();
             ps.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion en actualizarMateria: "+ex.getMessage());
    }
    }
    public void buscarMateria(int id){
        Materia ma= new Materia();
        String sql="SELECT `materia` WHERE idMateria=?";
        try{
             PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 
                ma.setNombre(rs.getString("nombre"));
                ma.setIdMateria(rs.getInt("idMateria"));
                ma.setEstado(rs.getBoolean("estado"));//aca en vez de "activo" es "estado" (tal cual esta en la base de datos)
                ma.setAnio(rs.getInt("anio"));
             }
             
    } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion buscarMateria: "+ex.getMessage());
    }
    }
    public List<Materia> obtenerMaterias(){
    Materia mat;
    ArrayList<Materia>materias=new ArrayList<>();
    String sql="SELECT * FROM materia";
    try{
             PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 
                mat = new Materia();
                mat.setNombre(rs.getString("nombre"));
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setEstado(rs.getBoolean("estado"));//aca igual. En vez de "activo" es "estado" (tal cual esta en la base de datos)
                mat.setAnio(rs.getInt("anio"));
                materias.add(mat);
             }
             
    }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conexion lista obtenerMaterias: "+ex.getMessage());
        }
    return materias;
    
    }
}
