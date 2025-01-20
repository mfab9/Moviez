package dev.javaproject.movies.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

@Document(collection = "users")
public class User {

    
    @Id
    private String id;
    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.username;
    }
    
}

