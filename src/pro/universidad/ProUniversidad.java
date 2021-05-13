/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.universidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import pro.universidad.modelo.Alumno;

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
    
}