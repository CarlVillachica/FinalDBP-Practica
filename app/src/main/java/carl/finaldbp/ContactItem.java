package carl.finaldbp;



public class ContactItem {
    private int id;
    private String nombre;

    public ContactItem(int id,String nombre){
        this.nombre = nombre;
        this.id=id;
    }
    public String getContent() {
        return nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public int getIdContacto(){
        return id;
    }
}
