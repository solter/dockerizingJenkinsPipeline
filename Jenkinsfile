pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v $HOME/.m2:root.m2'
    }
  }
  stages {
    stage('Build') {
      steps{
        sh 'cd application; mvn -B compile'
      }
    }
    stage('Unit Test') {
      steps{
        sh 'cd application; mvn -B verify'
      }
    }
    stage('Package') {
      steps {
        echo "TODO: call ansible script"
      }
    }
    stage('Integration Test') {
      steps {
        echo "TODO: poke localhost:56324 with a test script"
      }
    }
    stage('Upload') {
      steps {
        echo "TODO: upload image to dockerhub"
      }
    }
  }
}
