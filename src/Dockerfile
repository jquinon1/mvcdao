FROM java:7
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac *.java
CMD ["java","-classpath","./mysql-connector-java-5.1.46/mysql-connector-java-5.1.46.jar:.", "Principal"]
