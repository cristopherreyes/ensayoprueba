package ejercicioprueba;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjercicioPrueba {

    public static void main(String[] args) {
        int opt=0;
        Scanner in=new Scanner(System.in);
        
        String usuario="root";
        String clave="";
        
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            String url="jdbc:mysql://localhost:3306/test01";
            Connection con=DriverManager.getConnection(url,usuario,clave);
            Statement stmt=con.createStatement();
        do{
            System.out.println("Ingresar Opcion");
            System.out.println("1.-Insertar");
            System.out.println("2.-Eliminar");
            System.out.println("3.-Actualizar");
            System.out.println("4.-Mostrar");
            System.out.println("5.-Salir");
            
            int opcion=Integer.parseInt(in.nextLine());
            
            switch(opcion){
            
                case 1:{
                    stmt.executeUpdate("insert into Usuarios(nombre,apellido) values('A','B')");
                }
                    break;
                }
                case 2:{
            stmt.executeUpdate("delete from Usuarios where usuario_id=1");
                    break;
                    }
            case 3:{
             stmt.executeUpdate("update Usuarios set nombre='ALGO' where usuario_id=1");
            break;
        }
            case 4:{
            ResultSet rs=stmt.executeQuery("select * from Usuarios");
            while(rs.next()){
                System.out.println("ID:"+rs.getString("usuario_id"));
                System.out.println("NOMBRE:"+rs.getString("nombre"));
                System.out.println("APELLIDO:"+rs.getString("apellido"));
            }
        }
            case 5:{
            System.out.println("Saliendo...");
            break;
        }
         System.out.println("continuar 1.-SI Salir 2.-NO ");
            opt=Integer.parseInt(in.nextLine());
            
        }while(opt==5);{
        
    }
        
    }catch(Exception ex){
            System.out.println("ERROR:"+ex.getMessage());
        }

}
}
