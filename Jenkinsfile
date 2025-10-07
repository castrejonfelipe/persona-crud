pipeline {
    agent none

    environment {
        IMAGE_NAME = "persona-crud"
        SONAR_HOST_URL = "http://sonarqube:9000"
        SONAR_TOKEN = credentials('sonar-token')
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }

    stages {

        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /var/jenkins_home/.m2:/root/.m2'
                }
            }
            steps {
                echo "Compilando el proyecto con Java 21..."
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Testing (JUnit + Jacoco)') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /var/jenkins_home/.m2:/root/.m2'
                }
            }
            steps {
                echo "Ejecutando pruebas..."
                sh 'mvn test jacoco:report'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /var/jenkins_home/.m2:/root/.m2'
                }
            }
            steps {
                echo "Analizando código con SonarQube..."
                withSonarQubeEnv('SonarQubeServer') {
                    sh """
                        mvn sonar:sonar \
                          -Dsonar.projectKey=persona-crud \
                          -Dsonar.host.url=$SONAR_HOST_URL \
                          -Dsonar.login=$SONAR_TOKEN
                    """
                }
            }
        }

        stage('Build Docker Image') {
            agent any
            steps {
                echo "Construyendo imagen Docker..."
                sh "docker build -t $IMAGE_NAME:${env.BUILD_NUMBER} ."
            }
        }

        stage('Push to DockerHub') {
            agent any
            steps {
                echo "Enviando imagen a DockerHub..."
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker tag $IMAGE_NAME:${env.BUILD_NUMBER} $USER/$IMAGE_NAME:${env.BUILD_NUMBER}"
                    sh "docker push $USER/$IMAGE_NAME:${env.BUILD_NUMBER}"
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline completado exitosamente. Imagen publicada en DockerHub."
        }
        failure {
            echo "El pipeline falló. Revisa los logs en Jenkins."
        }
    }
}
