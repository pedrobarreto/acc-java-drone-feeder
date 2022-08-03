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
  cd acc-java-drone-feeder
  mvn install
```

---

## Conexão com o Banco

Para conectar o banco de dados é essencial criar um arquivo .env com os dados contidos no arquivo .env.example e alterar as variavéis de ambiente abaixo:

```javascript
DB_USER=user
DB_ROOT_PASSWORD=password
DB_LOCAL_PORT=localPort
DB_DOCKER_PORT=dockerPort
APP_LOCAL_PORT=localPort
APP_DOCKER_PORT=dockerPort
```

---

## Comandos para utilizar o Docker

Para criar e iniciar os contêineres:
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
