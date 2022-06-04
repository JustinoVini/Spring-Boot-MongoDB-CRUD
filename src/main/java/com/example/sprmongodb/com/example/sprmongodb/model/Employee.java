package com.example.sprmongodb.com.example.sprmongodb.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Employee")
public class Employee {

    // Criação de uma constante que recebera a sequencia de usuarios.
    // Com a notação Transient que significa que o mesmo não será serializado ou não.
    @Transient
    private static final String SEQUENCE_NAME = "users_sequence";

    // Criação do atributo Id do tipo long
    /*
    Que receberá a anotação @Id
    utilizada para informar ao JPA qual campo/atributo
    de uma entidade estará relacionado à chave primária
    da respectiva tabela no banco de dados.
     */
    @Id
    private long id;

    /**
     * Criação de mais 2 atributos que receberão as anotações
     * notblank e size
     * size Se refere ao tamanho do campo ou propriedade.
     * Este deve corresponder aos limites especificados.
     * notblank
     * que faz uma verificação se o objeto é diferente de nulo.
     * e o indexed marca os campos no mongoDB
     */
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String firstName;
    private String lastName;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String emailId;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /*
    O método abaixo mandará todas as informações
    passada para o banco e as transformará em string.
     */
    @Override
    public String toString(){
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", emailId=" + emailId + "]";

    }
}
