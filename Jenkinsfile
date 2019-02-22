pipeline {
    agent maven

    environment {
      DOCKER_IMAGE = 'dockermgeo/jcontester'
      BUILD_RELEASE_NUMBER = 1
    }

    stages {
        stage('PreBuild') {
            steps {
                sh 'echo "${BUILD_RELEASE_NUMBER}.${BUILD_NUMBER}">docker_root/version'
            }
         }

        stage('JavaBuild') {
            steps {
                sh '''
                    mvn clean install
                '''
            }
         }

        stage('Dockerbuild') {
            steps {
                sh '''
                    docker build -t ${DOCKER_IMAGE} .
                '''
            }
         }


        stage('Publish Dockerhub') {
            steps {
                sh '''
                    docker push ${DOCKER_IMAGE}
                '''
            }
         }
    }

}