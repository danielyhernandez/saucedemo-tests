# 🧪 Saucedemo - Testes Automatizados E2E

![Testes](https://github.com/danielyhernandez/saucedemo-tests/actions/workflows/testes.yml/badge.svg)

Projeto de automação de testes End-to-End para o site [Saucedemo](https://www.saucedemo.com/), desenvolvido com Selenium WebDriver e JUnit 5.

## 🛠️ Tecnologias utilizadas

- Java
- Selenium WebDriver 4.43.0
- JUnit 5
- Maven
- Git + GitHub
- GitHub Actions (CI/CD)


## 📋 Casos de teste

| Classe | Teste | Descrição |
| --- | --- | --- |
| `Testando` | `loginLogout` | Realiza login com usuário válido e logout |
| `Testando` | `loginComUsuarioInvalido` | Valida mensagem de erro com credenciais inválidas |
| `CarrinhoTest` | `adicionarProdutoAoCarrinho` | Adiciona produto e verifica o carrinho |
| `CarrinhoTest` | `removerProdutoDoCarrinho` | Remove produto e verifica carrinho vazio |
| `CheckoutTest` | `finalizarCompra` | Realiza fluxo completo de compra |

## 📁 Estrutura do projeto

```text
saucedemo-tests/
├── src/
│   └── test/
│       └── java/
│           └── com/saucedemo/
│               ├── core/
│               │   └── BaseTest.java
│               └── test/
│                   ├── Testando.java
│                   ├── CarrinhoTest.java
│                   └── CheckoutTest.java
├── Evidencias/
├── pom.xml
└── README.md
```

## ▶️ Como executar

1. Clone o repositório
git clone https://github.com/seu-usuario/saucedemo-tests.git

2. Importe o projeto no Eclipse como **Maven Project**

3. Execute os testes clicando com o botão direito no projeto:
Run As → JUnit Test

## 📸 Evidências

Os prints de cada etapa dos testes são salvos automaticamente na pasta `Evidencias/` após a execução.


## 👩‍💻 Autora


Daniely — profissional de QA com foco em automação de testes End-to-End utilizando Java, Selenium WebDriver e JUnit.
