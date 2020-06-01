package com.example.app.todoapp.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@JsonIgnoreProperties(value = {"createdAt"},allowGetters = true)
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "todo")
public class Todo {
    @Id
    String id;

    @Size(max=200)
    @NotBlank
    String title;

    Boolean completed;

    Date createdAt = new Date(System.currentTimeMillis());

}
