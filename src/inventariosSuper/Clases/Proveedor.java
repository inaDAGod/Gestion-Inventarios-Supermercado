package inventariosSuper.Clases;

public class Proveedor {
	private String Id_Provedor;
	private String nombre;
	private String direccion;
	private String telefono;
    private String correoElectronico;
	
	public Proveedor(String id_Provedor, String nombre, String direccion, String telefono, String correoElectronico) {
		super();
		Id_Provedor = id_Provedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	public String getId_Provedor() {
		return Id_Provedor;
	}
	
	public void setId_Provedor(String id_Provedor) {
		Id_Provedor = id_Provedor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String toString() {
		return "===============\n Proveedor \n  Id: " + Id_Provedor + " \n Nombre=" + nombre + "\n Direccion=" + direccion
				+ "\n Telefono=" + telefono + "\n Correo electronico=" + correoElectronico + " \n===============";
	}
    
}
