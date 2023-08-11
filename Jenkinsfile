pipeline {
    agent any

    tools {
        gradle "gradle"
    }

    stages {
        stage('Compile') {
            steps {
                sh "gradle classes"
            }
        }
        stage('Test') {
            steps {
                sh "gradle test"
            }
        }
        stage('Build') {
            steps {
                sh "gradle clean build"
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker --version"
            }
        }
    }

}
