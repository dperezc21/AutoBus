
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
    
    public void bajerUsuario(String codigoUsuario){
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario != null){
            silla[puestoUsuario(codigoUsuario)-1] = null;
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
        
        if (this.autoBusLleno){
            System.out.println("auto bus lleno");
        }
    }
    
    
    public void subirUsuario(Usuario u){
       Silla s = new Silla();
       if(silla.length-1 < this.puesto){
           this.autoBusLleno = true;
       }else{
            s.setPuesto(this.puesto+1);
            s.setUsuario(u);
            s.setIsOcupado(true);
            this.silla[this.puesto] = s;
            this.puesto = this.puesto +1;
       }
    } 
    
    
    
}
