<<<<<<< HEAD

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

- **ArtifactId (pom.xml):** `felcas`
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

### Jenkins Pipeline

El `Jenkinsfile` incluido realiza:

1. **Build:** `mvn clean package -DskipTests`
2. **Test + Cobertura:** `mvn test jacoco:report`
3. **Análisis SonarQube**
4. **Build + Push imagen Docker a Docker Hub**

###  Reportes

- **JaCoCo:** `target/site/jacoco/index.html`
- **SonarQube:** Configurar en `sonar-project.properties`

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


https://www.dropbox.com/scl/fi/3xxp3ry6cbe6io2cvqhoo/Jenkis_P.JPG?rlkey=8xvr3gsy7l85hsrea4kemqx9p&st=d47ku1j5&raw=1


2.  **SonarQube:** La calidad del código es analizada mediante SonarQube, que verifica vulnerabilidades, bugs y la cobertura de pruebas.

https://www.dropbox.com/scl/fi/xtzq900anati7o99fze7p/sonar.JPG?rlkey=evc0w3wuyec2xaod40ohopruu&st=5pdcngqx&raw=1

3. **Docker Hub:** La imagen Docker del proyecto está publicada en Docker Hub, facilitando su despliegue y distribución.

https://www.dropbox.com/scl/fi/r5fntgwhk8ifzx0206hzj/dockerhub.JPG?rlkey=azduh6ygpv1nzpdo56wui20vv&st=2u7d263c&dl=0

