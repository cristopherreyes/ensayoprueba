
package ejercicioprueba;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Conexionbasededatos {
    Connection con;
    Statement stmt;
    ResultSet rs;
    String usuario = "root";
    String clave = "";
    String url = "jdbc:mysql://localhost:3306/test01";
    public Conexionbasededatos() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
    }
    public void setEjecutar(String sql){
        try{
            stmt=con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println("EJECUTAR ERROR:"+ex.getMessage());
        }
    }
    public void cerrarConexion(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CERRAR:"+ex.getMessage());
        }
    }
    
    public void setSeleccion(String sql){
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
        
        }catch(Exception ex)
        {
            System.out.println("ERROR SELECCION:"+ex.getMessage());
        }
    }
    
    public ResultSet getRs(){
        return rs;
    }
    
    
    
    
    
    
   

}