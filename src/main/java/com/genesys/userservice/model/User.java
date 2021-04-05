package com.genesys.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    @NotBlank
    @Size(max = 50)
    @JsonIgnore
    private String password;
    @CreatedDate
    private Instant created;
    @LastModifiedDate
    private Instant updated;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    private boolean isActive;
    private String firstName;
    private String lastName;

}
