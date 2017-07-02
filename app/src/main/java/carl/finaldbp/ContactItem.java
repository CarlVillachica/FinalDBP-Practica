package carl.finaldbp;

/**
 * Created by carl_ on 7/1/2017.
 */

public class ContactItem {
    public int id;
    public String nombre;
    ContactItem(int id,String nombre){
        this.nombre = nombre;
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getIdContacto(){
        return id;
    }
}
