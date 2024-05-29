# gradle:7.3.1-jdk17 이미지를 기반으로 함
#FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.3.1-jdk17
FROM gradle:7.3.1-jdk17-alpine

# 작업 디렉토리 설정
WORKDIR /home/gradle/project

# Spring 소스 코드를 이미지에 복사
COPY . .


# gradlew를 이용한 프로젝트 필드
RUN ./gradlew clean build

EXPOSE 8080

# 빌드 결과 jar 파일을 실행
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/home/gradle/project/build/libs/orem-0.0.1-SNAPSHOT.jar"]
