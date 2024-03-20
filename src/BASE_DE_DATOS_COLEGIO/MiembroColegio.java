package BASE_DE_DATOS_COLEGIO;

import java.time.LocalDate;

/**
 * Clase MiembroColegio
 */
public abstract class MiembroColegio {

	/**
	 * Atributos
	 */
	protected String DNI;
	protected String Nombre;
	protected String Direccion;
	protected String Telefono;
	protected LocalDate Fechanac;
	protected String Email;
	
	
	/**
	 * Constructor con todos los atributos
	 * @param dni
	 * @param nom
	 * @param direccion
	 * @param telefono
	 * @param fechanac
	 * @param email
	 */
	public MiembroColegio(String dni, String nom, String direccion, String telefono, LocalDate fechanac,String email) {
		
		this.DNI = dni;
		this.Nombre = nom;
		this.Direccion = direccion;
		this.Telefono = telefono;
		this.Fechanac = fechanac;
		this.Email = email;
	}

	

	/**
     * Método getter para obtener el Documento Nacional de Identidad (DNI) del miembro.
     * @return El DNI del miembro.
     */
	public String getDni() {
		
		return DNI;
	}

	/**
     * Metodo getter para obtener el nombre del miembro.
     * @return El nombre del miembro.
     */
	public String getNombre() {
		
		return Nombre;
	}

	/**
     * Metodo getter para obtener la dirección del miembro.
     * @return La dirección del miembro.
     */
	public String getDireccion() {
		
		return Direccion;
	}

	/**
     * Metodo getter para obtener el número de telefono del miembro.
     * @return El número de teléfono del miembro.
     */
	public String getTelefono() {
		
		return Telefono;
	}

	/**
     * Metodo getter para obtener la fecha de nacimiento del miembro.
     * @return La fecha de nacimiento del miembro.
     */
	public LocalDate getFechanac() {
		
		return Fechanac;
	}
	
	/**
     * Metodo getter para obtener la dirección de correo electronico del miembro.
     * @return La dirección de correo electrónico del miembro.
     */
	public String getEmail() {
		
		return Email;
	}
	

	/**
     * Metodo abstracto para calcular la edad del miembro.
     * Este metodo esta implementado en las subclases.
     * @return La edad del miembro.
     */
	public abstract int Edad();



	@Override
	public String toString() {
		return " DNI= " + DNI + ", Nombre= " + Nombre + ", Direccion= " + Direccion + ", Telefono= "
				+ Telefono + ", Fechanac= " + Fechanac + ", Email= " + Email;
	}
	
	
	
}
