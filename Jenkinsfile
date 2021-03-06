pipeline {
  agent none
  environment {
    DOCKERHUB_CREDS = credentials('dockerhub-pmsolfest')
  }
  stages {
    stage('Build') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /var/jenkins_home:/var/local'
        }

      }
      steps{
        sh 'cd application; umask 0002; mvn -Dmaven.repo.local=/var/local/.m2 -B -e compile'

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
        sh 'cd application; umask 0002; mvn -Dmaven.repo.local=/var/local/.m2 -B install'
        stash includes: 'application/target/*.jar', name:'app'
        stash includes: 'application/Dockerfile', name:'dockerfile'
      }
    }

    stage('Dockerize') {
      agent any
      steps {
        unstash 'app'
        dir('/var/jenkins_home/app_build') {
          unstash 'dockerfile'
        }
        ansiblePlaybook(
          inventory: './infrastructure/ansible/localhosts', 
          playbook: './application/package.yml', 
          extraVars: [
            dockerhub_username: '$DOCKERHUB_CREDS_USR',
            dockerhub_password: '$DOCKERHUB_CREDS_PSW']
          )
      }
    }
  }
}
