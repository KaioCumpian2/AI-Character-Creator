package com.example.charactercreator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class AiCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{NotBlank.aiCharacter.name}")
    @Size(min = 3, max = 40, message = "{Size.aiCharacter.name}")
    private String name;

    @NotNull(message = "{NotNull.aiCharacter.species}")
    @Enumerated(EnumType.STRING)
    private Species species;

    @NotNull(message = "{NotNull.aiCharacter.startingLevel}")
    @Min(value = 1, message = "{Min.aiCharacter.startingLevel}")
    @Max(value = 100, message = "{Max.aiCharacter.startingLevel}")
    private Integer startingLevel;

    @NotBlank(message = "{NotBlank.aiCharacter.specialAbility}")
    @Size(max = 60, message = "{Size.aiCharacter.specialAbility}")
    private String specialAbility;

    @Size(max = 280, message = "{Size.aiCharacter.bio}")
    @Column(length = 280)
    private String bio;

    @NotNull(message = "{NotNull.aiCharacter.creationDate}")
    @PastOrPresent(message = "{PastOrPresent.aiCharacter.creationDate}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate creationDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }
    public Integer getStartingLevel() { return startingLevel; }
    public void setStartingLevel(Integer startingLevel) { this.startingLevel = startingLevel; }
    public String getSpecialAbility() { return specialAbility; }
    public void setSpecialAbility(String specialAbility) { this.specialAbility = specialAbility; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }
}
