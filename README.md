# Shopping List App

## Proxy Setup

- As to Ubuntu, set ignore hosts in Network Proxy Settings

```value
0.0.0.0, localhost, 127.0.0.0/8, ::1
```

## Docker Setup

- Install Docker for Ubuntu (not Docker Desktop)
- Install Docker desktop for Mac
- Install Docker desktop with WSL2 for Windows

## back-end setup
### JDK Setup

- Install JDK 17 tem using SDKMAN(for Mac/Linux) or Chocolatey/Jabba(for Windows)
- Install Gradle 8.3 using SDKMAN(for Mac/Linux) or Chocolatey(for Windows)

### IDE Setup

- Install Intellij IDEA Ultimate Edition
- Install JPA Buddy plugin in Intellij IDEA

### Blank Back-end Project Setup - start.spring.io

- lombok
- spring web
- spring data jpa
- flyway migration
- postgresql driver

### How to run the back-end application

- Start postgres database and pgadmin using docker compose

```shell
cd infrastructure
docker compose up -d
```

- Start the web application

go to `back-end` folder

```shell
./gradlew bootRun
```

- Check the API using Insomnia

open Insomnia -> shoppling list collection -> add a shopping item

- Check the database using pgadmin

open portainer -> 
http://localhost:9443 -> 
Containers -> 
infrastructure-pgadmin-1 -> 
click the link "5050:80" -> 
username/password: wubin28@gmail.com/wubin28@gmail.com -> 
Servers 

  - Register a server

  right-click Servers -> 
  Register -> 
  Server... -> 
  General -> 
  Name: shopping-list-db -> 
  Connection -> 
  Host name/address: postgres -> 
  Port: 5432 -> 
  Maintenance database: postgres -> 
  Username: postgres -> 
  Password: postgres -> 
  Save password? Yes

  - Connect to the server
  
  shopping-list-db -> 
  databases -> 
  shoppingList -> 
  schemas -> 
  public -> 
  tables -> 
  shopping_item -> 
  right-click -> 
  "View/Edit Data" -> 
  All Rows

### How to check api documentation

http://localhost:8081/swagger-ui.html

### How to check API functions in a tool

- Install Insomnia (https://insomnia.rest/)
- Run database and db admin: ```docker compose up -d```
- Run the application: ```./gradlew bootRun```
- Open Insomnia -> 

  add a collection -> 
  add POST request ->
    createShoppingItem
      POST: localhost:8081/api/v1/shopping-items ->
      JSON: {"title": "milk", "purchased": false} ->
      Send
  add GET request ->
    getAll
      GET: localhost:8081/api/v1/shopping-items ->
      Send
    getById
      GET: localhost:8081/api/v1/shopping-items/1 ->
      Send
  add PUT request -> 
    updateShoppingItem
      PUT: localhost:8081/api/v1/shopping-items/1 ->
      JSON: {"title": "milk", "purchased": true} ->
      Send
  add DELETE request ->
    deleteShoppingItem
      DELETE: localhost:8081/api/v1/shopping-items/1 ->
      Send

## front-end setup

go to `front-end` folder

- Install node.js and npm using nvm

https://github.com/nvm-sh/nvm

```shell
nvm -v
nvm ls-remote
nvm install --lts
nvm ls
node -v # v18.18.0
```

- generate scaffold project using create-vue

https://github.com/vuejs/create-vue

```shell
npm create vue@latest
cd front-end
vue -V
npm install
npm run format
npm run dev
```

- Install vue-axios for using Axios conveniently to make HTTP requests to back-end server or API

https://www.npmjs.com/package/vue-axios

```shell
npm install --save axios vue-axios
npm list
```

- Install element-plus for high-quality components like buttons, tables, dialogs, etc.

https://element-plus.org/en-US/guide/installation.html#version

```shell
npm install element-plus --save
npm list
npm info element-plus
```

### Front-end IDE Setup

- Install WebStorm

### Project setup to install all dependencies
```
npm install
```

### How to run the vue.js app - Compiles and hot-reloads the front-end app for development
```
npm run serve
```

Visit the app from localhost or another machine

http://localhost:8080/

http://192.168.31.180:8080

### Compiles and minifies for production

```
npm run build
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).
