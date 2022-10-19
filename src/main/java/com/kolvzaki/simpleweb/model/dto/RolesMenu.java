package com.kolvzaki.simpleweb.model.dto;

import com.kolvzaki.simpleweb.model.Role;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class RolesMenu {
    private Integer menuId;
    private List<Role> menuRoles;
}
