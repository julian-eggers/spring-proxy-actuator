node 
{
  stage 'Checkout'
  checkout scm

  stage 'Build'
  mvn 'clean package'
}


def mvn(args) 
{
    sh "${tool 'Maven'}/bin/mvn ${args}"
}
