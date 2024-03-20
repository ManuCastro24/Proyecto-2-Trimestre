# Proyecto-2-Trimestre
Introducción
Este manual describe la estructura y el funcionamiento de la base de datos del colegio, que incluye información sobre los cursos, los alumnos, los profesores del colegio.

# Estructura de la Base de Datos
La base de datos del colegio se compone principalmente de las siguientes entidades:

Miembros del Colegio: Esta entidad representa a todos los miembros del colegio, incluyendo alumnos, profesores y cualquier otro personal. La clase MiembroColegio proporciona los atributos comunes a todos los miembros, como DNI, nombre, dirección, teléfono, fecha de nacimiento y correo electrónico.

Alumnos: La clase Alumnos extiende la clase MiembroColegio y agrega atributos específicos para los alumnos, como un identificador único (IdAlumno). También incluye métodos para calcular la edad del alumno y para obtener una representación en formato de cadena de texto.

Profesores: La clase Profesores también extiende la clase MiembroColegio y agrega atributos específicos para los profesores. Al igual que la clase Alumnos, incluye métodos para obtener información sobre los profesores.

Cursos: Hay dos tipos de cursos en la base de datos: cursos presenciales y cursos virtuales. Ambos tipos de curso implementan la interfaz Curso. Cada curso tiene un nombre, una capacidad máxima de estudiantes y un estado (activo o inactivo). Los cursos presenciales también tienen un número de aula, mientras que los cursos virtuales tienen una URL asociada.

# Relaciones entre Entidades
Las relaciones principales entre las entidades son las siguientes:

Herencia: La clase Alumnos y la clase Profesores heredan atributos y métodos de la clase MiembroColegio.

Composición: La clase Alumnos se compone de los atributos heredados de MiembroColegio, lo que significa que un alumno está formado por sus datos personales.

Agregación: Tanto los cursos presenciales como los cursos virtuales pueden tener varios alumnos matriculados. Esta relación se representa mediante la agregación, ya que los cursos contienen una lista de alumnos matriculados.

Asociación: Los alumnos pueden estar matriculados en varios cursos, y los profesores pueden enseñar varios cursos. Esta relación se representa mediante asociaciones bidireccionales entre las entidades Alumnos, Profesores y Cursos.

# Funcionamiento
El funcionamiento básico de la base de datos del colegio implica la creación y gestión de cursos, así como la matriculación de alumnos y la asignación de profesores a los cursos. A continuación se describen algunas de las operaciones principales:

Crear un Curso: Para crear un curso, se instancia un objeto de la clase CursoPresencial o CursoVirtual con los parámetros adecuados, como el nombre del curso, la capacidad máxima de estudiantes y otros detalles específicos del tipo de curso.

Agregar Alumnos y Profesores: Una vez creado un curso, se pueden agregar alumnos y profesores utilizando los métodos agregarAlumno y agregarProfesor, respectivamente. Estos métodos aseguran que no se exceda la capacidad máxima del curso.

Eliminar un Curso: Cuando un curso ya no es válido o se ha completado, se puede eliminar utilizando el método EliminarCurso, que cambia el estado del curso a "Inactivo" y libera los recursos asociados, como el aula en el caso de los cursos presenciales o la URL en el caso de los cursos virtuales.

Consultar Información: Se pueden consultar detalles sobre los cursos, alumnos y profesores utilizando los métodos toString proporcionados por cada clase, así como otros métodos específicos para obtener información detallada.

# Conclusiones
La base de datos del colegio proporciona una estructura flexible para gestionar información sobre los cursos, alumnos y profesores. Con las clases y relaciones definidas, es posible llevar a cabo operaciones como la creación de cursos, la matriculación de alumnos y la asignación de profesores de manera eficiente y organizada.
