package BASE_DE_DATOS_COLEGIO;

import java.time.LocalDate;

/**
 * Clse que extiende de MiembroColegio
 */
public class Profesores extends MiembroColegio {

	/**
	 * Atributo
	 */
	private String Titulacion;
	
    /**
     * Constructor de la clase Profesores
     * @param dni el DNI del profesor
     * @param nom el nombre del profesor
     * @param direccion la dirección del profesor
     * @param telefono el número de teléfono del profesor
     * @param fechanac la fecha de nacimiento del profesor
     * @param email el correo electrónico del profesor
     * @param titulacion la titulación del profesor
     */
	
	public Profesores(String dni, String nom, String direccion, String telefono, LocalDate fechanac, String email,String titulacion) {
		
		super(dni, nom, direccion, telefono, fechanac, email);
		
		this.Titulacion = titulacion;
	}

	/**
	 * Obtiene la titulación del profesor.
	 * @return la titulación del profesor
	 */
	public String getTitulacion() {
		
		return Titulacion;
		
	}
	
	
	/**
     * Calcula la edad de los Profesores.
     */
	@Override
	public int Edad() {
		
		LocalDate hoy = LocalDate.now();
		
		int edad = hoy.getYear() - Fechanac.getYear();
		
        if (hoy.getMonthValue() < Fechanac.getMonthValue() || (hoy.getMonthValue() == Fechanac.getMonthValue() && hoy.getDayOfMonth() < Fechanac.getDayOfMonth())) {
                
        	edad--;
        	
            }
        
		return edad;
	}
	
	
	/**
	 *Imprime los caracteres de los alumnos.
	 */
	@Override
	public String toString() {
		
		int edad = Edad();
		return "Profesores : " + super.toString() + "Titulacion= " + Titulacion + " Edad : " + edad ;
		
	}
	
	
	
	
	
}
