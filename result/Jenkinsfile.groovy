pipeline {
  agent any

  tools{
    nodejs 'NodeJS 8.9.0'
  }

  stages{
      stage(build){
      when { 
      changeset "**/result/**"             
           }

          steps{
              echo 'build'
              dir('worker'){
                sh 'npm install'
              }
          }
      }
      stage(test){
         when{
           changeset "**/result/**"
          }
          steps{
              echo 'test'
              dir('worker'){
                sh 'npm test'
              }
          }
      }      
  }

  post{
    always{
        echo 'Building multibranch pipeline for worker is completed..'
    }
  }
}