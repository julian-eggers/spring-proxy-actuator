node 
{
  stage 'Checkout'
  checkout scm

  stage 'Build'
  mvn 'clean package'
  
  stage 'Deploy'
  mvn 'clean deploy'
}

def mvn(args) 
{
    sh "mvn ${args}"
}
