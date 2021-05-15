/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.universidad;

import Datas.MateriaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pro.universidad.modelo.Alumno;
import pro.universidad.modelo.Conexion;
import pro.universidad.modelo.Materia;

/**
 *
 * @author Jannete
 */
public class ProUniversidad {

//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
try{
            
            //1- Crear conexion.
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/universidad-grupo5","root","");
            
            //2- Crear objeto STATETMENT
            Statement  miStatement = miConexion.createStatement();
            
            //3- Ejecutar la sentencia SQL
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM alumno");
            
            //4- leer el ResultSet
            while(miResultSet.next()){
                System.out.println(miResultSet.getString("nombre")+ " "+miResultSet.getString("apellido"));
            }
        }catch(Exception e){
             System.out.println("No conecta");
             e.printStackTrace();
        }
    }
    */
        
        // Prueba de clase 13-5 MATERIA DATA 
       Conexion conexion= null;
       try{
           conexion = new Conexion();
           
           
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Error de driver");
     }
       
        Materia ma= new Materia("fisica cuantica", 2, true);
        MateriaData mad = new MateriaData(conexion);
        mad.ingresoMateria(ma);
         List<Materia> lista =  mad.obtenerMaterias();
         for(Materia a : lista){
             System.out.println(a.getNombre());
             System.out.println(a.getIdMateria());
             //Ahora si se agrega a la base de datos
         }
    }       
}