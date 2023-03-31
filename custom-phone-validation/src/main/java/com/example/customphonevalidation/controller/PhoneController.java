package com.example.customphonevalidation.controller;

import com.example.customphonevalidation.model.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public ModelAndView showFrom() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid @ModelAttribute Phone phone, BindingResult binding) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("phone", phone);
        new Phone().validate(phone, binding);
        if (binding.hasFieldErrors()) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/result");
    }
}
