package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	@PostMapping("writeMembershipAdvertise")
	public String writeMembershipAdvertise() {
		return "redirect:resultMembershipAdvertise";
	}
	@GetMapping("resultMembershipAdvertise")
	public String resultMembershipAdvertise() {
		return "content/servicecenter/resultMembershipAdvertise";
	}
}
