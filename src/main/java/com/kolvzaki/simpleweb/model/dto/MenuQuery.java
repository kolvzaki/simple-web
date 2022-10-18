package com.kolvzaki.simpleweb.model.dto;

import com.kolvzaki.simpleweb.model.Role;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MenuQuery {

    private String menuName;

    private List<Integer> roles;
}
