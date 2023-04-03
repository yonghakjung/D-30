package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class serviceCenterController {
	private boolean flag=true;
	@GetMapping("/membershipadvertiseDetail")
	public String membershipadvertiseDetail(Model model) {
		model.addAttribute("activeNoticeBoard2", flag);
		return "content/servicecenter/membershipadvertiseDetail";
	}
	@GetMapping("membershipadvertiseWrite")
	public String membershipadvertiseWrite() {
		return "content/servicecenter/membershipadvertiseWrite";
	}
	@GetMapping("servicecenterDetail")
	public String servicecenterDetail() {
		return "content/servicecenter/servicecenterDetail";
		
	}
}
