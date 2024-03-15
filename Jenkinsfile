pipeline {
    agent any

    stages {
        stage('check code') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '859973f1-c4e8-44e1-bfea-7bca90885112', url: 'https://gitlab.com/zxf2/order-server.git']])
            }
        }


        stage('maven package') {
            steps {
                echo 'maven package'
                sh 'mvn -v'
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }

        stage('build image') {
            steps {
                echo 'build image'
                sh 'mv ./target/*.jar .'
                sh 'docker build -t order-server .'
            }
        }

        stage('push image') {
            steps {
                echo 'push image'
                sh '''docker login -u admin -p Harbor12345 192.168.126.146:80
                docker tag order-server 192.168.126.146:80/repo/order-server:v1
                docker push 192.168.126.146:80/repo/order-server:v1'''
            }
        }
    }
}
