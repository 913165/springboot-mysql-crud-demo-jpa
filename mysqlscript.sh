#!/bin/bash

# Step 1: Update package list and install Docker
sudo apt-get update
sudo apt-get install -y docker.io

# Step 2: Start Docker service
sudo systemctl start docker
sudo systemctl enable docker

# Step 3: Pull MySQL image
sudo docker pull mysql:latest

# Step 4: Run MySQL container with environment variables
sudo docker run -d -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=root123 mysql:latest

# Wait for MySQL to fully initialize
sleep 30  # Adjust this if needed

# Step 5: Create an SQL file with the database and table creation, and insert statements
cat <<EOF > init.sql
CREATE DATABASE IF NOT EXISTS bookdb;