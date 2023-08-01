node {

	stage('Checkout') {
		git url: 'https://github.com/lyn-Jia/EventManagementProject.git'
	}
	
	stage('Build') {
		bat 'gradle clean build'
	}

}