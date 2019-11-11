**Microservices:**

```
Sistema de cadastro de usuários com notificação via Slack para o admin.
```

**Escolhas/Decisões Técnicas:**
```
As escolhas técnicas foram baseadas nas sugestões do exercício, bem como nas tendências do mercado.

- Spring Boot Web: é atualmente o principal framework de desenvolvimento Web Backend. O mesmo permite a construção de API's
  de maneira simples e eficiente. A partir do Spring Boot Web, o padrão REST foi utilizado na implementação dos endpoints,
  expondo as funcionalidades necessárias para a interação com o sistema.

- Spring Data: definido pelo exercício, é atualmente a principal técnologia Java para acesso a bancos de dados relacionais.
  O mesmo contempla a facilidade de termos a conexão com banco de dados de maneira simples, além de disponibilizar vários
  métodos já implementados (insert, delete, findById, queries baseadas na nomenclatura do método, etc). Foi utilizado
  para toda a interação entre a aplicação e o banco de dados.

- Maven: pré requisito do exercício. É um dos principais gerenciadores de dependências de aplicações Java. Além disso, todo
  o build é automatizado por ele. Foi utilizado para o gerenciamento de dependências e para o build da aplicação.

- Docker: é atualmente o principal serviço de containers. Os contaieners Docker possuem isolamento, além de permitir o
  deploy em qualquer ambiente. O docker foi utilizado para fornecer os serviços de Redis, Banco de Dados e o deploy
  da aplicação em si.

- Laravel: é o principal framework PHP do mercado para desenvolvimento de aplicações web, com diversos recursos e open-source.

- RabbitMQ: Servidor de mensageria de código aberto que implementa o protocolo AMQP, possibilitando lidar com o tráfego de mensagens de forma rápida e confiável.

- Spring Cloud Stream: Framework para construir microservicos de alta escalabilidade orientado à eventos que conecta com sistemas de mensageria

- MySQL: Sistema Gerenciador de Banco de Dados que utiliza a linguagem SQL.

- VueJS: Framework Javascript Progressivo de código de aberto focado no desenvolvimento de UI e SPA.

```

**Arquitetura do Sistema:**
```
Este projeto foi constituido com as tecnologias:
    - Spring Boot
    - Spring Data JPA
    - Rabbimq
    - Swagger
    - Vue Js
    - PHP Laravel
    - Docker
```

**Links da  API:**
```
Frontend: (http://localhost:8081)
Api: (http://localhost:8080/api/person/v1)
Healthcheck da Api: (http://localhost:8080/actuator/health)
Adm Rabbitmq: (http://localhost:15672)
Documentação: (http://localhost:8080/swagger-ui.html)
```

**Documentação:**
```
Utilizamos o Swagger para gerar a documentação, e está exposta em Documentação: (http://localhost:8080/swagger-ui.html)
```

**Build e Execução do Projeto Manual:**
```
Requisitos:
  - Maven instalado.
  - Docker instalado.
  - Docker Compose instalado.
  - Git

Para fazer build desse projeto:

Clonar  o repositório .
- git clone git@github.com:flavio-silva/java-user-api.git microservices
- cd microservices
- mvn clean install -f services/java-user-api/pom.xml
- docker-compose up
- docker exec -it consumer-php-app composer install
- docker exec -it consumer-php-app php artisan rabbitmq:consume

```

**Build e Execução do Projeto Automatizado:**
```
Requisitos:
  - Ambiente Linux.
  - Maven instalado.
  - Docker instalado.
  - Docker Compose instalado.
  - Git

Clonar  o repositório.
Executar o script run.sh com permissão de administrador, desta forma `sudo bash run.sh`
```

**Testando a aplicação:**
```
Requisitos:
  - Ambiente Linux.
  - Maven instalado.
  - Docker instalado.
  - Docker Compose instalado.
  - Git
  - Postman

Importar a coleção no Postman que está na pasta postman.
```

**Grupo:**
```
Flavio Alves Ferreira da Silva - RM:333565
```
```
Pedro Madi Della Coletta - RM:334109
```
```
Wellington Moreira Bastos - RM:333878
```
