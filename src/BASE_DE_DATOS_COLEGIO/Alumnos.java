package BASE_DE_DATOS_COLEGIO;

import java.time.LocalDate;

/**
 * Esta clase representa un alumno del colegio.
 */
public class Alumnos extends MiembroColegio {

	/**
	 * Atributos IdAlumno y IdSiguiente
	 */
	private int IdAlumno;
	private static int idSiguiente;
	
/**

     * Constructor de la clase Alumnos.
     * @param dni el DNI del alumno
     * @param nom el nombre del alumno
     * @param direccion la dirección del alumno
     * @param telefono el número de teléfono del alumno
     * @param fechanac la fecha de nacimiento del alumno
     * @param email el correo electrónico del alumno
     * @param idAlumno el identificador único del alumno

 */
	public Alumnos(String dni, String nom, String direccion, String telefono, LocalDate fechanac, String email,int idAlumno) {
		
		super(dni, nom, direccion, telefono, fechanac, email);
		idSiguiente++;
		IdAlumno = idSiguiente;
		
	}
	
	/**
     * Calcula la edad de los alumnos.
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
		return "Alumno : " + super.toString() + " IdAlumno= " + IdAlumno + " Edad : " + edad ;
	}
	
	
	
}
