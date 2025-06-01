# 🔥 FireMonitor API

API RESTful desenvolvida em **Java com Spring Boot** para monitoramento de focos de incêndio e coordenação de respostas ambientais. O sistema é baseado em sensores distribuídos geograficamente, capazes de gerar alertas e permitir a atuação de entidades de resposta a desastres naturais.

## 📌 Visão Geral

O **FireMonitor** tem como objetivo oferecer uma infraestrutura digital para:

- Monitoramento contínuo por sensores
- Geração automatizada de alertas com base em leituras
- Registro e visualização de focos de incêndio
- Coordenação de entidades de resposta
- Acompanhamento das ações tomadas

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL (ou H2 para testes)
- Swagger / Springdoc OpenAPI
- Maven
- JPA / Hibernate

## 🗂️ Estrutura do Banco de Dados

O modelo relacional foi projetado com base nas seguintes entidades principais:

- **Sensor**: Representa um sensor ambiental fixado em uma localização.
- **LeituraSensor**: Armazena as leituras periódicas realizadas pelos sensores.
- **Alerta**: Indica a detecção de um risco de incêndio, vinculado a um sensor e/ou foco.
- **FocoIncendio**: Representa um foco de incêndio ativo ou histórico.
- **Localizacao**: Detalha os pontos geográficos onde sensores e focos estão posicionados.
- **EntidadeResposta**: Órgãos responsáveis pela resposta ao incêndio (ex: bombeiros, defesa civil).
- **RespostaIncendio**: Registra a ação de uma entidade em resposta a um foco.

> 💡 O relacionamento entre as tabelas está representado no [modelo lógico do banco de dados](#diagrama).

## 🔄 Funcionalidades Implementadas (CRUD)

A API permite criar, listar, buscar, atualizar e deletar registros para:

- Sensores
- Leituras de sensores
- Alertas
- Focos de incêndio
- Localizações
- Entidades de resposta
- Respostas a incêndios

## 📂 Endpoints

A documentação da API está disponível via Swagger em:

http://localhost:3000/swagger-ui.html

Ou baixe o arquivo do Insomnia disponibilizado: insomnia.yaml


