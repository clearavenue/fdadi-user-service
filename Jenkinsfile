def dockerImage = "clearavenuedocker/fdadi-discovery"
def builtImg = ''
def SERVER_URL="http://a3fd36bd80a9747afb9405ff3ad944b2-354023137.us-east-1.elb.amazonaws.com"

pipeline {
  agent {
    kubernetes {
      yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: maven
    image: maven:3.6-jdk-11-slim
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: "/var/run/docker.sock"
      name: "volume-0"
      readOnly: false
  - name: docker
    image: docker
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: "/var/run/docker.sock"
      name: "volume-0"
      readOnly: false
  - name: kubectl
    image: lachlanevenson/k8s-kubectl:latest
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: "/var/run/docker.sock"
      name: "volume-0"
      readOnly: false
  volumes:
  - hostPath:
      path: "/var/run/docker.sock"
    name: "volume-0"
"""
    }
  }
  
  environment {
    VERSION=readMavenPom().getVersion()
  }
  
  stages {
    
    stage('Build') {
      steps {
        container('docker') {
          sh "docker build -t ${dockerImage}:${VERSION} ."
        }
      }
    }
    
    stage('JUnit') {
      steps {
        container('maven') {
          sh "mvn -B -e -T 1C test"
          junit 'target/surefire-reports/**/*.xml'
        }
      }
    }
    
    stage('CodeCoverage') {
      steps {
        container('maven') {
          sh "mvn -B -e -T 1C org.jacoco:jacoco-maven-plugin:0.8.4:prepare-agent verify org.jacoco:jacoco-maven-plugin:0.8.4:report"
          jacoco(execPattern: 'target/jacoco.exec', classPattern: 'target/classes', sourcePattern: 'src/main/java', exclusionPattern: 'src/test*', changeBuildStatus: true)
        }
      }
    }
    
    stage('StaticAnalysis') {
      steps {
        container('maven') {
          sh "mvn -B -e -T 1C com.github.spotbugs:spotbugs-maven-plugin:3.1.12.2:check -Dspotbugs.effort=Max -Dspotbugs.threshold=Low"
        }
      }
      post {
        always {
          recordIssues(enabledForFailure: true, tool: spotBugs())
        }
      }
    }
    
    stage('Vulnerabilities') {
      steps {
        container('maven') {
          sh "mvn -B -e -T 1C org.owasp:dependency-check-maven:5.3.0:aggregate -Dformat=xml"
        }
      }
      post {
        always {
          dependencyCheckPublisher(failedTotalCritical : 100, unstableTotalCritical : 100)
        }
      }
    }
    
    stage('Push Docker') {
      when {
        expression { currentBuild.result == 'SUCCESS' }
      }
      steps {
	    container('docker') {
	      script {
            docker.withRegistry('', 'docker') {
	          sh "docker push ${dockerImage}:${VERSION}"
	          sh "docker rmi ${dockerImage}:${VERSION}"
	        }                           
	      }
	    }
	  }
	}
    
    stage('Deploy') {
      when {
        expression { currentBuild.result == 'SUCCESS' }
      }
	  steps {
 	    container('kubectl') {
 	      script {
	        withKubeConfig([credentialsId: 'kube-admin', serverUrl: '${SERVER_URL}']) {
	          sh "kubectl apply -f fdadi-discovery-deployment.yaml"
	        }
	      }      
	    }
	  }
	}
  }
    
  post {
    failure {
        emailext attachLog: true, subject: '$DEFAULT_SUBJECT', body: '$DEFAULT_CONTENT', recipientProviders: [[$class: 'CulpritsRecipientProvider']]
    }
  }
}