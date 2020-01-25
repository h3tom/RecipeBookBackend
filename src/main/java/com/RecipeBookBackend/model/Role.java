package com.RecipeBookBackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private RoleName name;
}
