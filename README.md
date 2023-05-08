## 깃허브 액션 SSH 테스트

1. ec2 인스턴스 생성 
2. 인바운드 규칙 설정
3. git repository -> Setting -> Security -> Secrets and variables에서 사용할 환경변수 등록 
   - ec2 인스턴스에서 유저 생성 후 id / password 를 이용해 ssh를 접속
   - ec2 인스턴스 생성시 만든 키페어 (.pem)을 이용해 ssh를 접속 
  
   (키 값으로 접속시 받은 키에 있는 -----BEGIN RSA PRIVATE KEY-----, -----END RSA PRIVATE KEY----- 포함해서 모두 입력해야 정상적으로 접속 가능)
   
   여기 사용된 action을 사용하고자 할 시, https://github.com/appleboy/ssh-action 여기를 참고하세요.

```
# This is a basic workflow to help you get started with Actions

name: deploy

# Controls when the workflow will run
on:
  # Triggers the workflow on push or pull request events but only for the main branch
  push:
    branches:
      - main

# A workflow run is made up of one or more jobs that can run sequentially or in parallel
jobs:
  SSH:
    runs-on: ubuntu-latest

    steps:
      - name: Run scripts in server
        uses: appleboy/ssh-action@v0.1.10
        with:
          key: ${{ secrets.SSH_KEY }}   
          host: ${{ secrets.HOST }}
          username: ${{ secrets.USER }}
          port: ${{ secrets.PORT }}
          script: |
            cd ActionTestRepo
            git reset --hard
            git fetch
            git pull
            ./gradlew build
            cd ~/ActionTestRepo/build/libs
            fuser -k -n tcp 9999
            sudo chmod 755 action-0.0.1-SNAPSHOT.jar
            nohup java -jar action-0.0.1-SNAPSHOT.jar &
```

현재 작성한건 그냥 ssh로 접속해서 

git pull 받고, gradlew로 빌드 후, 기존에 켜놨던 서버 포트 죽이고, 빌드된 jar파일 백그라운드로 실행하는 flow임 
