package com.saurabh.example.restful.restfulwebservices.dto;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class User {

    private Integer userId;
    @Size(min=2,message = "Minimum two characters are required....")
    private String name;
    private Date birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }
}
