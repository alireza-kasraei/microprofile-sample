pipeline {
    agent any
    tools {
        jdk 'JDK 1.7'
        maven 'MAVEN 3.5.4'
    }
    stages {
        stage('checkout source') {
            steps {
                git url: 'git@<GIT_URL>.git', credentialsId: '<CREDENTIALS>', branch: '<BRNACH_NAME>'
               }
        }
        stage('build') {
            steps {
                sh 'mvn clean package -s "/opt/settings-nexus.xml" -Pbackbase'
               }
        }

        stage('deploy') {
            steps {
                sh 'mvn deploy -Pbackbase -s "/opt/settings-nexus.xml"'   
                 
               }
        }
        
        stage('sonar') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=<SONAR_HOST> -Dsonar.login=<SONAR_LOGIN_ID> -s "/opt/settings-nexus.xml" -Pbackbase,sonar'   
                 
               }
        }
    
        stage('build docker image') {
            steps {
                dir('sample-devk-web'){
                    sh 'mvn docker:build -s "/opt/settings-nexus.xml"'      
                }
               }
        }
    }
}