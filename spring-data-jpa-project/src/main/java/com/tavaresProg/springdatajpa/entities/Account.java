package com.tavaresProg.springdatajpa.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "username",
                column = @Column(name = "account_username")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "account_email")
        ),
        @AttributeOverride(
                name = "password",
                column = @Column(name = "account_password")
        )
})
public class Account {
    private String username;
    private String email;
    private String password;

}
