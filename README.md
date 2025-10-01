<<<<<<< HEAD
# persona-crud
Demo de microservcio
=======
# 🚀 Demo CRUD Microservice - Java 21 + Spring Boot (felcas)

Este proyecto es un **microservicio CRUD** de ejemplo desarrollado con **Java 21** y **Spring Boot 3.x**.
Su propósito es demostrar una arquitectura básica de microservicio con:

- ✅ Endpoints RESTful
- ✅ Persistencia con Spring Data JPA y H2 (en memoria)
- ✅ Tests unitarios (JUnit 5 + Mockito + MockMvc)
- ✅ Reporte de cobertura con JaCoCo
- ✅ CI/CD con Jenkins, SonarQube y Docker Hub

---

## 📦 Datos del proyecto
- **ArtifactId (pom.xml):** `felcas`
- **Jar final empaquetado:** `persona-crud.jar`
- **Imagen Docker (namespace):** `fmcastre/persona-crud`

---

## 🛠️ Ejecución local

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
👉 `http://localhost:8080/api/persons`

---

## 🐳 Docker

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

## 🤖 Jenkins Pipeline

El `Jenkinsfile` incluido realiza:

1. **Build:** `mvn clean package -DskipTests`
2. **Test + Cobertura:** `mvn test jacoco:report`
3. **Análisis SonarQube**
4. **Build + Push imagen Docker a Docker Hub**

> ⚠️ Asegúrate de configurar las credenciales en Jenkins:
> - `dockerhub-creds` → usuario/contraseña de Docker Hub  
> - `sonar-token` → token de SonarQube

---

## 📊 Reportes

- **JaCoCo:** `target/site/jacoco/index.html`
- **SonarQube:** Configurar en `sonar-project.properties`

---

## 🧱 Estructura

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

---

## 📜 Licencia

Este proyecto es libre de uso para pruebas, demostraciones o como plantilla base para nuevos microservicios 🚀
>>>>>>> 34f5d6c (Primer commit del proyecto demo)
