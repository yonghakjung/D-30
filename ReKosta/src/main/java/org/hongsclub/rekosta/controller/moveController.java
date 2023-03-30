package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class moveController {
	private boolean flag = true;
	//홈
	@GetMapping(value={"/home","/","/index"})
	public String moveHome() {
		return "content/index";
	}
	//협회소개
	@GetMapping("/moveIntroduceOrganization")
	public String moveIntroduceOrganization(Model model) {
		model.addAttribute("activeIntroduceAndRegister",flag);
		return "content/intro/introduceOrganization";
	}
	@GetMapping("/moveIntroduceRegisterMembership")
	public String moveRegisterMembership(Model model) {
		model.addAttribute("activeIntroduceAndRegister",flag);
		return "content/intro/introduceRegisterMembership";
	}
	//교육훈련
	@GetMapping("/moveEducationAndTraining")
	public String moveEmployed(Model model) {
		model.addAttribute("activeEducationAndTraining",flag);
		return "content/edu/educationandtraining";
	}
	//구인구직
	@GetMapping("/moveJobOfferAndSearch")
	public String moveJobOfferAndSearch(Model model) {
		model.addAttribute("activeJobOfferAndSearch",flag);
		return "content/jobofferandsearch/jobofferandsearch";
	}
	//시험인증
	@GetMapping("/moveTestAuthentication")
	public String moveTest(Model model) {
		model.addAttribute("activeTest",flag);
		return "content/testauthentication";
	}
	//sw역량진단&개발컨설팅
	@GetMapping("/moveSWAbilityTestAndConsulting")
	public String moveSWAbilityTestAndConsulting(Model model) {
		model.addAttribute("activeSWAbilityTestAndConsulting", flag);
		return "content/swabilitytestandconsulting";
	}
	@GetMapping("/moveSWAbilityTest")
	public String moveSWAbilityTest(Model model) {
		model.addAttribute("activeSWAbilityTestAndConsulting", flag);
		return "content/swabilitytest";
	}
	@GetMapping("/moveSSPL")
	public String moveSSPL(Model model) {
		model.addAttribute("activeSWAbilityTestAndConsulting",flag);
		return "content/sspl";
	}
	//디지털비즈니스지원센터
	@GetMapping("/moveDigitalBusiness")
	public String moveDigitalBusiness(Model model) {
		model.addAttribute("activeDigitalBusiness",flag);
		model.addAttribute("activeIntroduceDigitalBusiness",flag);
		return "content/digitalbusiness/digitalbusiness";
	}
	@GetMapping("/moveVideoLecture")
	public String moveVideoLecture(Model model) {
		model.addAttribute("activeDigitalBusiness",flag);
		model.addAttribute("activeVideoLecture",flag);
		return "content/digitalbusiness/videolecture";
	}
	//고객센터
	@GetMapping("/moveServiceCenter")
	public String moveServiceCenter(Model model) {
		model.addAttribute("activeServiceCenter",flag);
		return "content/servicecenter/servicecenter";
	}
	@GetMapping("/moveKostaSympathy")
	public String moveKostaSympathy(Model model) {
		model.addAttribute("activeNoticeBoard",flag);
		return "content/kostasympathy";
	}
	@GetMapping("/moveMembershipAdvertise")
	public String moveMembershipAdvertise(Model model) {
		model.addAttribute("activeNoticeBoard",flag);
		return "content/membershipadvertise";
	}
}
