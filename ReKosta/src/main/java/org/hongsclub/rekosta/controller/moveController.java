package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class moveController {
	@GetMapping(value={"/home","/","/index"})
	public String moveHome() {
		return "content/index";
	}
	@GetMapping("/styleDemo")
	public String moveStyleDemo() {
		return "content/style-demo";
	}
	@GetMapping("/fullWidth")
	public String moveFullWidth() {
		return "content/full-Width";
	}
	@GetMapping("/3columns")
	public String move3Columns() {
		return "content/3-columns";
	}
	@GetMapping("/gallery")
	public String moveGallery() {
		return "content/gallery";
	}
}
