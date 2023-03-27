package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class moveController {
	private boolean flag = true;
	
	@GetMapping(value={"/home","/","/index"})
	public String moveHome(Model model) {
		model.addAttribute("activeHome",flag);
		return "content/index";
	}
	@GetMapping("/styleDemo")
	public String moveStyleDemo(Model model) {
		model.addAttribute("activeStyleDemo",flag);
		return "content/style-demo";
	}
	@GetMapping("/fullWidth")
	public String moveFullWidth(Model model) {
		model.addAttribute("activeFullWidth", flag);
		return "content/full-width";
	}
	@GetMapping("/3columns")
	public String move3Columns(Model model) {
		model.addAttribute("active3Columns",flag);
		return "content/3-columns";
	}
	@GetMapping("/gallery")
	public String moveGallery(Model model) {
		model.addAttribute("activeGallery",flag);
		return "content/gallery";
	}
}
