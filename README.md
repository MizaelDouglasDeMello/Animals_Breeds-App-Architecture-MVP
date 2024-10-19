# Cats Breeds App - MVP Architecture 🐾

Este projeto foi desenvolvido como parte dos meus estudos em arquiteturas Android, utilizando o padrão **MVP (Model-View-Presenter)**. O app consome a [TheCatAPI](https://api.thecatapi.com/v1/images/search?limit=100) para exibir uma lista de imagens de gatos.

## 📱 Visão Geral

O aplicativo permite visualizar uma lista de raças de gatos em um layout dinâmico. Para buscar as imagens, ele utiliza **Retrofit** e exibe os dados em uma **RecyclerView**. Este projeto tem o objetivo de reforçar o entendimento do padrão **MVP**, separando claramente as responsabilidades entre a camada de apresentação (UI) e a lógica de negócios.

## 🛠️ Tecnologias Utilizadas

- **Kotlin**: Linguagem utilizada para o desenvolvimento.
- **MVP (Model-View-Presenter)**: Arquitetura usada para organizar o código.
- **Retrofit**: Biblioteca para realizar chamadas HTTP.
- **RecyclerView**: Para exibir as imagens em um grid.
- **Picasso**: Para carregar e exibir as imagens da API.
- **TheCatAPI**: API utilizada para buscar imagens de raças de gatos.

## ⚙️ Funcionalidades

- **Listagem de Gatos**: O app exibe uma lista de imagens de gatos fornecidas pela TheCatAPI.
- **Scroll Dinâmico**: A lista de gatos é exibida em uma grade, permitindo o scroll para explorar diferentes raças.

## 📷 Capturas de Tela

![App Screenshot](https://github.com/user-attachments/assets/f2c2b5fe-d877-4238-ad18-f4328086acbf)

## 🔗 API

O app faz uso da [TheCatAPI](https://thecatapi.com/) para obter uma lista de 100 imagens de gatos:

```bash
https://api.thecatapi.com/v1/images/search?limit=100
