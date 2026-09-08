# MagicStoreIA

API REST para gerenciamento de itens de estoque de alimentos (*food items*),
construída com **Spring Boot 4** e **Java 17**. O projeto usa **Spring Data JPA**
para persistência, **Flyway** para versionamento de banco e integra o
**Spring AI (Anthropic)** como base para recursos de inteligência artificial.

## Tecnologias

- Java 17
- Spring Boot 4.1.1
- Spring Web (MVC) e WebFlux
- Spring Data JPA
- Flyway
- H2 Database (console habilitado)
- Spring AI — modelo Anthropic
- Lombok
- Maven (com wrapper)

## Como executar

Pré-requisitos: **JDK 17+**. O Maven já vem embutido via wrapper.

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## Endpoints

Base: `/food`

| Método   | Rota            | Descrição                       | Corpo          |
|----------|-----------------|---------------------------------|----------------|
| `GET`    | `/food/listar`  | Lista todos os itens            | —              |
| `POST`   | `/food/criar`   | Cria um novo item               | `FoodItem`     |
| `PUT`    | `/food/{id}`    | Atualiza um item pelo `id`      | `FoodItem`     |
| `DELETE` | `/food/deletar` | Remove um item pelo `id`        | —              |

### Exemplo de payload (`FoodItem`)

```json
{
  "nome": "Peito de frango",
  "quantidade": 3,
  "validade": "2026-10-15T00:00:00",
  "categoria": "CARNE",
  "unidadeMedia": "KG",
  "armazenamento": "CONGELADO"
}
```

## Modelo de dados

Entidade **`FoodItem`**:

| Campo           | Tipo            | Descrição                         |
|-----------------|-----------------|-----------------------------------|
| `id`            | `Long`          | Identificador (gerado)            |
| `nome`          | `String`        | Nome do item                      |
| `quantidade`    | `Integer`       | Quantidade em estoque             |
| `validade`      | `LocalDateTime` | Data de validade                  |
| `categoria`     | `Categoria`     | Categoria do alimento             |
| `unidadeMedia`  | `UnidadeMedia`  | Unidade de medida                 |
| `armazenamento` | `Armazenamento` | Forma de armazenamento            |

### Enums

- **Categoria:** `CARNE`, `LEGUMES`, `VEGETAIS`, `LATICINIOS`, `FRUTAS`, `GRAOS`, `BEBIDAS`, `OUTROS`
- **UnidadeMedia:** `KG`, `GRAMA`, `LITRO`, `ML`, `UNIDADE`, `PACOTE`, `CAIXA`
- **Armazenamento:** `CONGELADO`, `REFRIGERADO`, `TEMPERATURA_AMBIENTE`

## Estrutura do projeto

```
src/main/java/dev/java10x/MagicStoreIA/
├── MagicStoreIaApplication.java   # entry point
├── controller/                    # camada REST
├── service/                       # regras de negócio
├── repository/                    # acesso a dados (JPA)
└── model/                         # entidades e enums
```

## Testes

```bash
./mvnw test
```
