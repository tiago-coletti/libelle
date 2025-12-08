# Libelle - Plataforma de Preservação do Hunsriqueano

O **Libelle** é uma solução de software open-source dedicada à documentação, preservação e ensino do dialeto **Hunsriqueano (Hunsrik)**.

O projeto nasce da necessidade de digitalizar e organizar o vocabulário deste dialeto falado no sul do Brasil, oferecendo uma estrutura robusta para lidar com um dos maiores desafios linguísticos da região: a existência de múltiplos sistemas de escrita (ortografias) para as mesmas palavras.

## Objetivo

Criar um "cofre digital" colaborativo onde a comunidade possa sugerir verbetes, enviar áudios de pronúncia e consultar traduções, tudo sob um fluxo de moderação garantido por especialistas (Managers/Admins).

## Funcionalidades Principais

* **Dicionário Multilíngue:** Consulta rápida de termos Hunsrik <-> Português.
* **Múltiplas Ortografias:** Suporte nativo para diferentes sistemas de escrita (ex: Clássica, SAP, CW) para o mesmo verbete, permitindo que falantes de diferentes regiões encontrem a palavra independentemente de como aprenderam a escrever.
* **Banco de Áudios:** Associação de gravações de pronúncia aos verbetes, enviadas pelos usuários.
* **Contexto e Exemplos:** Cadastro de frases de exemplo com tradução e notas linguísticas (gênero, classe gramatical).
* **Sistema de Contribuição:** Usuários podem sugerir novas palavras, traduções ou correções.
* **Fluxo de Moderação:** Sistema de "Auditoria" (Logs) onde moderadores aprovam, editam ou rejeitam contribuições e mídias enviadas pela comunidade.
* **Gestão de Localidades:** Mapeamento da origem dos falantes/verbetes.

## Tecnologias Utilizadas

O projeto foi construído seguindo as melhores práticas de desenvolvimento corporativo moderno:

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 3.5
* **Banco de Dados:** MySQL 8
* **Migração de Dados:** Flyway (Versionamento de Schema)
* **Segurança:** Spring Security (Autenticação e Autorização baseada em Roles: USER, MANAGER, ADMIN)
* **Persistência:** Spring Data JPA / Hibernate
* **Frontend:** Thymeleaf (Server-side rendering)
* **Ferramentas:** Maven, IntelliJ IDEA

## Como Executar

### Pré-requisitos
* Java 21 SDK instalado.
* MySQL rodando na porta 3306.

### Passos
1.  Clone o repositório:
    ```bash
    git clone (https://github.com/seu-usuario/libelle.git)
    ```
2.  Configure o banco de dados no arquivo `src/main/resources/application.properties` (se necessário).
3.  Execute a aplicação. O **Flyway** criará as tabelas automaticamente na inicialização.
4.  Acesse `http://localhost:8080`.

## Licença

Este projeto está sob a licença [MIT](./LICENSE).