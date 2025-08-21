package com.example.charactercreator.controller;

import com.example.charactercreator.model.AiCharacter;
import com.example.charactercreator.model.Species;
import com.example.charactercreator.repository.CharacterRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository repository;

    public CharacterController(CharacterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("characters", repository.findAll());
        return "characters";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("aiCharacter", new AiCharacter());
        model.addAttribute("speciesValues", Species.values());
        return "new-character";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("aiCharacter") AiCharacter aiCharacter,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("speciesValues", Species.values());
            return "new-character";
        }
        repository.save(aiCharacter);
        return "redirect:/characters";
    }
}
