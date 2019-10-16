pipeline {
    agent any
    tools {
        maven 'jenkins_maven'
    }
    stages {
        stage('Dependency check') {
            steps {
                sh "mvn dependency:tree"
                sh "mvn dependency:analyze"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('SonarQube') {
            steps {
                sh "mvn -P sonar clean verify sonar:sonar"
            }
        }

        stage('Install') {
            steps {
                sh "mvn install -Dmaven.skip.test"
            }
        }
    }
}
