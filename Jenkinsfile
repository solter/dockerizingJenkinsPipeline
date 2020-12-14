pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /var/jenkins_home/.m2:/root/.m2'
        }
      }
      steps{
        sh 'cd application; mvn -B compile'
      }
    }
    stage('Unit Test') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /var/jenkins_home/.m2:/root/.m2'
        }
      }
      steps{
        sh 'cd application; mvn -B verify'
      }
    }
    stage('Package') {
      agent any
      steps {
        ansiblePlaybook(
          inventory: './infrastructure/ansible/localhosts', 
          playbook:'./application/package.yml')
      }
    }
    stage('Integration Test') {
      agent any
      steps {
        echo "TODO: poke localhost:56324 with a test script"
      }
    }
    stage('Upload') {
      agent any
      steps {
        echo "TODO: upload image to dockerhub"
      }
    }
  }
}
