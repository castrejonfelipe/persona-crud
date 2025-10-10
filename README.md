
### persona-crud

### Demo de microservcio

###  Demo CRUD Microservice - Java 21 + Spring Boot (felcas)

Este proyecto es un **microservicio CRUD** de ejemplo desarrollado con **Java 21** y **Spring Boot 3.x**.
Su propósito es demostrar una arquitectura básica de microservicio con:

-  Endpoints RESTful
-  Persistencia con Spring Data JPA y H2 (en memoria)
-  Tests unitarios (JUnit 5 + Mockito + MockMvc)
-  Reporte de cobertura con JaCoCo
-  CI/CD con Jenkins, SonarQube y Docker Hub

---

###  Datos del proyecto

- **ArtifactId (pom.xml):** `persona-crud`
- **Jar final empaquetado:** `persona-crud.jar`
- **Imagen Docker (namespace):** `fmcastre/persona-crud`
---
### Ejecución local

Clona el proyecto y compila:

```bash
mvn clean package
```
Ejecuta los tests:

```bash
mvn test
```
Levanta el servicio:

```bash
mvn spring-boot:run
```
Por defecto el servicio estará en:  
  `http://localhost:8080/api/persons`
---
###  Docker

Construir imagen (usando el JAR final `persona-crud.jar`):

```bash
mvn clean package
docker build -t fmcastre/persona-crud:latest .
```
Ejecutar contenedor:

```bash
docker run -p 8080:8080 fmcastre/persona-crud:latest
```

---
## Tecnologías y Herramientas

- **Java + Spring Boot**: Backend REST para operaciones CRUD.
- **Docker**: Contenerización del microservicio.
- **Jenkins**: Automatización del pipeline CI/CD.
- **SonarQube**: Análisis estático de calidad de código.
- **Docker Hub**: Registro de imágenes Docker.
- **GitHub**: Repositorio del código fuente.

##  Archivos Clave

- `Dockerfile`: Define cómo construir la imagen Docker del microservicio.
- `Jenkinsfile`: Contiene el pipeline declarativo para Jenkins (build, test, análisis, despliegue).
- `sonar-project.properties`: Configuración para el análisis de código en SonarQube.

## Flujo CI/CD Automatizado

El proyecto sigue un flujo CI/CD completamente automatizado usando Jenkins:

1. **Checkout del código** desde GitHub:  
   `https://github.com/castrejonfelipe/persona-crud.git`

2. **Build del proyecto** usando Maven.

3. **Ejecución de pruebas unitarias** para asegurar la funcionalidad básica.

4. **Análisis de código con SonarQube** mediante el archivo `sonar-project.properties`.

5. **Construcción de la imagen Docker** con el `Dockerfile`.

6. **Publicación automática en Docker Hub**, incluyendo tagging con la versión o commit hash.

## 🚀 Despliegue con Docker

Una vez publicada la imagen, puedes ejecutar el contenedor localmente con:

```bash
docker pull <tu_usuario_dockerhub>/persona-crud:latest
docker run -p 8080:8080 <tu_usuario_dockerhub>/persona-crud:latest

---

###  Estructura

```
src/
├─ main/java/com/example/demo/
│  ├─ model/Person.java
│  ├─ repository/PersonRepository.java
│  ├─ service/PersonService.java
│  ├─ controller/PersonController.java
│  └─ DemoApplication.java
└─ test/java/com/example/demo/
   ├─ service/PersonServiceTest.java
   └─ controller/PersonControllerTest.java
```
###  Evidencia en Jenkis 

 Este proyecto cuenta con integración continua y control de calidad automatizado para asegurar la estabilidad y calidad del código.

1. **Jenkins:** Se utiliza Jenkins para la construcción y pruebas automáticas del proyecto. 
   El estado actual del build se muestra a continuación. 

    <img width="1297" height="628" alt="image" src="https://github.com/user-attachments/assets/80de0a29-b9d2-4562-9a99-1f3916d85568" />

2.  **SonarQube:** La calidad del código es analizada mediante SonarQube, que verifica vulnerabilidades, bugs y la cobertura de pruebas.

     <img width="1135" height="442" alt="image" src="https://github.com/user-attachments/assets/4a1133fc-731f-4112-8384-6d2186271f06" />


3. **Docker Hub:** La imagen Docker del proyecto está publicada en Docker Hub, facilitando su despliegue y distribución.

    <img width="1145" height="611" alt="image" src="https://github.com/user-attachments/assets/7a70c404-5375-4539-9f42-21b051dab2d2" />



