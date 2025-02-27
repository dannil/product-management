# Product Management

A webapp for managing a product inventory. The frontend is built using TypeScript, Vite, and React,
while the backend is built using Java and Spring Boot. The app utilizies Postgres 17 as database management system.

## Setup

The following tools needs to be installed to run the app.

* Java 21
* Node 22
* Maven
* npm
* Docker

As part of the first-time setup, make sure to run `npm install` in the `frontend` directory
and `mvn package` in the `backend` directory.

## Run

There's two ways of running the app, either in development mode or production mode via Docker
utilizing Docker Compose.

In both modes, the services will be listening on the following IP and ports:
* Frontend: `localhost:5173`
* Backend: `localhost:8080`
* Database: `localhost:5432`

### Development

The instructions assumes you're in the root directory of the repository.

#### Database

`docker run -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:17`

Or any other locally running instance on port 5432, but Docker is recommended. The app
defaults to `postgres` for username, password, and database to use so in that case make sure
that the database and login role already exists and it has read/write on the database.

#### Frontend

1. `cd frontend`
2. `npm run dev`

#### Backend

Before starting the backend, make sure that the database is running and accessible.

1. `cd backend`
2. `mvn spring-boot:run`

### Production

`docker compose up`

The Dockerfiles includes configuration to compile and package the frontend and backend
so there's no need to manually run for example `npm run build` before-hand.
