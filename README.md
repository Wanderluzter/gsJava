
# Weatherman

## 📲 **Resumo da Ideia**

Um aplicativo mobile inteligente que utiliza **geolocalização** para mapear regiões afetadas por eventos climáticos extremos, prever condições futuras, indicar locais seguros, permitir comunicação e colaboração entre usuários, e utilizar **Inteligência Artificial** para prever riscos e oferecer suporte contextual.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security com JWT**
- **Oracle Database**
- **Swagger/OpenAPI**
- **Maven**

---

## 📁 Estrutura do Projeto

```
src/
├── controller       # Endpoints REST
├── dto              # Objetos de Transferência de Dados
├── model            # Entidades JPA
├── repository       # Interfaces para banco de dados
├── service          # Lógica de negócios
├── config           # Configurações como JWT e CORS
└── ...              # Outros arquivos do projeto
```

---

## 🧪 Como Rodar Localmente

### 🔧 Pré-requisitos

- Java 17 instalado
- Maven instalado
- Oracle Database acessível (ex: `oracle.fiap.com.br:1521/orcl`)
- IDE (VSCode, IntelliJ, etc.)

### 🚦 Passos:

```bash
# Clone o projeto
git clone https://github.com/wanderluzter/gsJava.git
cd gsJava

# Edite o arquivo application.properties com as credenciais corretas do Oracle DB
# Exemplo:
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=rmXXXXXX
spring.datasource.password=suasenha

# Rode a aplicação
./mvnw spring-boot:run
```

---

## 🔐 Autenticação

Este projeto utiliza **JWT** para autenticação.

### 📌 Login

```
POST /auth/login
{
  "username": "rmXXXXXX",
  "password": "******"
}
```

### 🔐 Como usar o token

Após o login, inclua o token JWT no header `Authorization` em todas as requisições protegidas:

```
Authorization: Bearer seu.token.jwt
```

---

## 🧭 Endpoints Principais

### 👤 Usuários
- `GET /usuarios`
- `POST /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### 📍 Localizações
- `GET /localizacoes`
- `POST /localizacoes`

### 🚨 Alertas
- `GET /alertas`
- `POST /alertas`

### 📷 Mídias de Alertas
- `POST /midias-alerta`

### 🌤️ Previsões Climáticas
- `GET /previsoes`
- `POST /previsoes`

---

## 🔗 Deploy

- API Swagger: [https://api.geoguardian.com/swagger-ui.html](https://api.geoguardian.com/swagger-ui.html)
- App Mobile: Em desenvolvimento...

---

## 👥 Equipe

- Leonardo José – RM556110
- Raul Clauson – RM555006
- Mirian Bronzati – RM555041

---
