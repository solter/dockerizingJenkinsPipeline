pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /var/jenkins_home:/var/local'
        }

      }
      steps{
        sh 'cd application; umask 0002; mvn -X -Dmaven.repo.local=/var/local/.m2 -B -e compile'
      }
    }

    stage('Unit Test') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /var/jenkins_home:/var/local'
        }

      }
      steps{
        sh 'cd application; umask 0002; mvn -X -Dmaven.repo.local=/var/local/.m2 -B install'
      }
    }

    stage('Dockerize') {
      agent any
      steps {
        ansiblePlaybook(inventory: './infrastructure/ansible/localhosts', playbook: './application/package.yml')
      }
    }
  }
}
