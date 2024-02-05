FROM karthikpnrao/spring_ubuntu_mysql:1.2
EXPOSE 8000
ADD . /usr/local/bookApplication
COPY /build/libs/BooksRepository-1.0.0.jar /usr/local/bookApplication/BooksRepository-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/usr/local/bookApplication/BooksRepository-1.0.0.jar"]