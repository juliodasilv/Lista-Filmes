# Lista-Filmes


## Exemplo de insert de Documento na base do 

Collection...: *filmes*

``` 
db.filmes.insert({  
   "nome":"O clube da luta",
   "nomeOriginal":"Fight club",
   "sinopse":"Um homem deprimido que sofre de insônia conhece um estranho vendedor chamado Tyler Durden e se vê morando em uma casa suja depois que seu perfeito apartamento é destruído. A dupla forma um clube com regras rígidas onde homens lutam. A parceria perfeita é comprometida quando uma mulher, Marla, atrai a atenção de Tyler.",
   "nomtaImdb":8.8,
   "atores":[  
      "Edward Norton",
      "Brad Pitt",
      "Meat Loaf"
   ]
})
```

## Resumo das tecnologias utilizadas

* [MongoDB](https://www.mongodb.com/) - MongoDB é um software de banco de dados orientado a documentos livre, de código aberto e multiplataforma, escrito na linguagem C++. Classificado como um programa de banco de dados NoSQL, o MongoDB usa documentos semelhantes a JSON com esquemas.
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework Web usado
* [Spring Data](https://spring.io/projects/spring-data) - Framework para auxiliar na persistencia dos dados
* [Maven](https://maven.apache.org/) - Gerenciador de dependencias

## Autor

* **Julio Oliveira da Silva** - [juliodasilv](https://github.com/juliodasilv)