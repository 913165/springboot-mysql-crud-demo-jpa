FROM openjdk:22-ea-1

# set the working directory in the container
WORKDIR /app

ENV USERNAME=${USERNAME}
ENV PASSWORD=${PASSWORD}

# copy the dependencies file to the working directory
COPY target/*.jar /app/PBooksApp.jar

# PORT
EXPOSE 8080

# command to run on container start
CMD ["java", "-jar", "PBooksApp.jar"]

# docker build -t tinumistry/pbooksapp:1.0 .

# docker run -d -p 8080:8080 -e USERNAME=user123 -e PASSWORD=Pass123 --name booksapp  tinumistry/pbooksapp:1.0 .

# docker push tinumistry/pbooksapp:1.0
