
package ejercicioprueba;

import java.sql.Connection;
import java.sql.Statement;          //los 5 obligatorios
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Conexionbasededatos {
    Connection con;//Coneccion
    Statement stmt;//Obligatorio con coneccion
    ResultSet rs;//imprimir en pantalla
    String usuario = "root";//usuario... por defecto root
    String clave = "";// clave de mysql
    String url = "jdbc:mysql://localhost:3306/test01";//("jdbc:mysql://localhost/nombre base de datos");
    public Conexionbasededatos() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");//esto hace que se ejecute al iniciar el programa
            con = DriverManager.getConnection(url, usuario, clave);//Obligatorio para establecer coneccion
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());//mensaje de error en caso de fallo
        }
    }
    public void setEjecutar(String sql){
        try{
            stmt=con.createStatement();
            stmt.executeUpdate(sql);//ejecutar accion
        }catch(Exception ex){
            System.out.println("EJECUTAR ERROR:"+ex.getMessage());
        }
    }
    public void cerrarConexion(){
        try {
            con.close();//close para cerrar la coneccion
        } catch (SQLException ex) {
            System.out.println("ERROR AL CERRAR:"+ex.getMessage());
        }
    }
    
    public void setSeleccion(String sql){
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//imprimir en pantalla
        
        }catch(Exception ex)
        {
            System.out.println("ERROR SELECCION:"+ex.getMessage());
        }
    }
    
    public ResultSet getRs(){//retornar la impresion al main
        return rs;
    }
    
    
    
    
    
    
   

}
