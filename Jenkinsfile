node 
{
  stage 'Checkout'
  checkout scm

  stage 'Build'
  mvn 'clean package -Dmaven.test.skip=true'
  
  stage 'Unit-Tests'
  mvn 'clean package'
  
  stage 'Deploy'
  mvn 'clean deploy -Dmaven.test.skip=true'
}

def mvn(args) 
{
    sh "mvn ${args}"
}
