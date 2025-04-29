# 📜 API to Extract CSV
- ✨ Descrição

Este projeto é dividido em dois microsserviços:

- **Producer**: Receives a .csv file via HTTP request, processes the records using Spring Batch and sends them in batches of 10 users to a RabbitMQ queue.

- **Consumer**: Consumes messages from the RabbitMQ queue and registers users in the PostgreSQL database.

## To start
- 1º Install Java 21
- 2º Install PostgreSQL or use Docker
- 3º Install Postman or other.
- 4º Install IDE Spring Tools Suite
- 5º Import project and run.

## Dependencies
- 1º Spring Web
- 2º Spring Batch
- 3º Spring RabbitMQ
- 4º Spring Data JPQ
- 5º Spring PostgreSQL Driver

## 📈 Roadmap
- 1º Flow organization.
- 2º Creating the project using Spring Initializr and adding the necessary dependencies.
- 3º Creation of the producer microservice.
- 4º Creation of the consumer microservice.
- 5º RabbitMQ configuration.
- 6º Spring Batch configuration.

## 🚀 Features
- Producer, upload CSV archive,convert and send for RabbitMQ.
- Consumer, listener queue users, and process and save in the database. 🛠️(TO DO)🛠️
- Get all users. 🛠️(TO DO)🛠️

## 🚦 Flowchart
- 🛠️(TO DO)🛠️

## 🔗 Routes
- POST /upload-csv
- GET /users


## ✒️ Autor

* [**Romulo Matheus**](https://github.com/Romulomdr) - *At the moment developer Java back-end* [<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />](https://www.linkedin.com/in/romulo-dantasmdr/)
