pipeline {
    agent any

    tools {
        gradle "gradle"
    }

    stages {
        stage('Build') {
            steps {
                sh "gradle clean build"
            }
        }
        stage('Test') {
            steps {
                sh "gradle test"
            }
        }
    }

}
