/*
 * New Ligths
 * Services info Web
 * Rubio Haro 
 */
package cajero;

/**
 *
 * @author Rod
 */
public class Operador {

    Usuario user;
    String Operacion;
    int Cant = 0;

    public Operador(Usuario user) {
        this.user = user;
    }
    
    public Operador(String Operacion, int Cant) {
        this.Operacion = Operacion;
        if(Operacion.equals("Depositar")){
            int a=user.getSaldo() + Cant;
            user.setSaldo(a);
        }else if(Operacion.equals("Retirar")){
            int a=user.getSaldo() - Cant;
            user.setSaldo(a);
        }
    }
}
