package org.example.model;

import java.util.Calendar;
import java.util.Objects;

public class Voto {
    private Integer id;
    private Calendar data;

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
