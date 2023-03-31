package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("/moveLoginForm")
    public String moveLoginForm() {
        return "login/loginform";
    }
	@GetMapping("/moveCompanyRegisterForm")
    public String moveCompanyRegisterForm() {
        return "login/companyregisterform";
    }
	@GetMapping("/moveIndividualRegisterForm")
    public String moveRegisterForm() {
        return "login/individualregisterform";
    }
	@GetMapping("/moveRegisterChoice")
    public String moveRegisterChoice() {
        return "login/registerchoice";
    }
	@PostMapping("/registerCompany")
    public String registerCompany(Model model) {
		model.addAttribute("result",true);
        return "login/registercompanyresult";
    }
	@PostMapping("/registerIndividual")
    public String registerIndividual(Model model) {
		model.addAttribute("result",true);
        return "login/registerindividualresult";
    }
}
