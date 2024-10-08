package com.kb.courses_enrollment_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courses extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @NotEmpty(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be empty")
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @NotEmpty(message = "Author name cannot be empty")
    @NotNull(message = "Author name cannot be empty")
    @Column(name = "author")
    private String author;

}