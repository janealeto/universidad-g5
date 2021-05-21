/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.universidad;

import Datas.AlumnoData;
import Datas.CursadaData;
import Datas.MateriaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
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
 * @author Jannete
 */
public class ProUniversidad {

//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {

       Conexion conexion= null;
       try{
           conexion = new Conexion();
           
           
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Error de driver");
     }
           
       
    
     //creacion de alumnos y materias 
       //Alumnos
        Alumno a1 = new Alumno("Velazque", "Mauricio",true,105,LocalDate.of(1993, 11, 07));
        Alumno a2 = new Alumno("Suares", "Julio",true,106,LocalDate.of(2000, 10, 18));
        Alumno a3 = new Alumno("Gonzalez", "Martina",true,107,LocalDate.of(1989, 01, 23));
        Alumno a4 = new Alumno("Quiroga", "Agustina",true,108,LocalDate.of(1998, 05, 15));
        
        // Materias
        Materia m1 = new Materia("Fisica Cuantica", 2, true);
        Materia m2 = new Materia("Teologia", 1, true);
        Materia m3 = new Materia("Geografia", 3, true);
        Materia m4 = new Materia("Matematica Financiera", 4, true);
        
        // Cursadas
         Cursada c1 = new Cursada(a1,m1,10);
         Cursada c2 = new Cursada(a2,m2,9);
         Cursada c3 = new Cursada(a3,m3,5);
         Cursada c4 = new Cursada(a4,m4,8);
         
         
        // 1 AlumnoData
        AlumnoData ad= new AlumnoData(conexion);
        
        // 1 Materia Data
        MateriaData mad = new MateriaData(conexion);
        
        //1 Cursada Data
        CursadaData dt= new CursadaData(conexion);
        
        //AlumnoData------------------------------------------------------------
        // Agregar Alumnos
        
//        ad.ingresoAlumno(a1);
//        ad.ingresoAlumno(a2);
//        ad.ingresoAlumno(a3);
 //       ad.ingresoAlumno(a4);
        // reingreso del primer alumno
  //       ad.ingresoAlumno(a1);
         
        //Mostrar alumnos
//        List<Alumno> alum= ad.obtenerAlumnos();
//        for( Alumno a: alum){
//            System.out.println(a);
//        }
        //Buscar alumno
//      System.out.println(ad.buscarAlumno(1));
        
        // Actualizar alumno
//        System.out.println(a1.getIdAlumno());
//        a1 = ad.buscarAlumno(15);  
//        a1.setNombre("Rodrigo");
//        ad.actualizarAlumno(a1);
        
        
        //Borrar alumno
//         ad.borrarAlumno(14);
        
        //MateriaData-----------------------------------------------------------
        //Ingreso materias
        
//        mad.ingresoMateria(m1);
//        mad.ingresoMateria(m2);
//        mad.ingresoMateria(m3);
//        mad.ingresoMateria(m4);
  
        //Desactivar materia
//        mad.desactivarMateria(10);
  
        //ActualizarMateria
//        System.out.println(a1.getIdAlumno());
//        m3 = mad.buscarMateria(10);
//        m3.setNombre("Algebra");
//        mad.actualizarMateria(m3);

        //Buscar materia
//        System.out.println(mad.buscarMateria(1));
        
        //Mostrar materias
        
//         List<Materia> lista =  mad.obtenerMaterias();
//         for(Materia a : lista){
//             System.out.println(a);
//         }
         
         
         
       //CursadaData------------------------------------------------------------
      
        //Guardar cursada    
//            dt.guardarCursada(c1);
//            dt.guardarCursada(c2);
//            dt.guardarCursada(c3);
//            dt.guardarCursada(c4);
            
        //Obtener cursadas
//        List <Cursada> lista = dt.obtenerCursadas();
//        for(Cursada c : lista){
//           System.out.println(c.getMateria().getNombre());
//        }
        
        //Obtener cursadas por alumno
//        List <Cursada> lista = dt.obtenerCursadasxAlumno(1);
//        for(Cursada u : lista){
//            System.out.println(u.)
//        }

        //Obtener materias cursadas
//        List <Materia> lista = dt.obtenerMateriasCursadas(1);
//        for(Materia d : lista){
//            System.out.println(d.getNombre());
//        }
        
        //Mostrar materias no cursadas
       
//       List<Materia> lista=dt.obtenerMateriasNOCursadas(1);
//       for(Materia mat : lista){
//           System.out.println(mat.getNombre());
//           System.out.println(mat.getIdMateria());
//       }

        //Borrar Cursada De Una Materia De Un Alumno
        
//        dt.borrarCursadaDeUnaMateriaDeUnAlumno(1, 2);

        //Actualizar Nota Cursada
      
//        dt.actualizarNotaCursada(6, 2, 10);
        
        
        
        
        
}
}