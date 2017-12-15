pipeline {
  agent any
  stages {
    stage('Parallel Coolness') {
      parallel {
        stage('Say hello') {
          steps {
            echo 'Just sayin\' hello'
            sh 'date'
          }
        }
        stage('List files') {
          steps {
            sh 'ls -l'
          }
        }
      }
    }
    stage('Du') {
      steps {
        sh 'du -h'
      }
    }
  }
}
