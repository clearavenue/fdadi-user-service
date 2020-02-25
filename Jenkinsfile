@Library('clearavenue/clearavenue-jenkins-sharedlib')_

mavenDevsecopsPipeline {
  app_name = 'fdadi'
  docker_user = 'clearavenuedocker'
  service_name = 'fdadi-user-service'
  service_port = 8082
  liveness_url = '/actuator/health'
  readiness_url = '/actuator/health'
  deploymentFile = 'internal-deployment.yaml'
}
