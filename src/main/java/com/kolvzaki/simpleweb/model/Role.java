package com.kolvzaki.simpleweb.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Date createdTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
