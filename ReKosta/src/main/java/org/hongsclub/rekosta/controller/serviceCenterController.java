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
	// 알림마당 글쓰기
	@GetMapping("moveWriteServiceCenter")
	public String moveWriteServiceCenter(Model model) {
		model.addAttribute("activeNoticeBoard",flag);
		return "content/servicecenter/writeservicecenter";
	}
	@GetMapping("servicecenterDetail")
	public String servicecenterDetail() {  
		return "content/servicecenter/servicecenterDetail";
	}
	// kosta 동정 글쓰기
	@GetMapping("moveWriteKostaSympathy")
	public String moveWriteKostaSympathy(Model model) {
		model.addAttribute("activeKostaSympathy",flag);
		return "content/servicecenter/kostasympathywrite";
	}
	@GetMapping("kostasympathyDetail")
	public String kostasympathyDetail() {
		return "content/servicecenter/kostasympathyDetail";
	}
	@GetMapping("kostasympathyWrite")
	public String kostasympathyWrite() {
		return "content/servicecenter/kostasympathyWrite";
	}
	@PostMapping("WriteServiceCenter")
	public String WriteServiceCenter() {
		return "redirect:resultservicecenter";
	}
	@PostMapping("WriteKostaSympathy")
	public String writekostasympathy() {
		return "redirect:resultkostasympathy";
	}

}
