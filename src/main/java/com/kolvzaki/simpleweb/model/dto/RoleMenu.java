package com.kolvzaki.simpleweb.model.dto;

import com.kolvzaki.simpleweb.model.Menu;
import com.kolvzaki.simpleweb.model.Role;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class RoleMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu roleMenu = (RoleMenu) o;
        return id.equals(roleMenu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
