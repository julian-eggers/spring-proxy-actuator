node 
{
  stage('Checkout')
  {
    checkout scm
  }
  
  stage('Build')
  {
    mvn 'clean package -Dmaven.test.skip=true'
  }
  
  stage('Unit-Tests')
  {
    mvn 'test'
  }
  
  stage('Deploy')
  {
    mvn 'deploy -Dmaven.test.skip=true'
  }
}  

def mvn(args) 
{
    sh "mvn ${args}"
}
