# **Persona-crud**

**Demo CRUD Microservice - Java 21 + Spring Boot (felcas)**

Este proyecto es un microservicio CRUD de ejemplo desarrollado con Java 21 y Spring Boot 3.x.
Su propósito es demostrar una arquitectura básica de microservicio con:

**Endpoints RESTful**

Persistencia con Spring Data JPA y H2 (en memoria)

Tests unitarios (JUnit 5 + Mockito + MockMvc)

Reporte de cobertura con JaCoCo

CI/CD con Jenkins, SonarQube y Docker Hub

**Datos del proyecto**

ArtifactId (pom.xml): persona-crud

Jar final empaquetado: persona-crud.jar

Imagen Docker (namespace): fmcastre/persona-crud

**Ejecución local**

Clona el proyecto y compílalo:

mvn clean package

**Ejecuta los tests:**

mvn test

**Levanta el servicio:**

mvn spring-boot:run

Por defecto, el servicio estará disponible en:
http://localhost:8080/api/persons

**Docker**

Construir imagen (usando el JAR final persona-crud.jar):

mvn clean package
docker build -t fmcastre/persona-crud:latest .

**Ejecutar contenedor:**

docker run -p 8080:8080 fmcastre/persona-crud:latest

# **Tecnologías y Herramientas**

Java + Spring Boot: Backend REST para operaciones CRUD

Docker: Contenerización del microservicio

Jenkins: Automatización del pipeline CI/CD

SonarQube: Análisis estático de calidad de código

Docker Hub: Registro de imágenes Docker

GitHub: Repositorio del código fuente

**Archivos Clave**

Dockerfile: Define cómo construir la imagen Docker del microservicio

Jenkinsfile: Contiene el pipeline declarativo para Jenkins (build, test, análisis, despliegue)

sonar-project.properties: Configuración para el análisis de código en SonarQube

**Flujo CI/CD Automatizado**

El proyecto sigue un flujo CI/CD completamente automatizado usando Jenkins:

Checkout del código desde GitHub:
https://github.com/castrejonfelipe/persona-crud.git

**Build del proyecto usando Maven**

Ejecución de pruebas unitarias para asegurar la funcionalidad básica

Análisis de código con SonarQube mediante el archivo sonar-project.properties

Construcción de la imagen Docker con el Dockerfile

Publicación automática en Docker Hub, incluyendo tagging con la versión o commit hash

**Despliegue con Docker**

Una vez publicada la imagen, puedes ejecutar el contenedor localmente con:

docker pull <tu_usuario_dockerhub>/persona-crud:latest
docker run -p 8080:8080 <tu_usuario_dockerhub>/persona-crud:latest

**Estructura del proyecto**

<img width="320" height="223" alt="image" src="https://github.com/user-attachments/assets/615c3b45-8e30-42b8-9ea0-733545c3ed9e" />


## **Evidencia en Jenkins**

Este proyecto cuenta con integración continua y control de calidad automatizado para asegurar la estabilidad y calidad del código.

**Jenkins**
Se utiliza Jenkins para la construcción y pruebas automáticas del proyecto.
El estado actual del build se muestra a continuación.

<img width="1309" height="636" alt="image" src="https://github.com/user-attachments/assets/5a9b3875-6a9c-4645-bcda-47169aaf2252" />


**SonarQube**
La calidad del código es analizada mediante SonarQube, que verifica vulnerabilidades, bugs y la cobertura de pruebas.

  <img width="1135" height="440" alt="image" src="https://github.com/user-attachments/assets/1bcfd885-0f53-4830-874a-676b795e4e54" />


**Docker Hub**
La imagen Docker del proyecto está publicada en Docker Hub, facilitando su despliegue y distribución.

 <img width="1150" height="605" alt="image" src="https://github.com/user-attachments/assets/3e6d8be0-04e6-465c-865d-997085a04e59" />

**Proyecto**  persona-crud

 <img width="645" height="507" alt="image" src="https://github.com/user-attachments/assets/02a4d9b8-3bd9-47c1-93f9-48e35a9a335a" />

 <img width="644" height="506" alt="image" src="https://github.com/user-attachments/assets/3e333507-7963-4835-96d2-9625d792994e" />

