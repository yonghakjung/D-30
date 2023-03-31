package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/moveLoginForm")
    public String moveLoginForm() {
        return "login/loginForm";
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
}
