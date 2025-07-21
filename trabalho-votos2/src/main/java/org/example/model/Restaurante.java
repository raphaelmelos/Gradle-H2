package org.example.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Objects;

/**
 * Classe que representa restaurantes cadastrados no sistema.
 * informações como nome e id
 * Construtor vazio e construtor com os paramentros de nome e id
 */

@Entity
@Table(name = "RESTAURANTE")
public class Restaurante {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "restaurante_generator")
    @TableGenerator(name = "restaurante_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    /**
     * Construtor da classe Restaurante
     *
     * @param id   , indica id do restaurante.
     * @param nome indica nome do restaurante.
     */


    public Restaurante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * construtor vazio da classe Restaurante
     */

    public Restaurante() {

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
     * compara dois Restaurantes usando como @param o id de cada um
     *
     * @return se os dois objetos comparados são iguais ou não
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    /**
     * gera um número que representa um restaurante, número esse usado internamente para armazenar
     * e buscar objetos em estruturar como telas e e conjuntos. (Listas, mapas...)
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    /**
     * metodo de organização de entrega do objeto.
     *
     * @return id + nome do restaurante
     */

    public String toString() {
        return id + " - " + nome;
    }
}
