<div align="center">
# ToDo-API
<br>
<img src="https://w7.pngwing.com/pngs/972/511/png-transparent-todo-sketch-note-list-tasks-thumbnail.png" alt="Imagen de ToDo">
<h3>Este Repositorio contiene una Página para la Gestión de Tareas - ToDo con Spring Boot.</h3>

</div>

<h4>Pagina creada donde utilizamos HTML, CSS y JavaScript en la Web, para el consumo de la API creada con Java y utilizando el Framework de Spring y su herramienta de Spring Boot</h4>

Esta página permite Agregar taréas a realizar, Marcarlas como Realizadas y también Eliminarlas. Almacenandolas en la base de datos y ordenandolas por fecha y horario. Todo esto se realiza mediante la utilización de los endpoints que provee la API. Esto se puede realizarlo mediante funciones en JavaScript, que permite crear elementos, agregar clases y modificarlas e incluso eliminar esos elementos creados dinamicamente.

Base de Datos: de tipo Relacional, MySQL 

Swagger: Herramienta utilizada para la documentación de la API-REST

Postman: Herramienta utilizada para el testeo de la API-REST

## Backend

### Versiones utilizadas:

* Java Development Kit (JDK) 17
* Spring Boot 3.0.2

### Dependencias utilizadas para el proyecto:

* spring-boot-starter-web
* spring-boot-starter-test
* spring-boot-starter-data-jpa
* spring-boot-devtools
* mysql-connector-j
* lombok
* jakarta.validation-api
* springdoc-openapi-ui
* hibernate-validator

#### Para Crear el proyecto desde cero:

1. Ingresar a la página de Spring Initializr: https://start.spring.io/
2. Seleccionar las dependencias necesarias para el proyecto

![Crear Repositorio Initializr](https://i.postimg.cc/pXxVLj1P/Spring-Initializr.png)
3. Descargar el proyecto
4. Descomprimir el proyecto
5. Abrir el proyecto en un IDE (Eclipse, IntelliJ, NetBeans, etc) 
6. Agregar las dependencias restantes que no se encontraron en la página en el archivo <b>"pom.xml"</b> (conforme lista de dependencias anterior)

### Pasos para iniciar el proyecto:

1. Clonar el repositorio desde el GitHub

![Clonar Repositorio](https://i.postimg.cc/SxBFs2yy/Clonar.png)
2. Abrir el proyecto en un IDE (Eclipse, IntelliJ, NetBeans, etc)
3. Modificar el archivo "application.yml" con el usuario y contraseña de la base de datos.

![Modificar application.yml](https://i.postimg.cc/ZqW8fn3y/Properties.png)
4. (Opcional) en caso de no querer exponer el usuario y contraseña de la base de datos en el archivo "application.yml", se puede crear variables de entorno en el sistema operativo y llamarlas desde el archivo "application.yml" de la siguiente manera:
   - En la barra superior al lado del martillo verde (build), aparece el nombre del proyecto, hacer click y seleccionar "Edit Configurations..."
   - En la ventana que se abre, en la parte central de la pantalla seleccionar "Environment variables:" agregar las variables de entorno con el nombre de "DB_USER" y "DB_PASSWORD" y el valor correspondiente a cada una.
   
![Variables de Entorno 1](https://i.postimg.cc/52yJRWtC/Config-user-y-pass-1.png)
![Variables de Entorno 2](https://i.postimg.cc/Ss6bMygw/Config-user-y-pass-2.png)
5. La base de datos en MySQL con el nombre de "db_todo_api" se creará automaticamente cuando el proyecto se inicie por primera vez.
6. (Opcional) en caso de necesidad de apertura de puertos: Utilizar sistema de gestión de bases de datos: en mi caso <b>XAMP</b>, para abrir los puertos de conexión.
7. Iniciar el proyecto desde el IDE

### Endpoints de la API

#### POST

El endpoint de creación de tareas es: http://localhost:8080/api/v1/tasks/create

En el body del request se debe enviar un JSON con el siguiente formato:

```json
{
    "title": "Tarea 1",
    "date": "2021-10-10",
    "time": "10:00"
}
```

#### GET

El endpoint de obtención de tareas es: http://localhost:8080/api/v1/tasks/all

#### PATCH

El endpoint de actualización del estado de la tarea es: http://localhost:8080/api/v1/tasks/mark_as_finished/{id}/{finished}

Entiendase que como id se debe enviar el "ID" de la tarea que se desea actualizar y como finished se debe enviar un booleano (true o false) para indicar si la tarea se encuentra finalizada o no.

#### DELETE

El endpoint de eliminación de tareas es: http://localhost:8080/api/v1/tasks/delete/{id}

Entiendase que como id se debe enviar el "ID" de la tarea que se desea eliminar.

### Testeo de la API

Para el testeo de la API se utilizó la herramienta Postman. 

Para ello comparto el Postman que tiene todas las pruebas realizadas para la API. Se puede descargar desde el siguiente link: [https://github.com/lokywolf2295/ToDo_Front_-_API/Tasks.postman_collection.json](https://github.com/lokywolf2295/ToDo_Front_-_API/blob/test/Tasks.postman_collection.json)

![Postman](https://i.postimg.cc/XNk1ZVS6/Postman.png)
### Documentación de la API

Para la documentación de la API se utilizó la herramienta Swagger.

Para acceder a la documentación de la API se debe ingresar a la siguiente URL: http://localhost:8080/swagger-ui/index.html

![Swagger](https://i.postimg.cc/GtXjXmdB/Swagger.png)
## Frontend

En el Frontend se utilizó HTML, CSS y JavaScript para la creación de la página web. No se utilizaron Frameworks de CSS ni de JavaScript. 
Haciendo que esta página sea estática pero si responsive.

![Frontend](https://i.postimg.cc/sDSYBmZQ/Frontend.png)

### Para correr la app

Uso la extensión de Live Server para poder correr la aplicación en un servidor local y que permite ver los cambios que se realizan en el codigo, de manera automática luego de guardar los cambios y sin necesidad de volver a correr la aplicación nuevamente.