package com.uthmanIV.e_commerce.user.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;
}
