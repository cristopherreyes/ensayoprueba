
package ejercicioprueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioPrueba {

    public static void main(String[] args) {
       Usuario usuario=new Usuario();
        Scanner in=new Scanner(System.in);
        System.out.println("NOMBRE;");
        String nom=in.nextLine();
        usuario.setNombre(nom);
        System.out.println("APE:");
        String ape=in.nextLine();
        usuario.setApellido(ape);
        usuario.save();
        usuario.setUsuario_id(5);
        usuario.delete();
        usuario.setUsuario_id(4);
        usuario.setNombre("JUAN");
        usuario.setApellido("PEREZ");
        usuario.update();
        
        List<Usuario> lista=usuario.list();
        for(Usuario u:lista){
            System.out.println("NOMBRE:"+u.getNombre());
        }
        
    }

}
   
    

