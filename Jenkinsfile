pipeline {
  agent any
  stages {
    stage('hello_world') {
      parallel {
        stage('hello_world') {
          steps {
            echo 'hello world'
          }
        }

        stage('build') {
          steps {
            sh 'cd application; mvn test-compile'
          }
        }

      }
    }

  }
}