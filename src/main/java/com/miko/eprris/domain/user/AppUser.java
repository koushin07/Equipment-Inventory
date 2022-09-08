package com.miko.eprris.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miko.eprris.domain.user.role.Role;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import static com.fasterxml.jackson.annotation.JsonProperty.Access.*;

@Entity @NoArgsConstructor @AllArgsConstructor
@Getter
@Setter

public class AppUser implements Serializable {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String username;
    @NotEmpty
    private String Email;
    @JsonProperty(access = WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();


    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", Email='" + Email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
