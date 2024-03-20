package BASE_DE_DATOS_COLEGIO;

/**
 * Clase para CursoPresencial que implementa de la interfaz Curso
 */
public class CursoPresencial implements Curso {

	/**
	 * Atributos
	 */
	private String Nomcurso;
	private int capacidad;
	private String estadoCurso;
	private int Aula;
	private int IdCursoPresencial;
	private Alumnos[] alumnosMatriculados;
    private int cantidadAlumnosMatriculados;
    private Profesores[] profesoresMatriculados;
    private int cantidadProfesoresMatriculados;

    /**
 	 * Constructor de la clase CursoPresencial.
     * @param nomcurso el nombre del curso
     * @param capacidad la capacidad del curso
     * @param idCursoP el identificador único del curso
     * @param aula el número de aula
     */
	public CursoPresencial(String nomcurso, int capacidad,int idCursoP,int aula) {
		
		this.Nomcurso = nomcurso;
		this.capacidad = capacidad;
		this.estadoCurso = "Activo";
		this.IdCursoPresencial = idCursoP;
		this.Aula = aula;
		this.alumnosMatriculados = new Alumnos[capacidad];
	    this.profesoresMatriculados = new Profesores[capacidad];
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
	 * Método setter para establecer el número de aula del curso.
	 * @return número de aula
	 */
	public void setAula(int aula) {
		
		this.Aula = aula;
	}


	/**
	 * Método getter para obtener el número de aula del curso.
	 * @return el número de aula
	 */
	public int getAula() {
		
		return Aula;
	}

	
	/**
	 *Método getter para obtener el identificador del curso presencial.
     * @return identificador del curso presencial
	 */
	public int getIdCursoPresencial() {
		
		return IdCursoPresencial;
	}

	/**
	 * Método para agregar un alumno al curso presencial.
	 * @param alumno. Alumno a agregar
	 * @return true si se agregó correctamente, false en caso contrario
     */
    public boolean agregarAlumno(Alumnos alumno) {
    	
        if (cantidadAlumnosMatriculados < alumnosMatriculados.length) {
        	
            alumnosMatriculados[cantidadAlumnosMatriculados] = alumno;

            return true;
            
        } else {
        	
            return false;
        }
    }

    /**
	 * Método para agregar un profesor al curso presencial.
	 * @param profesor. Profesor a agregar
	 * @return true si se agregó correctamente, false en caso contrario
     */
    public boolean agregarProfesor(Profesores profesor) {
 	   
	    if (cantidadProfesoresMatriculados < profesoresMatriculados.length) {
	        
	        profesoresMatriculados[cantidadProfesoresMatriculados] = profesor;
	        
	        
	      
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
		        
			 this.estadoCurso = " Inactivo ";
		       
			 System.out.println("El curso '" + this.Nomcurso + "' ha sido eliminado." + " y su estado es : " + estadoCurso + " ademas se ha quedado libre el aula " + this.Aula);
		   
		 } 
	}



	@Override
	public String toString() {
		return "CursoPresencial [Nomcurso= " + Nomcurso + ", capacidad= " + capacidad + ", estadoCurso= " + estadoCurso
				+ ", Aula= " + Aula + ", IdCursoPresencial= " + IdCursoPresencial + "]";
	}



	
}
