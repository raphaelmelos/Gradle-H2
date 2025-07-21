package org.example.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

/**
 * Classe que representa restaurantes cadastrados no sistema.
 * informações como nome e id
 * Construtor vazio e construtor com os paramentros de nome e id
 */

@Entity
@Table(name = "VOTO")
public class Voto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "voto_generator")
    @TableGenerator(name = "voto_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)
    private Integer id;

    @Column(name = "data")
    private Calendar data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;

    public Voto() {
    }

    public Voto(Integer id, Restaurante restaurante, Funcionario funcionario, Calendar data) {
        this.id = id;
        this.restaurante = restaurante;
        this.funcionario = funcionario;
        this.data = data;
    }

    public Voto(Calendar data, Integer id) {
        this.data = data;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(id, voto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
