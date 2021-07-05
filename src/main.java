/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davier
 */
public class main {
    
    public static void main(String[] args) {
        
        AutoBus b = new AutoBus();
        Usuario u = new Usuario("davier","a","21");
        Usuario u2 = new Usuario("jose","b","23");
        Usuario u3 = new Usuario("dario","c","23");
        Usuario u4 = new Usuario("jorge","d","23");
        Usuario u5 = new Usuario("luisa","e","23");
        b.subirUsuario(u);
        b.subirUsuario(u2);
        b.subirUsuario(u3);
        b.subirUsuario(u4);
        b.subirUsuario(u5);
         //b.subirUsuario(u5);
         
        b.mostrarPasajeros();
        //System.out.println("despues de bajar al usuario");
        //b.bajerUsuario("b");
       // b.mostrarPasajeros();
        //b.subirUsuario(u2);
        //System.out.println("montar otra ves al pasajero");
        //b.mostrarPasajeros();
       
        
        
    }
    
}
