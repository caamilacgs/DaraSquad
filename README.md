<div align=center>
    <a><img width="550" alt="Logo" src="https://user-images.githubusercontent.com/60848932/118202545-910e5e80-b430-11eb-9797-3c3b08d9a938.png"></a>

# DaraSquad - WishList

Projeto desenvolvido  para formação em JAVA da  <a href="https://corp.gama.academy/luiza-code/inscricao#:~:text=O%20Luiza%20%C3%A9%20um,para%20mulheres%2C%20criado%20pelo%20Magalu.&text=O%20programa%20busca%20mulheres%20apaixonadas,e%20acreditam%20na%20transforma%C3%A7%C3%A3o%20digital./">LuizaCode</a> em parceria com a <a href="https://fieldcontrol.com.br/">GamaAcademy</a>.

</div><br>

## 💻 Sobre o Projeto

Foi desenvolvido um serviço HTTP para demostrar algumas funcionalidade da wishlist, por meio do relacionamento de Três tabelas sendo elas: Cliente, Wishlist e Produto.

No nosso projeto é possivel realizar:
- Cadastro de produto
- Cadastro de cliente
- Adicionar um produto na Wishlist da cliente;
- Remover um produto da Wishlist da cliente;
- Consultar todos os produtos da Wishlist da cliente;
- Consultar se um determinado produto está na Wishlist da cliente;

<br>


## 🛠 Tecnologias Utilizadas

As seguintes ferramentas foram utilizadas na construção do projeto:

&rarr; <a href="https://trello.com/b/GNsUcO4e/dara-squad-wishlist"> Trello </a> - Kanban de tarefas do time.  <br>
&rarr; <a href="https://www.notion.so/DARA-SQUAD-Luiza-Code-22a6a76568fe493ea40845044adc0760">Notion </a> - Anotações e relatorios do time.  <br>
&rarr; <a href="https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html">Java</a> - Linguagem de programação utilizada. <br>
&rarr; <a href="https://spring.io/">SpringBoot</a> - Frameworks java utlizada no projeto. <br>
&rarr; <a href="https://maven.apache.org/">Maven </a> - Gerenciar as dependências do projeto. <br>
&rarr; <a href="https://www.mysql.com/">Mysql</a> - Banco de dados  <br>
&rarr; <a href="https://www.postman.com/">Postman</a> - Teste local das APIs  <br>
&rarr; <a href="https://swagger.io/">Swagger</a> - Documentação da APIs.  <br>

<br>

## 👷 Como rodar?

#### > Pre Requsitos para rodar:

* Ter o [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) instalado (JDK e JRE).
* Ter o [Maven](https://maven.apache.org/) instaldo.

#### > Dependencias do Projeto:

- <a href="https://spring.io/projects/spring-data-jpa#overview">Spring Data JPA</a><br>
- <a href="https://spring.io/projects/spring-ws">Spring Web</a><br>
- <a href="https://spring.io/projects/spring-boot">Spring Boot DevTools</a><br>
- <a href="https://spring.io/guides/gs/accessing-data-mysql/">MySQL Driver </a><br>
- <a href="https://spring.io/guides/gs/accessing-data-jpa/">H2database</a><br>
- <a href="https://projectlombok.org/setup/maven">Lombok </a><br>

<br>

Clone o repositório:
```bash
$ git clone https://github.com/caamilacgs/DaraSquad
```
Entre dentro da pasta:
```bash
$ cd DaraSquad
```
<br>

#### > Compilando e rodando o projeto:
- Acesse o projeto por uma IDE de sua preferência: INTELIJ, ECLIPSE, VSCODE etc.
- Consulte o arquivo aplication.properties para definir as configurações de acesso local ao banco.
    - <a href="https://github.com/caamilacgs/DaraSquad/blob/camila/conexao/h2.md"> Procedimento de como configurar o banco H2 </a>
    - <a href="https://github.com/caamilacgs/DaraSquad/blob/camila/conexao/mysql.md"> Procedimento de como configurar o banco MYSQL </a>
    
- Para compilar o projeto vá até a pasta onde se encontra o arquivo `pom.xml` e execute no terminal o comando: `mvn clean install`

- Se o resultado do build for `BUILD SUCCESS`, rode o projeto usando: `mvn exec:java`

- Logo após, abra o seu navegador e acesse os seguintes caminhos:
    - Para acessar a pagina inicial: `http://localhost:8080/`
    - Para acessar a pagina do swagger: `http://localhost:8080/swagger-ui.html`

<br>


## :star2: Agradecimentos 

<div>
    <a><img width="400" src="https://user-images.githubusercontent.com/60848932/116348287-346e3b00-a7c4-11eb-899c-f6740102d6ae.png"></a>
</div>
<br>

## :woman_technologist: Autoras

<table>
    <td align="center"><br/>
        <a href="https://github.com/amandagsa">
            <img src="https://avatars.githubusercontent.com/u/52843599?v=4" width="105px;"
                alt="Amanda Gabriely" /><br><sub><b>Amanda Gabriely</b></sub><br></a><br/>
        <p align="center">
            <a href="https://github.com/amandagsa">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="https://www.linkedin.com/in/amandagsalves/">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:amandagsal@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
    <td align="center"><br/>
        <a href="https://github.com/caamilacgs">
            <img src="https://avatars.githubusercontent.com/u/60848932?v=4" width="105px;"
                alt="Imagem da Camila" /><br /><sub><b>Camila Coutinho</b></sub></a><br/><br/>
        <p align="center">
            <a href="https://github.com/caamilacgs">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="https://www.linkedin.com/in/caamilacgs">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:caamilacgs@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
    <td align="center"><br/>
        <a href="https://github.com/deborah6150">
            <img src="https://avatars.githubusercontent.com/u/53862960?v=4" width="105px;"
                alt="Imagem da Deborah" /><br /><sub><b>Deborah Caroline</b></sub></a><br><br/>
        <p align="center">
            <a href="https://github.com/deborah6150">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="https://www.linkedin.com/in/deborah-caroline-702690181/">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:deborahcaroline615@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
    <td align="center"><br/>
        <a href="https://github.com/mayleme">
            <img src="https://avatars.githubusercontent.com/u/68359875?v=4" width="105px;"
                alt="Imagem da Mayara" /><br><sub><b>Mayara Amaral</b></sub></a> <br /><br/>
        <p align="center">
            <a href="https://github.com/mayleme">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="https://www.linkedin.com/in/mayara-amaral-leme-46533b62/">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:mayara.amleme@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
    <td align="center"><br/>
        <a href="https://github.com/TaianeSB-94">
            <img src="https://user-images.githubusercontent.com/60848932/118201902-f9f4d700-b42e-11eb-9722-45882a84674b.png" width="105px;"
                alt="Imagem da Taiane" /> <br /><sub><b>Taiane Barbosa</b></sub></a><br><br/>
        <p align="center">
            <a href="https://github.com/TaianeSB-94">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="www.linkedin.com/in/taiane-barbosa">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:taianesb94@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
    <td align="center"><br/>
        <a href="https://github.com/thaila-davanco">
            <img src="https://avatars.githubusercontent.com/u/83316149?v=4" width="105px;"
                alt="Imagem da Thaila" /><br /><sub><b>Thaila Davanço</b></sub></a><br><br/>
        <p align="center">
            <a href="https://github.com/thaila-davanco">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="https://www.linkedin.com/in/thaila-davan%C3%A7o-56a609152/">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:davancothaila@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
    </tr>
</table>

<br>
<br>

<p>by DaraSquad 💜 </p><br>
