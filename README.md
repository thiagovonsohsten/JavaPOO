# Projeto: Sistema de Gerenciamento de Bilhetes de Viagem

Este projeto é uma aplicação Java que implementa um sistema completo de gerenciamento de bilhetes de viagem. Ele possui uma interface gráfica (GUI) desenvolvida em Java Swing para realizar a captura e exibição de informações, além de permitir a interação com bilhetes de voo normais e VIPs. O sistema é estruturado com boas práticas de programação orientada a objetos, utilizando padrões como **Mediator**, **DAO** e **Singleton**.

---

## 🛠️ Funcionalidades

### 🔹 Interface Gráfica (GUI)
- **Campos de Entrada**:
  - CPF (com máscara de formatação: `XXX.XXX.XXX-XX`);
  - Companhia aérea (ComboBox com as companhias cadastradas);
  - Número do voo (ComboBox com os números de voo cadastrados);
  - Preço do bilhete;
  - Pagamento em pontos;
  - Data e hora do voo (com máscara de formatação: `DD/MM/YYYY HH:MM`);
  - Tipo de bilhete (Radio Button: Normal ou VIP);
  - Bônus de pontuação (habilitado apenas se o tipo for VIP).
- **Botões**:
  - **Gerar Bilhete**: Gera o bilhete com base nas informações preenchidas;
  - **Limpar**: Redefine todos os campos para o estado inicial.

### 🔹 Funcionalidades Internas
- **Gerar Bilhete**:
  - Validação completa de dados, incluindo CPF e formato de data e hora;
  - Diferenciação entre bilhete normal e VIP;
  - Cálculo de pontos e validação de bônus para bilhetes VIP.
- **Persistência de Dados**:
  - Uso do padrão DAO para gerenciar dados de voos, clientes e bilhetes;
  - Dados salvos e recuperados com facilidade usando a estrutura de persistência do sistema.
- **Ordenação e Filtragem**:
  - Bilhetes ordenados por preço ou data/hora;
  - Filtros para bilhetes com base em preço mínimo.

---

## 📂 Estrutura do Projeto

```bash
src/
├── br.edu.cesarschool.cc.poo.ac.cliente
│   ├── Cliente.java
│   ├── ClienteDAO.java
│   ├── ClienteMediator.java
├── br.edu.cesarschool.cc.poo.ac.passagem
│   ├── Bilhete.java
│   ├── BilheteDAO.java
│   ├── BilheteVip.java
│   ├── BilheteVipDAO.java
│   ├── Voo.java
│   ├── VooDAO.java
│   ├── VooMediator.java
├── br.edu.cesarschool.cc.poo.ac.passagem.gui
│   ├── TelaGuiBilhete.java
├── br.edu.cesarschool.cc.poo.ac.utils
│   ├── DAOGenerico.java
│   ├── Registro.java
│   ├── SuperDAO.java
│   ├── ValidadorCPF.java
├── br.edu.cesarschool.cc.poo.ac.testes
│   ├── TestesAc07.java
│   ├── ComparadoraObjetosSerial.java
└── README.md
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java Development Kit (JDK)** versão 11 ou superior;
- **IDE de sua preferência** (recomenda-se IntelliJ IDEA, Eclipse ou VS Code);
- **Maven** ou **Gradle** configurado (opcional).

### Passo a Passo

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio
   ```

2. **Importe o projeto na IDE**:
   - Utilize a opção de importar um projeto existente na sua IDE preferida.

3. **Compile o projeto**:
   - Certifique-se de que todas as dependências e bibliotecas padrão do Java estão configuradas.

4. **Execute a aplicação**:
   - Navegue até a classe `TelaGuiBilhete` e execute o método `main`.

---

## 🧪 Testes

O projeto inclui um conjunto completo de testes unitários para validar a lógica de negócios e persistência. Para executar os testes:

1. **Abra sua IDE**:
   - Certifique-se de que a biblioteca JUnit está configurada.

2. **Execute os testes**:
   - Os testes estão localizados no pacote `br.edu.cesarschool.cc.poo.ac.testes`.

---

## 📊 Estrutura de Dados e Persistência

- **DAO Generics**:
  - Implementação genérica para lidar com qualquer entidade persistível.
- **Arquivos como Persistência**:
  - Os dados são salvos em arquivos locais para simular uma base de dados.

---

## 🛡️ Validações e Erros

- **Validação de CPF**:
  - Utiliza uma lógica robusta para verificar se o CPF é válido.
- **Erros de Data e Hora**:
  - Verifica se o formato está correto e lança mensagens claras para o usuário.
- **Mensagens de Erro**:
  - Mensagens detalhadas são exibidas em caixas de diálogo para facilitar a identificação do problema.

---

## 🖼️ Demonstração da Interface

### Tela Inicial
![Tela Inicial](https://via.placeholder.com/500x300?text=Tela+Inicial+do+Sistema)

### Bilhete Gerado com Sucesso
![Bilhete Gerado](https://via.placeholder.com/500x300?text=Bilhete+Gerado+com+Sucesso)

---

## 📜 Licença

Este projeto está licenciado sob a licença **MIT**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🤝 Contribuições

Contribuições são sempre bem-vindas! Para contribuir:

1. **Fork este repositório**;
2. **Crie um branch** para sua feature (`git checkout -b minha-feature`);
3. **Commit suas mudanças** (`git commit -m 'Adiciona minha feature'`);
4. **Push no branch criado** (`git push origin minha-feature`);
5. **Abra um Pull Request**.

---

## ✍️ Autor

Desenvolvido por **[Thiago von Sohsten](https://github.com/thiagovonsohsten)**. 

Conecte-se comigo:
- [LinkedIn](https://www.linkedin.com/in/thiago-von-sohsten-722060242/)
- [E-mail](thiagolvs10@gmail.com)

