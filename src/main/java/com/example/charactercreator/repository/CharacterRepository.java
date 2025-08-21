package com.example.charactercreator.repository;

import com.example.charactercreator.model.AiCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<AiCharacter, Long> { }
