pipeline {
  agent {
        docker {
          image 'maven:3-alpine'
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

    stage('Dockerize') {
      steps {
        ansiblePlaybook(inventory: './infrastructure/ansible/localhosts', playbook: './application/package.yml')
      }
    }
  }
}
