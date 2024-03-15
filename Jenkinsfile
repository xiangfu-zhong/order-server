pipeline {
    agent any

    stages {
        stage('check code') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'ac29986c-792e-475e-89e5-b86a772e269e', url: 'https://gitlab.com/zxf2/order-server.git']])
            }
        }

        stage('maven package') {
            steps {
                echo 'maven package'
                sh 'mvn -v'
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
    }
}
