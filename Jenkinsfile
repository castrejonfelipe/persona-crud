pipeline {
  agent any
  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
    DOCKER_IMAGE = "fmcastre/persona-crud:${env.BUILD_NUMBER ?: 'latest'}"
    SONAR_HOST_URL = credentials('sonar-host')
    SONAR_LOGIN = credentials('sonar-token')
  }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests package'
      }
    }
    stage('Unit Tests & JaCoCo') {
      steps {
        sh 'mvn -B test jacoco:report'
        junit 'target/surefire-reports/*.xml'
        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/site/jacoco', reportFiles: 'index.html', reportName: 'JaCoCo Report'])
      }
    }
    stage('SonarQube Analysis') {
      steps {
        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
          sh "mvn -B sonar:sonar -Dsonar.login=$SONAR_TOKEN -Dsonar.host.url=${SONAR_HOST_URL}"
        }
      }
    }
    stage('Docker Build & Push') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
          sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
          sh "docker build -t ${DOCKER_IMAGE} ."
          sh "docker push ${DOCKER_IMAGE}"
        }
      }
    }
  }
  post {
    always { cleanWs() }
  }
}
