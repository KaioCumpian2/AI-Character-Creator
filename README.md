

# 🤖 AI Character Creator

Crie, explore e gerencie **personagens de IA** com esta aplicação web divertida feita com **Spring Boot**, **Thymeleaf** e **PostgreSQL**!  

---

## ✨ Funcionalidades

- 📝 Cadastro de personagens via formulário interativo  
- ⚠ Validação de dados com **Bean Validation**  
- 🌐 Internacionalização (i18n) em **Português**, **Inglês** e **Espanhol**  
- 📜 Listagem de personagens cadastrados  
- 💾 Persistência de dados no **PostgreSQL** via Docker  

---

## 🛠 Tecnologias

- **Java 17+**  
- **Spring Boot 3+**  
- **Thymeleaf**  
- **Spring Data JPA**  
- **Hibernate Validator**  
- **PostgreSQL**  
- **Docker**  
- **Maven**

---

## 🐳 Banco de Dados com Docker

1. Certifique-se que o **Docker Desktop** está rodando.  
2. Na pasta do projeto, rode:

bash
docker compose up -d
`

Ou, se quiser criar manualmente:

bash
docker run --name cc_postgres -e POSTGRES_USER=character_user -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=characterdb -p 5432:5432 -d postgres:15


3. Teste a conexão:

bash
docker exec -it cc_postgres psql -U character_user -d characterdb


---

## ⚙ Configuração do Spring Boot

No arquivo `src/main/resources/application.properties`:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/characterdb
spring.datasource.username=character_user
spring.datasource.password=secret
spring.datasource.hikari.maximum-pool-size=10

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

spring.messages.basename=messages,ValidationMessages
spring.messages.encoding=UTF-8


---

## 🚀 Executando a aplicação

No terminal, dentro da pasta do projeto:

bash
./mvnw spring-boot:run


ou, se tiver Maven instalado:

bash
mvn spring-boot:run


Acesse no navegador:

* Formulário de cadastro: [http://localhost:8080/characters/new](http://localhost:8080/characters/new)
* Listagem de personagens: [http://localhost:8080/characters](http://localhost:8080/characters)

💡 Para testar i18n, adicione `?lang=pt`, `?lang=en` ou `?lang=es` na URL.

---

## 🧩 Estrutura do Formulário

| Campo               | Regras                                             |
| ------------------- | -------------------------------------------------- |
| **Name**            | Obrigatório, 3 a 40 caracteres                     |
| **Species**         | Obrigatório, opções: HUMAN, CYBORG, ALIEN, ANDROID |
| **Starting Level**  | Obrigatório, inteiro entre 1 e 100                 |
| **Special Ability** | Obrigatório, até 60 caracteres                     |
| **Bio**             | Opcional, até 280 caracteres                       |
| **Creation Date**   | Obrigatório, não pode ser futura                   |

---

## 🌎 Mensagens de Validação e i18n

Arquivos localizados em `src/main/resources`:


messages.properties
messages_pt.properties
messages_es.properties
ValidationMessages.properties
ValidationMessages_pt.properties
ValidationMessages_es.properties


Permite exibir mensagens de erro no idioma do usuário.

---

## 🚀 Próximos Passos / Melhorias

* 💡 Adicionar **Flyway** para versionamento do banco
* 🧪 Criar testes de integração com Spring Boot Test
* 🔒 Implementar autenticação e autorização

---

Crafted by Kaio Cumpian



---
