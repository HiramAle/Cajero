package cajero;

/**
 *
 * @author Rod
 */
public class Usuario{
    private int idUsuario;
    private String nombre;
    private String Apellidos;
    private String pass;
    private String type;
    private String Sexo;
    private int edad;
	private int saldo;

    public Usuario() {
    }
    
    public Usuario(int idUsuario,String nombre, String Apellidos, String pass, String tipo, String Sexo, int edad,int saldo) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.pass = pass;
        this.type = tipo;
        this.Sexo = Sexo;
        this.edad = edad;
    }

    //ATRIBUTO USUARIO: ID

    public int getId() {
        return idUsuario;
    }

    public void setId(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //ATRIBUTO USUARIO: NOMBRE

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    //ATRIBUTO USUARIO: APELLIDOS
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    //ATRIBUTO USUARIO: PASSWORD
    public String getPass() {
        return pass;
    }

    public void setPass(String Pass) {
        this.pass = Pass;
    }

    //ATRIBUTO USUARIO: TIPO
    public String getType() {
        return type;
    }

    public void setType(String tipo) {
        this.type = tipo;
    }

    //ATRIBUTO USUARIO: APELLIDOS
    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sex) {
        this.Sexo = Sex;
    }

    //ATRIBUTO USUARIO: APELLIDOS
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
	
	//ATRIBUTO USUARIO: ID

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
