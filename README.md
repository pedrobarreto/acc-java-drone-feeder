# Boas vindas ao repositório do Drone Feeder!

---

## Descrição do projeto

Nesse projeto contruímos o back-end com Java utilizando Spring-boot que coleta informações de drones e adiciona no banco de dados MySQL.

Nele é possível coletar dados dos drones, das entregas realizadas pelos drones e o vídeo realizado durante essa entrega.

A relação entre as tabelas era de um drone para muitas entregas e uma entrega para um vídeo.

---

## Instalação do projeto localmente

Após cada um dos passos, haverá um exemplo do comando a ser digitado para fazer o que está sendo pedido.

1. Realize o clone do projeto no diretório de sua preferência:
```javascript
git clone git@github.com:pedrobarreto/acc-java-drone-feeder.git
```

2. Acesse o diretório do projeto e depois utilize o comando **mvn install** para instalar todas as dependências necessárias:
```javascript
  cd acc-java-drone-feeder/backend
  mvn install
```

---

## Conexão com o Banco

Para conectar o banco de dados é essencial criar um arquivo .env com os dados contidos no arquivo .env.example e alterar as variavéis de ambiente abaixo:

```javascript
DB_USER=user
DB_ROOT_PASSWORD=senha
DB_LOCAL_PORT=3306
DB_DOCKER_PORT=3306
APP_LOCAL_PORT=8080
APP_DOCKER_PORT=8080
```

---

## Comandos para utilizar o Docker

Para criar e iniciar os contêineres:
</br>
Obs.: Com o comando abaixo o docker fica rodando no terminal.
```javascript
docker-compose up
```

Para criar e iniciar os contêineres em stand-by:
```javascript
docker-compose up -d
```

Para realizar apenas a etapa de build das imagens que serão utilizadas:
```javascript
docker-compose build
```

Para paralisar e remover todos os contêineres e seus componentes como rede, imagem e volume:
```javascript
docker-compose down
```
---

## Utilizando o Spring-boot sem o Docker

Primeiramente, ative o MySQL:
```javascript
sudo service mysql start
```

Após altere o arquivo application.properties que está localizado no seguinte caminho acc-java-drone-feeder/backend/src/main/resources/application.properties. Nele você deve alterar a 2ª(username) e a 3ª(password) linha com o usuário e senha do seu MySQL:
```javascript
spring.datasource.username=username
spring.datasource.password=password
```

Rodar o Spring-Boot na pasta backend com o comando:
```javascript
mvn spring-boot:run
```

## Exemplos de uso da API em programas de requisições de HTTP (Ex.: Postman, Insomnia)
</br>

### Digite os comandos abaixo para adicionar um drone através da requisição POST
```javascript
http://localhost:8080/drones
```

body
```json
{
    "nome": "DF-4"
}
```
![CREATE_DRONE](/imagens/POST_drones.png)

### Digite o comando abaixo para visualizar todos os drones através da requisição GET
```javascript
http://localhost:8080/drones
```

![GET_DRONES](/imagens/GET_drones.png)

### Digite o comando abaixo para visualizar os dados de um drone pelo id através da requisição GET
```javascript
http://localhost:8080/drones/1
```

![GET_DRONE](/imagens/GET_drones-id.png)

### Digite os comandos abaixo para atualizar os dados de um drone através da requisição PATCH
```javascript
http://localhost:8080/drones/1
```

body
```json
{
    "status": "ativado",
    "latitude": -23.3348,
    "longitude": -46.8269
}
```
![PATCH_DRONE](/imagens/PATCH_drones-id.png)

### Digite os comandos abaixo para deletar os dados de um drone através da requisição DELETE
```javascript
http://localhost:8080/drones/4
```

![DELETE_DRONE](/imagens/DELETE_drone.png)

### Digite os comandos abaixo para adicionar uma entrega para um drone através da requisição POST
```javascript
http://localhost:8080/entregas
```

body
```json
{
    "droneId": 1
}
```

![CREATE_ENTREGA](/imagens/POST_entregas.png)

### Digite o comando abaixo para visualizar as entregas realizadas pelo drone através da requisição GET
```javascript
http://localhost:8080/drones/1/entregas
```

![GET_ENTREGA_DRONE](/imagens/GET_drones-id-entregas.png)

### Digite o comando abaixo para visualizar todas as entregas através da requisição GET
```javascript
http://localhost:8080/entregas
```

![GET_ENTREGAS](/imagens/GET_entregas.png)

### Digite o comando abaixo para visualizar os dados de uma entrega através da requisição GET
```javascript
http://localhost:8080/entregas/1
```

![GET_ENTREGA](/imagens/GET_entregas-id.png)

### Digite os comandos abaixo para atualizar os dados de uma entrega através da requisição PATCH
```javascript
http://localhost:8080/entregas/1
```

body
```json
{
    "data": "2022-08-03T19:00:48.917243Z",
    "status": "Em trânsito"
}
```

![PATCH_ENTREGA](/imagens/PATCH_entregas-id.png)

### Digite os comandos abaixo para deletar os dados de uma entrega através da requisição DELETE
```javascript
http://localhost:8080/entregas/3
```

![DELETE_ENTREGA](/imagens/DELETE_entregas-3.png)

### Digite os comandos abaixo para adicionar um vídeo da entrega para o banco de dados através da requisição POST
```javascript
http://localhost:8080/videos
```

body
```javascript
video: drone.mp4
entregaId: 2
```

![POST_VIDEO](/imagens/POST_videos.png)

### Digite o comando abaixo para visualizar todos os videos cadastrados no banco de dados através da requisição GET
```javascript
http://localhost:8080/videos
```

![GET_VIDEOS](/imagens/GET_videos.png)
