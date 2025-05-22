<div align="center">
  
  ![Badge](https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-yellow?style=for-the-badge)

</div>

<h1 align="center">
  🏋️ Sistema de Gestão para Academia 
</h1>

## 📌 Sobre o Projeto

Este é um sistema full-stack desenvolvido para atender academias, focando tanto na **administração operacional** quanto na **experiência do aluno**. A proposta é fornecer uma plataforma moderna, intuitiva e eficiente para gerenciar todos os aspectos do dia a dia da academia, incluindo funcionários, planos, equipamentos, treinos e pagamentos.

---

## 🎯 Objetivo

Desenvolver uma plataforma centralizada que:

- Automatize os processos administrativos da academia.
- Ofereça dashboards personalizados para diferentes perfis de usuário.
- Melhore a comunicação e interação entre administradores, instrutores e alunos.
- Otimize a experiência do aluno com treinos personalizados, acompanhamento de progresso e gestão de pagamentos.

---

## 🧱 Tecnologias Utilizadas

| Camada      | Tecnologias         |
|-------------|---------------------|
| **Backend** | Java, Spring Boot   |
| **Banco**   | PostgreSQL          |
| **Frontend**| Vue.js, Quasar      |

---

## 🚀 Funcionalidades Principais

### 🔐 [Login](https://www.notion.so/Login-1fae61bedfc6805c9d1ff964c1ff7db8?pvs=21)

- Acesso por e-mail e senha.
- Redirecionamento conforme perfil de usuário: **Admin**, **Instrutor** ou **Aluno**.
- Permissões específicas por tipo de usuário.

---

### 👨‍💼 [Painel do Admin](https://www.notion.so/Painel-do-Admin-1fae61bedfc68023b549c714d2259790?pvs=21)

- Cadastro e gestão de funcionários.
- Criação e gerenciamento de planos e contratos.
- Controle de equipamentos e manutenções.
- Visualização de relatórios financeiros.
- Organização da agenda de aulas coletivas.
- Envio de notificações aos alunos.

---

### 🧑‍🏫 [Painel do Instrutor](https://www.notion.so/Painel-do-Instrutor-1fae61bedfc680abb8f6c05d98a271c0?pvs=21)

- Visualização da lista de alunos sob sua responsabilidade.
- Criação de treinos personalizados.
- Registro de avaliações físicas.
- Acesso à sua agenda de aulas.
- Comunicação direta com alunos.

---

### 🧍‍♂️ [Painel do Aluno](https://www.notion.so/Painel-do-Aluno-1fae61bedfc680ae92a4e22da967308c?pvs=21)

- Treino do dia com vídeos explicativos.
- Acompanhamento de metas e progresso.
- Histórico de treinos e avaliações.
- Pagamentos e notificações.
- Dicas e conquistas gamificadas.

---

## 📐 [Arquitetura do Sistema](https://www.notion.so/Arquitetura-do-Sistema-1fbe61bedfc68016bc66eed72a32cbc3?pvs=21)

A arquitetura segue o padrão MVC, com camadas bem definidas entre frontend, backend e banco de dados. A comunicação entre as camadas é feita via API REST, utilizando autenticação baseada em token (JWT).

---

## 📋 Detalhamento das Funcionalidades

### Admin

- 📊 **Dashboard** com visão geral da academia.
- 👨‍🔧 **Gestão de Funcionários** por setor e função.
- 📄 **Planos e Contratos** com validade e histórico.
- 🛠️ **Equipamentos** com alertas de manutenção.
- 📈 **Relatórios Financeiros** com exportação.
- 📆 **Agenda de Aulas** coletivas.
- 🔔 **Notificações** manuais ou automáticas.

### Instrutor

- 🔗 Lista de alunos vinculados.
- 🏋️‍♂️ Criação de treinos personalizados.
- 📊 Avaliações físicas periódicas.
- 📆 Agenda pessoal e de aulas.
- 💬 Canal de comunicação com os alunos.

### Aluno

- 📅 Visualização do treino do dia.
- 🎥 Vídeos explicativos dos exercícios.
- 🎯 Metas e acompanhamento de progresso.
- 📖 Histórico completo de treinos.
- 💰 Status de pagamentos.
- 🏆 Dicas e sistema de conquistas.

---

## 🧪 Como Executar o Projeto

### Pré-requisitos

- Node.js 18+
- Java 17+
- PostgreSQL
- Maven
- Quasar CLI

### Passos

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/sistema-academia.git
cd sistema-academia

# Backend
cd backend
./mvnw spring-boot:run

# Frontend
cd frontend
npm install
quasar dev
