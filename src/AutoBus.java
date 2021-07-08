
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davier
 */
public class AutoBus {
    
    private Silla[] silla;
    private double saldo;
    private double valorPasaje;
    private double cambio;
    private int puesto;
    private boolean autoBusLleno;
    
    
    
    public AutoBus(){
        this.silla = new Silla[5];
        this.valorPasaje = 2600;
    }

    public boolean isAutoBusLleno() {
        return autoBusLleno;
    }

    public void setAutoBusLleno(boolean autoBusLleno) {
        this.autoBusLleno = autoBusLleno;
    }
    
    
    public double getCambio(){
        return this.cambio;
    }
    
    public void bajarUsuario(String codigoUsuario){
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario != null){
            silla[puestoUsuario(codigoUsuario)-1] = null;
            //silla[puestoUsuario(codigoUsuario)-1].setIsOcupado(false);
        }
        if (cantidadPasajeros() < this.silla.length ){
           this.autoBusLleno = false;
       }else{
            this.autoBusLleno = true;
        }
    }
    
    public int puestoUsuario(String codigoUsuario){
        for (int i = 0; i < silla.length; i++) {
            if (silla[i].getUsuario().getCodigo().equals(codigoUsuario)){
                return silla[i].getPuesto();
            }
        }
        return -1;
    }
    
    public Usuario buscarUsuario(String codigoUsuario){
        for (int i = 0; i < silla.length; i++) {
            if (silla[i].getUsuario().getCodigo().equals(codigoUsuario)){
                return silla[i].getUsuario();
            }
        }
        return null;
    }

    public void cobrar(double valor){
       if (this.valorPasaje < valor){
           this.cambio = valor - this.valorPasaje;
           this.saldo = this.saldo + this.cambio;
       }else{
           this.saldo = this.saldo + valor;
       }
    }
    
    public void mostrarPasajeros(){
        Silla s = new Silla();
        for (int i = 0; i < silla.length; i++) {
            s = silla[i];
            if (s != null){
                System.out.println("nombre:"+s.getUsuario().getNombre()
                +" puesto:"+s.getPuesto() + " ocupado:"+s.isIsOcupado());
            }
        }
        System.out.println(this.autoBusLleno);
        if (this.autoBusLleno){
            System.out.println("auto bus lleno");
            
        }
    }
    
    public int cantidadPasajeros(){
        Silla s = new Silla();
        int cantidad = 0;
        for (int i = 0; i < silla.length; i++) {
            s = silla[i];
            if(s != null){
                cantidad +=1;
            }
        }
        return cantidad;
    }
    
    public int puestoLibre(){
        Silla s = new Silla();
        int puesto = -1;
        for (int i = 0; i < silla.length; i++) {
            s = silla[i];
            if(s == null){
                puesto = i;
                break;
            }
        }
        return puesto;
        
    }
    
    public void subirUsuario(Usuario u){
       Silla s = new Silla();
       
       if (cantidadPasajeros() == this.silla.length){
           this.autoBusLleno = true;
       }else{
           
           if(puestoLibre() == -1){
                s.setPuesto(this.puesto+1);
                s.setUsuario(u);
                s.setIsOcupado(true);
                this.silla[this.puesto] = s;
                this.puesto = this.puesto +1;
           }else{
                s.setPuesto(puestoLibre()+1);
                s.setUsuario(u);
                s.setIsOcupado(true);
                this.silla[puestoLibre()] = s;
                this.puesto = this.puesto +1;
           }
            
       }
       
    } 
    
    
    
}
