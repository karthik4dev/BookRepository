FROM karthikpnrao/spring_ubuntu_mysql:1.1
EXPOSE 8000
ADD . /usr/local/bookApplication
COPY /build/libs/BooksRepository-0.0.1-SNAPSHOT.jar /usr/local/bookApplication/BooksRepository-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/usr/local/bookApplication/BooksRepository-0.0.1-SNAPSHOT.jar"]