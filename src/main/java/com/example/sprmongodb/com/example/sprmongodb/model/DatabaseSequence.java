package com.example.sprmongodb.com.example.sprmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// A annotation abaixo cria uma coleção para o database.
@Document(collection = "database_sequences")
public class DatabaseSequence {

    // Criação dos atributos com o import da annotation Id de: [...]annotation.Id;
    @Id
    private String id;
    private long seq;


    // Construtor sem injeção de dependencia.
    public DatabaseSequence(){

    }

    // Métodos acessores
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
