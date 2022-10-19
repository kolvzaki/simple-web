package com.kolvzaki.simpleweb.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pid;

    private String path;

    private String name;

    private String icon;

    private Boolean hidden;

    private Date createdTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Menu menu = (Menu) o;
        return id != null && Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Menu(Integer id) {
        this.id = id;
    }
}
