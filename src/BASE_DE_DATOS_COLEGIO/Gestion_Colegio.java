package BASE_DE_DATOS_COLEGIO;

import java.time.LocalDate;

import java.util.Scanner;


/**
 * Clase principal para la gestión de un colegio.
 */
public class Gestion_Colegio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scanner = new Scanner(System.in);
	        
		// Arrays para almacenar alumnos, profesores, cursos presenciales y cursos virtuales
	        Alumnos[] alumnos = new Alumnos[20]; 
	        
	        Profesores[] profesores = new Profesores[10];
	        
	        CursoPresencial[] cursosPresenciales = new CursoPresencial[7]; 
	        
			CursoVirtual[] cursosVirtuales = new CursoVirtual[7]; 

	       
	  // Inicialización de algunos cursos presenciales y virtuales
			
			try {
			
		 cursosPresenciales[0] = new CursoPresencial("Matemáticas de Ciencias", 20, 1,10);
	     cursosPresenciales[1] = new CursoPresencial("Historia de España", 15, 2,11);
	     
	     cursosVirtuales[0] = new CursoVirtual("Programación Java", 50, 3);
	     cursosVirtuales[1] = new CursoVirtual("PHP", 30, 4);

	  // Inicialización de algunos alumnos y profesores
	    alumnos[0] = new Alumnos("12345678A", "Juan", "Calle Martineli", "723456789", LocalDate.of(2000, 5, 15), "juan@gmail.com", 1);
	    alumnos[1] = new Alumnos("87654321B", "Carlos", "Calle Brunette", "987654321", LocalDate.of(2001, 7, 20), "Carlos@hotmail.com", 2);
	    alumnos[2] = new Alumnos("13579246C", "Pedro", "Calle Camilo", "956789012", LocalDate.of(1999, 10, 10), "pedro@yahoo.com", 3);
	    alumnos[3] = new Alumnos("24681357D", "Manuel", "Calle Fernandez", "621654987", LocalDate.of(2002, 3, 25), "Manuel@gmail.com", 4);
	    alumnos[4] = new Alumnos("98765432E", "Mery", "Calle Lugo", "987654321", LocalDate.of(2003, 9, 5), "Mery@hotmail.com", 5);
	        
	    profesores[0] = new Profesores("59234567X", "Paco", "Calle Amberes", "623456584", LocalDate.of(1970, 5, 15), "Paco@yahoo.com", "Doctorado en Matemáticas");
        profesores[1] = new Profesores("47854321Y", "Giuliette", "Calle Sopa", "987659760", LocalDate.of(1980, 7, 20), "Giuliette@gmail.com", "Licenciatura en Literatura");
        profesores[2] = new Profesores("28979246Z", "Gloria", "Calle Diluvio", "856789765", LocalDate.of(1975, 10, 10), "Gloria@hotmail.com", "Ingeniería Informática");
        profesores[3] = new Profesores("35281357W", "Matias", "Calle Real", "951658647", LocalDate.of(1985, 3, 25), "Matias@hotmail.com", "Doctorado en Física");
        profesores[4] = new Profesores("77228932V", "Pepe", "Calle Espinosa", "687134021", LocalDate.of(1973, 9, 5), "Pepe@yahoo.com", "Licenciatura en Historia");
         
	     //Menu Principal
	     int opcion;
	     
	        do {
	        	
	        		            
	            System.out.println("INTRODUCE LA OPCION QUE QUIERES REALIZAR : \n------- Menú -------\r\n " 
	            		+ "1. Alta de Alumnos\r\n"
	    				+ "2. Alta de Profesores \r\n"
	    				+ "3. Buscar Miembros\r\n"
	    				+ "4. Gestionar Cursos Presenciales\r\n"
	    				+ "5. Gestionar Cursos Virtuales\r\n"
	    				+ "6. Matricular Alumno\r\n" 
	    				+ "0. Salir");
	            
	            System.out.print("Seleccione una opción: ");
	            opcion = scanner.nextInt();
	            
	            scanner.nextLine();
	            
	            // Switch para manejar las opciones del menú
	            switch (opcion) {
	            
                case 1:
                    System.out.println("\n------- Alta de Alumnos -------");
                    altaAlumno(alumnos);
                    break;
                    
                case 2:
                    System.out.println("\n------- Alta de Profesores -------");
                    altaProfesores(profesores);
                    break;
                    
                case 3 : System.out.println("\n------- Buscar Miembros -------");
	                buscarMiembros(alumnos, profesores);
                	break;
                	
                case 4:
                    System.out.println("\n------- Gestión de Cursos Presenciales -------");
                    gestionarCursosPresenciales(cursosPresenciales);
                    break;
                    
                case 5:
                    System.out.println("\n------- Gestión de Cursos Virtuales -------");
                    gestionarCursosVirtuales(cursosVirtuales);
                    break;
                    
                case 6:
                    System.out.println("\n------- Matricular -------");
                    matricular(alumnos, profesores,cursosPresenciales,cursosVirtuales);
                    break;
                    
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intentalo de nuevo.");
            }
	            
        } while (opcion != 0);
	        
			 } catch (Exception e) {
				 
		            System.out.println("Ha ocurrido un error: " + e.getMessage());
		            
		     } 
	}
	/**
	 * Metodo que nos busca los miembros que tenemos en el colegio
	 * @param alumnos
	 * @param profesores
	 */
	  public static void buscarMiembros(Alumnos[] alumnos, Profesores[] profesores) {
		  
		  Scanner scanner = new Scanner(System.in);

		   System.out.print("Ingrese el DNI a buscar: ");
	        String dni = scanner.nextLine();

	        boolean encontrado = false;

	        for (int i = 0; i < alumnos.length; i++) {
	        	
	            if (alumnos[i] != null && alumnos[i].getDni().equals(dni)) {
	            	
	                System.out.println("Alumno encontrado:");
	                
	                System.out.println(alumnos[i].toString());
	                
	                encontrado = true;
	                
	                eliminarAlumno(alumnos, i);
	                
	                return; // Salir del método después de encontrar al alumno
	            }
	        }

	        for (int i = 0; i < profesores.length; i++) {
	        	
	            if (profesores[i] != null && profesores[i].getDni().equals(dni)) {
	            	
	                System.out.println("Profesor encontrado:");
	                
	                System.out.println(profesores[i].toString());
	                
	                encontrado = true;
	                
	                eliminarProfesor(profesores, i);
	                
	                return; // Salir del método después de encontrar al profesor
	            }
	        }

	        if (!encontrado) {
	        	
	            System.out.println("No se encontró ninguna persona con ese DNI.");
	            
	            System.out.print("¿Desea agregar un nuevo alumno (A) o profesor (P)? ");
	            
	            char respuesta = scanner.nextLine().toUpperCase().charAt(0);

	            if (respuesta == 'A') {
	            	
	                altaAlumno(alumnos);
	                
	            } else if (respuesta == 'P') {
	            	
	                altaProfesores(profesores);
	                
	            } else {
	            	
	                System.out.println("Respuesta no válida.");
	            }
	        }
	    }

	  
	  
	  /**
	   * Metodo que elimina Alumnos
	   * @param alumnos
	   * @param indice
	   */
	    public static void eliminarAlumno(Alumnos[] alumnos, int indice) {
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	        System.out.print("¿Desea eliminar este alumno? (S/N): ");
	        char respuesta = scanner.nextLine().toUpperCase().charAt(0);

	        if (respuesta == 'S') {
	        	
	            alumnos[indice] = null;
	            
	            System.out.println("El alumno ha sido eliminado.");
	            
	        } else {
	        	
	            System.out.println("El alumno no ha sido eliminado.");
	        }
	    }

	    
	   /**
	    * Metodo que elimina profesores 
	    * @param profesores
	    * @param indice
	    */
	    public static void eliminarProfesor(Profesores[] profesores, int indice) {
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	        System.out.print("¿Desea eliminar este profesor? (S/N): ");
	        char respuesta = scanner.nextLine().toUpperCase().charAt(0);

	        if (respuesta == 'S') {
	        	
	            profesores[indice] = null;
	            
	            System.out.println("El profesor ha sido eliminado.");
	            
	        } else {
	        	
	            System.out.println("El profesor no ha sido eliminado.");
	            
	        }
	    }

	    
	    
		/**
		 * Metodo que da de alta un alumno
		 * @param alumnos
		 */
	    public static void altaAlumno(Alumnos[] alumnos) {
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	        for (int i = 0; i < alumnos.length; i++) {
	        	
	            if (alumnos[i] == null) {
	            	
	                System.out.print("Ingrese el nombre del nuevo alumno: ");
	                String nombre = scanner.nextLine();
	                
	                System.out.print("Ingrese el DNI del nuevo alumno: ");
	                String dni = scanner.nextLine();
	                
	                System.out.print("Ingrese la dirección del nuevo alumno: ");
	                String direccion = scanner.nextLine();
	                
	                System.out.print("Ingrese el teléfono del nuevo alumno: ");
	                String telefono = scanner.nextLine();
	                
	                System.out.print("Ingrese la fecha de nacimiento del nuevo alumno (YYYY-MM-DD): ");
	                LocalDate fechanac = LocalDate.parse(scanner.nextLine());
	                
	                System.out.print("Ingrese el email del nuevo alumno: ");
	                String email = scanner.nextLine();
	                

	                // Crear un nuevo objeto Alumnos y agregarlo al array
	                alumnos[i] = new Alumnos(dni, nombre, direccion, telefono, fechanac, email, 0);
	                System.out.println("Alumno agregado correctamente.");
	                break;
	            }
	        }
	    }


	    
	    /**
	     * Metodo que da de alta un profesor
	     * @param profesores
	     */
	    public static void altaProfesores(Profesores[] profesores){
	    	
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	        for (int i = 0; i < profesores.length; i++) {
	        	
	            if (profesores[i] == null) {
	            	
	                System.out.print("Ingrese el nombre del nuevo profesor: ");
	                String nombre = scanner.nextLine();
	   
	                System.out.print("Ingrese el DNI del nuevo profesor: ");
	                String dni = scanner.nextLine();
	               
	                System.out.print("Ingrese la dirección del nuevo profesor: ");
	                String direccion = scanner.nextLine();
	                
	                System.out.print("Ingrese el teléfono del nuevo profesor: ");
	                String telefono = scanner.nextLine();
	                
	                System.out.print("Ingrese la fecha de nacimiento del nuevo profesor (Año-Mes-Día): ");
	                String fechaNacimientoString = scanner.nextLine();
	                
	                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString);
	                
	                System.out.print("Ingrese el email del nuevo profesor: ");
	                String email = scanner.nextLine();
	               
	                
	                System.out.print("Ingrese la titulación del nuevo profesor: ");
	                String titulacion = scanner.nextLine();
	                
	                // Crear un nuevo objeto Profesores y agregarlo al array
	                profesores[i] = new Profesores(dni, nombre, direccion, telefono, fechaNacimiento, email, titulacion);
	                System.out.println("Profesor agregado correctamente.");
	                break;
	            }
	        }
	    }
	    
	    
	    
	    
	    
	    /**
	     * Metod que gestiona los cursos presenciales
	     * @param cursosPresenciales
	     */
	    public static void gestionarCursosPresenciales(CursoPresencial[] cursosPresenciales) {
	    	
	    	
	    	Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese el identificador del curso presencial: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        boolean encontrado = false;
	        
	        for (int i = 0; i < cursosPresenciales.length; i++) {
	        	
	            CursoPresencial curso = cursosPresenciales[i];
	            
	            if (curso != null && curso.getIdCursoPresencial() == id) {
	            	
	                encontrado = true;
	                
	                System.out.print("¿Desea eliminar el curso presencial con ID " + id + "? (S/N): ");
	                String opcion = scanner.nextLine();
	                
	                if (opcion.equalsIgnoreCase("S")) {
	                	
	                	curso.EliminarCurso(curso.getNomcurso()); // Eliminar el curso presencial
	                    
	                    System.out.println("El curso presencial con ID " + id + " ha sido eliminado.");
	                    
	                } else {
	                	
	                    System.out.println("El curso presencial con ID " + id + " no ha sido eliminado.");
	                }
	                
	                break;
	            }
	        }

	        if (!encontrado) {
	        	
	            System.out.println("El curso presencial con ID " + id + " no se encontró.");
	            
	            System.out.print("¿Desea agregar un nuevo curso presencial con ID " + id + "? (S/N): ");
	            String opcion = scanner.nextLine();
	            
	            if (opcion.equalsIgnoreCase("S")) {
	            	
	                agregarNuevoCursoPresencial(cursosPresenciales, id);
	                
	            } else {
	            	
	                System.out.println("No se agregó ningún curso presencial.");
	            }
	        }
	    }

	    
	    /**
	     * Metodo que gestiona los cursos Virtuales
	     * @param cursosVirtuales
	     */
	    public static void gestionarCursosVirtuales(CursoVirtual[] cursosVirtuales) {
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	        System.out.print("Ingrese el identificador del curso virtual: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        boolean encontrado = false;
	        
	        for (int i = 0; i < cursosVirtuales.length; i++) {
	        	
	            CursoVirtual curso = cursosVirtuales[i];
	            
	            if (curso != null && curso.getIdCursoVirtual() == id) {
	            	
	                encontrado = true;
	                
	                System.out.print("¿Desea eliminar el curso virtual con ID " + id + "? (S/N): ");
	                String opcion = scanner.nextLine();
	                
	                if (opcion.equalsIgnoreCase("S")) {
	                	
	                   curso.EliminarCurso(curso.getNomcurso()); // Eliminar el curso virtual
	                    
	                    System.out.println("El curso virtual con ID " + id + " ha sido eliminado.");
	                    
	                } else {
	                	
	                    System.out.println("El curso virtual con ID " + id + " no ha sido eliminado.");
	                }
	                
	                break;
	            }
	        }

	        if (!encontrado) {
	        	
	            System.out.println("El curso virtual con ID " + id + " no se encontró.");
	            
	            System.out.print("¿Desea agregar un nuevo curso virtual con ID " + id + "? (S/N): ");
	            String opcion = scanner.nextLine();
	            
	            if (opcion.equalsIgnoreCase("S")) {
	            	
	                agregarNuevoCursoVirtual(cursosVirtuales, id);
	                
	            } else {
	            	
	                System.out.println("No se agregó ningún curso virtual.");
	            }
	        }
	    }
	    
	    
	    
	    
	    /**
	     * Metodos para agregar un Nuevo Curso Presencial
	     * @param cursosPresenciales
	     * @param id
	     */
	    private static void agregarNuevoCursoPresencial(CursoPresencial[] cursosPresenciales, int id) {

	    	Scanner scanner = new Scanner(System.in);
	    	
	        System.out.print("Ingrese el nombre del nuevo curso presencial: ");
	        String nombre = scanner.nextLine();
	        
	        System.out.print("Ingrese la capacidad de alumnos del nuevo curso presencial: ");
	        int capacidad = scanner.nextInt();
	        
	        System.out.print("Ingrese el aula del nuevo curso presencial: ");
	        int aula = scanner.nextInt();
	        
	        scanner.nextLine(); 

	        // Buscar la primera posición nula para agregar el nuevo curso
	        for (int i = 0; i < cursosPresenciales.length; i++) {
	        	
	            if (cursosPresenciales[i] == null) {
	            	
	                cursosPresenciales[i] = new CursoPresencial(nombre, capacidad, id, aula);
	                
	                System.out.println("Nuevo curso presencial agregado correctamente." +  cursosPresenciales[i].toString());
	                
	                break;
	            }
	        }
	        
	    }

	    
	    
	    
	    /**
	     * Metodo que agrega Cursos Virtuales
	     * @param cursosVirtuales
	     * @param id
	     */
	    private static void agregarNuevoCursoVirtual(CursoVirtual[] cursosVirtuales, int id) {
	       
	    	Scanner scanner = new Scanner(System.in);
	    	
	        System.out.print("Ingrese el nombre del nuevo curso virtual: ");
	        String nombre = scanner.nextLine();
	        
	        System.out.print("Ingrese la capacidad del nuevo curso virtual: ");
	        int capacidad = scanner.nextInt();
	        
	        scanner.nextLine(); 

	        // Buscar la primera posición nula para agregar el nuevo curso
	        for (int i = 0; i < cursosVirtuales.length; i++) {
	        	
	            if (cursosVirtuales[i] == null) {
	            	
	                cursosVirtuales[i] = new CursoVirtual(nombre, capacidad, id);
	                
	                System.out.println("Nuevo curso virtual agregado correctamente. " + cursosVirtuales[i].toString());
	                
	                break;
	            }
	        }
	    
	  }
	    
	    
	    
	    
	    
	    
	    
	    /**
	     * Metodo que matricula Alumnos y profesores en los cursos
	     * @param alumnos
	     * @param profesores
	     * @param cursosPresenciales
	     * @param cursosVirtuales
	     */
	    public static void matricular(Alumnos[] alumnos, Profesores[] profesores, CursoPresencial[] cursosPresenciales, CursoVirtual[] cursosVirtuales) {
	    	
	        Scanner scanner = new Scanner(System.in);
	        
	        boolean encontrado = false; // Variable para controlar si se encuentra el usuario
	        
	        System.out.print("Ingrese el DNI del alumno o profesor a matricular: ");
	        String dni = scanner.nextLine();
	        
	        // Buscar en la lista de alumnos
	        for (int i = 0; i < alumnos.length; i++) {
	        	
	            if (alumnos[i] != null && alumnos[i].getDni().equals(dni)) {
	            	
	                System.out.println("Alumno encontrado:");
	                
	                System.out.println(alumnos[i].toString());
	                
	                encontrado = true;
	                break;
	            }
	        }   
	        
	        // Si no se encontró en la lista de alumnos, buscar en la lista de profesores
	        if (!encontrado) {
	        	
	            for (int i = 0; i < profesores.length; i++) {
	            	
	                if (profesores[i] != null && profesores[i].getDni().equals(dni)) {
	                	
	                    System.out.println("Profesor encontrado:");
	                    
	                    System.out.println(profesores[i].toString());
	                    
	                    encontrado = true;
	                    break;
	                }
	            }
	        }
	        
	        // Si se encontró el usuario, proceder con la matriculación
	        if (encontrado) {
	            // Solicitar ID del curso presencial o virtual
	            System.out.print("Ingrese el ID del curso presencial o virtual: ");
	            int idCurso = scanner.nextInt();
	            scanner.nextLine(); 
	            
	            // Buscar curso presencial
	            boolean cursoEncontrado = false;
	            
	            for (int i = 0; i < cursosPresenciales.length; i++) {
	            	
	                CursoPresencial cursoPresencial = cursosPresenciales[i];
	                
	                if (cursoPresencial != null && cursoPresencial.getIdCursoPresencial() == idCurso) {
	                	
	                    cursoEncontrado = true;
	                    
	                    if (profesores[i] != null) {
	                    	
	                        cursoPresencial.agregarProfesor(profesores[i]);
	                        
	                        System.out.println("Profesor matriculado exitosamente en el curso presencial " + cursoPresencial.getNomcurso());
	                        
	                    } else if (alumnos[i] != null) {
	                    	
	                        if (cursoPresencial.agregarAlumno(alumnos[i])) {
	                        	
	                        	
	                            System.out.println("Alumno matriculado exitosamente en el curso presencial " + cursoPresencial.getNomcurso());
	                            
	                        } else {
	                        	
	                            System.out.println("No se pudo matricular al alumno en el curso presencial. El curso está completo.");
	                        }
	                    }
	                    
	                    break;
	                }
	            }

	            // Si el curso presencial no se encontró, buscar curso virtual
	            if (!cursoEncontrado) {
	            	
	                for (int i = 0; i < cursosVirtuales.length; i++) {
	                	
	                    CursoVirtual cursoVirtual = cursosVirtuales[i];
	                    
	                    if (cursoVirtual != null && cursoVirtual.getIdCursoVirtual() == idCurso) {
	                    	
	                        cursoEncontrado = true;
	                        
	                        if (profesores[i] != null) {
	                        	
	                            cursoVirtual.agregarProfesor(profesores[i]);
	                            
	                            System.out.println("Profesor matriculado exitosamente en el curso virtual " + cursoVirtual.getNomcurso());
	                            
	                        } else if (alumnos[i] != null) {
	                        	
	                            if (cursoVirtual.agregarAlumno(alumnos[i])) {
	                            	
	                                System.out.println("Alumno matriculado exitosamente en el curso virtual " + cursoVirtual.getNomcurso());
	                                
	                            } else {
	                            	
	                                System.out.println("No se pudo matricular al alumno en el curso virtual. El curso está completo.");
	                            }
	                        }
	                        
	                        break;
	                    }
	                }
	            }

	            // Si no se encontró el curso presencial ni el virtual, dar opcion de crearlo y volver a matricular alumnos en el
	            if (!cursoEncontrado) {
	            	
	                System.out.println("El curso con ID " + idCurso + " no existe.");
	                
	                System.out.print("¿Que tipo de curso desea agregar con ID " + idCurso + "? (P/V): ");
		            String opcion = scanner.nextLine();
		            
		            if (opcion.equalsIgnoreCase("P")) {
		            	
		                agregarNuevoCursoPresencial(cursosPresenciales, idCurso);
		                
		            } else {
		            	
		            	  agregarNuevoCursoVirtual(cursosVirtuales, idCurso);
		            }
	            }
	       
	        	} else {
	        		
	            System.out.println("El usuario con DNI " + dni + " no existe.");
	            
	            System.out.println("No se encontró ninguna persona con ese DNI.");
	            
	            System.out.print("¿Desea agregar un nuevo alumno (A) o profesor (P)? ");
	            
	            char respuesta = scanner.nextLine().toUpperCase().charAt(0);

	            if (respuesta == 'A') {
	            	
	                altaAlumno(alumnos);
	                
	            } else if (respuesta == 'P') {
	            	
	                altaProfesores(profesores);
	                
	            } else {
	            	
	                System.out.println("Respuesta no válida.");
	            }
	        }
	            
	    
	    }

}
