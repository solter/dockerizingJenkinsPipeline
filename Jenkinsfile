pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'cd application; mvn -B compile'
      }
    }

    stage('Unit Test') {
      steps {
        sh 'cd application; mvn -B verify'
      }
    }

    stage('Package') {
      steps {
        sh '''cd application; docker build -t pmsolfest/project1.1-application:slp1.1 .
'''
      }
    }

    stage('Integration Test') {
      steps {
        echo 'TODO: poke localhost:56324 with a test script'
      }
    }

    stage('Upload') {
      steps {
        echo 'TODO: upload image to dockerhub'
      }
    }

  }
}