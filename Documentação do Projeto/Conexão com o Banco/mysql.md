
## Conexão MySQL Workbanch

**Passo 1 - arquivo application.properties**

- Procure dentro da arvore do projeto o arquivo: **application.properties,** ele e usado para definir as configurações de acesso local ao banco, ele fica dentro de resources, que fica dentro do arquivo main do  prejeto

![image](https://user-images.githubusercontent.com/60848932/118573510-16f41780-b759-11eb-916a-18fb9e148d49.png)

- Inserir dentro do arquivo a seguinte configuração:

```sql
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.datasource.url=jdbc:mysql://localhost:3306/wishlist
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**2 - Configuração do MySQL Workbanch**

- Dentro do Mysql deve criar uma conexão caso não tenha uma criada:

![image](https://user-images.githubusercontent.com/60848932/118573551-28d5ba80-b759-11eb-83ac-c21bb81f8f58.png)

- Em seguida entrar dentro da conexão e criar um database:

![image](https://user-images.githubusercontent.com/60848932/118573585-37bc6d00-b759-11eb-8a8b-bf80b32a9534.png)

```sql
create database wishlist;
```

- Acesse a database e a deixe selecionada:

**3 . Rodar o projeto:**

- Para compilar o projeto vá até a pasta onde se encontra o arquivo pom.xml e execute no terminal o comando: ***"mvn clean install"***
- Se o resultado do build for BUILD SUCCESS, rode o projeto usando: ***"mvn exec:java"***

**4. Testar API pelo Swagger:**

- Acesso a API [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
