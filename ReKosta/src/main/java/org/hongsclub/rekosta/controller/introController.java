package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class introController {
	@PostMapping("writePostIntro")
	public String writePostIntro() {
		return "redirect:introduceregistermembership";
	}
	@GetMapping("introduceregistermembership")
	public String introduceregistermembership() {
		return "content/intro/introduceregistermembership";
	}
}	
