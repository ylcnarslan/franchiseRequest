package com.mebitech.ylcn.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mebitech.ylcn.model.Franchise;
import com.mebitech.ylcn.service.FranchiseService;
 
@Controller
@RequestMapping("/")
public class FranchiseController {
 
    @Autowired
    FranchiseService service;
     
    @Autowired
    MessageSource messageSource;
 
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String show(Model model,
    		@Valid Franchise franchise, BindingResult result
            ) {
 
    	if (result.hasErrors()) {
            return "franchiseRequest";
        }
        
        return "franchiseRequest";
    }
    
    @RequestMapping(value = { "/franchiseRequest" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Franchise franchise, BindingResult result,
            ModelMap model, final RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()) {
        	model.addAttribute("error", messageSource.getMessage("error", null, Locale.getDefault()));
            return "franchiseRequest";
        }
 
        service.saveEmployee(franchise);
        
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("success", null, Locale.getDefault()));
        return "redirect:/";
    }
 
}