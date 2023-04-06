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
		model.addAttribute("activeMembershipadvertiseDetail", flag);
		return "content/servicecenter/membership_advertise_detail";
	}
	 @GetMapping("membershipadvertiseWrite") 
	 public String membershipadvertiseWrite() { 
	 return"content/servicecenter/membership_advertise_write"; 
	 }
	
	@PostMapping("writeMembershipAdvertise")
	public String writeMembershipAdvertise() {
		return "redirect:membership_advertise_result";
	}
	@GetMapping("resultMembershipAdvertise")
	public String resultMembershipAdvertise() {
		return "content/servicecenter/membership_advertise_result";
	}
	//------------------------------------------------------------------------------
	// 알림마당 글쓰기
	@GetMapping("moveWriteServiceCenter")
	public String moveWriteServiceCenter(Model model) {
		model.addAttribute("activeNoticeBoard",flag);
		return "content/servicecenter/servicecenter_write";
	}
	@GetMapping("serviceCenterDetail")
	public String servicecenterDetail() {  
		return "content/servicecenter/servicecenter_detail";
	}
	@PostMapping("writePostServiceCenter")
	public String WriteServiceCenter() {
		return "redirect:/resultServiceCenter";
	}
	@GetMapping("resultServiceCenter")
	public String resultServiceCenter() {
		return "content/servicecenter/servicecenter_result";
	}
	//---------------------------------------------------------------
	// kosta 동정 글쓰기 
	@GetMapping("moveWriteKostaSympathy")
	public String moveWriteKostaSympathy(Model model) {
		model.addAttribute("activeKostaSympathy",flag);
		return "content/servicecenter/kosta_sympathy_write";
	}
	@GetMapping("kostasympathyDetail")
	public String kostasympathyDetail() {
		return "content/servicecenter/kosta_sympathy_detail";
	}
	@PostMapping("writePostKostaSympathy")
	public String writekostasympathy() {
		return "redirect:/resultKostaSympathy";
	}
	@GetMapping("resultKostaSympathy")
		public String resultKostaSympathy() {
			return "content/servicecenter/kosta_sympathy_result";
	}
}
