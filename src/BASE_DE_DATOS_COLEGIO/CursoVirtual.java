package BASE_DE_DATOS_COLEGIO;

/**
 * Clase para CursoVirtual que implementa de la interfaz Curso
 */
public class CursoVirtual implements Curso {

	
	/**
	 * Atributos
	 */
	private String Nomcurso;
	private int capacidad;
	private String estadoCurso;
	private String Web;
	private int IdCursoVirtual;
	private Alumnos[] alumnosMatriculados;
    private int cantidadAlumnosMatriculados;
    private Profesores[] profesoresMatriculados;
    private int cantidadProfesoresMatriculados;
	
    /**
     * Constructor de la clase CursoVirtual
     * @param nomcurso nombre del curso
     * @param capacidad  capacidad del curso
     * @param idCursoP identificador único del curso
     */
	public CursoVirtual(String nomcurso, int capacidad, int idCursoV) {
		
		this.Nomcurso = nomcurso;
		this.capacidad = capacidad;
		this.estadoCurso = "Activo";
		this.Web = "Cursovirtual.Micolegio.es";
		this.IdCursoVirtual = idCursoV;
		this.alumnosMatriculados = new Alumnos[capacidad];
	    this.cantidadAlumnosMatriculados = 0;
	    this.profesoresMatriculados = new Profesores[capacidad];
	    this.cantidadProfesoresMatriculados = 0;
	}


	/**
	 * Método getter para obtener el nombre del curso.
	 * @return nombre del curso
	 */
	public String getNomcurso() {
		return Nomcurso;
	}


	/**
	 *  Método getter para obtener la capacidad del curso.
	 * @return capacidad del curso
	 */
	public int getCapacidad() {
		return capacidad;
	}

	
	 /**
     * Método getter para obtener el id del curso Virtual.
     * @return el identificador del curso virtualal
     */
	public int getIdCursoVirtual() {
		
		return IdCursoVirtual;
	}

	/**
	 * Método para agregar un alumno al curso Virtual.
	 * @param alumno. Alumno a agregar
	 * @return true si se agregó correctamente, false en caso contrario
     */
	public boolean agregarAlumno(Alumnos alumno) {
    	
        if (cantidadAlumnosMatriculados < alumnosMatriculados.length) {
        	
            alumnosMatriculados[cantidadAlumnosMatriculados] = alumno;
            
            cantidadAlumnosMatriculados++;
            
            return true;
            
        } else {
        	
            return false;
        }
	}
	
	/**
	 * Método para agregar un profesor al curso Virtual.
	 * @param profesor. Profesor a agregar
	 * @return true si se agregó correctamente, false en caso contrario
     */
	public boolean agregarProfesor(Profesores profesor) {
	   
	    if (cantidadProfesoresMatriculados < profesoresMatriculados.length) {
	        
	        profesoresMatriculados[cantidadProfesoresMatriculados] = profesor;
	        
	       
	        cantidadProfesoresMatriculados++;
	        
	      
	        return true;
	    } else {
	       
	    	
	        return false;
	    }
	}
	
	
	/**
     * Método para eliminar un curso
     */
	@Override
	public void EliminarCurso(String Nomcurso) {
		
		 if (this.Nomcurso.equals(Nomcurso)) {
			 
		        this.estadoCurso = " Activo ";
		        
		        System.out.println("El curso " + this.Nomcurso + " ha sido eliminado." + " y su estado es  " + estadoCurso + " ademas se ha quedado libre la web " + Web);
		   
		 }
		
	}



	@Override
	public String toString() {
		return "CursoVirtual [Nomcurso= " + Nomcurso + ", capacidad= " + capacidad + ", estadoCurso= " + estadoCurso
				+ ", Web= " + Web + ", IdCursoVirtual= " + IdCursoVirtual + "]";
	}



}
