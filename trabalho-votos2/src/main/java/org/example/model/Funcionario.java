package org.example.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Objects;

/**
 * Classe que representa funcionários que utilizarão o sistema
 * Informações como nome e id.
 * Construtor vazio e construtor com os paramentros de nome e id
 */

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "funcionario_generator")
    @TableGenerator(name = "funcionario_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    /**
     * construtor vazio da classe Funcionário
     */

    public Funcionario() {
    }

    /**
     * Construtor da classe Funcionário
     *
     * @param id   , indica id do funcionário.
     * @param nome indica nome do funcionário
     */

    public Funcionario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * compara dois funcionários usando como @param o id de cada um
     *
     * @return se os dois objetos comparados são iguais ou não
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    /**
     * gera um número que representa um funcionário, número esse usado internamente para armazenar
     * e buscar objetos em estruturar como telas e e conjuntos. (Listas, mapas...)
     */

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     * metodo de organização de entrega do objeto.
     *
     * @return id + nome do Funcionário
     */
    public String toString() {
        return id + " - " + nome;
    }
}