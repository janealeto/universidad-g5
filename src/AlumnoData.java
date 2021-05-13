//
//import pro.universidad.modelo.Alumno;
//import java.util.logging.Level;
//import java.sql.Connection
//
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Jannete
// */
//public class AlumnoData {
//    //crear conexion
//    private Connection con
//            
//            //constructor AlumnoData(Conexion conexion)
//            try{
//    con=conexion.getConexion();
//    
//}catch(exepcion){
//    Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE,null,ex)
//}
//public void guardarAlumno(Alumno alumno){
//    try{
//    String sql="INSERT INTO Alumno(nombre,fechaNac,activo) VALUES(?,?,?)";
//    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATE_KEYS);//clave, autonumerica
//    ps.setString(1,alumno.getNombre());
//    ps.setDate(2.Date.valueof(alumno.getFechaNac()));
//    ps.setBoolean(3,alumno.getActivo());
//    ps.executeUpdate();//para guardar, SE GENERA EL AUTONUMERICO, EL ID
//    ResulSet rs = ps.getGenerateKeys();
//    if(rs.next()){
//        alumno.setId(rs.getInt("id"))
//    }
//
//}   catch{
//// PROBANDO CODIGO, INCOMPLETO, CLASE 12/5 PROFE CRISTINA
//}
//}
