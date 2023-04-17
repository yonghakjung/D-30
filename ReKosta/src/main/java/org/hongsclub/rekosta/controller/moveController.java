package org.hongsclub.rekosta.controller;

import org.hongsclub.rekosta.entity.IntroEntity;
import org.hongsclub.rekosta.model.service.IntroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class moveController {
	private final IntroService introService;
	//private final IntroRepository introRepository;
	//private final IntroEntity introEntity;
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
		return "content/intro/introduceorganization";
	}
	@GetMapping("/moveIntroduceRegisterMembership")
	public String moveIntroduceRegisterMembership(Model model, @PageableDefault Pageable pageable) {
		Page<IntroEntity> introList=introService.introList(pageable);
		model.addAttribute("introList", introList);		
		return "content/intro/introduceregistermembership";
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
		return "content/testauthentication/test_authentication";
	}
	//sw역량진단&개발컨설팅
	@GetMapping("/moveSWAbilityTestAndConsulting")
	public String moveSWAbilityTestAndConsulting(Model model) {
		model.addAttribute("activeSWAbilityTestAndConsulting", flag);
		return "content/swabilitytestandconsulting/swabilitytestandconsulting";
	}
	@GetMapping("/moveSWAbilityTest")
	public String moveSWAbilityTest(Model model) {
		model.addAttribute("activeSWAbilityTestAndConsulting", flag);
		return "content/swabilitytestandconsulting/swabilitytest";
	}
	@GetMapping("/moveSSPL")
	public String moveSSPL(Model model) {
		model.addAttribute("activeSWAbilityTestAndConsulting",flag);
		return "content/swabilitytestandconsulting/sspl";
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
	//KOSTA 동정
	@GetMapping("/moveKostaSympathy")
	public String moveKostaSympathy(Model model) {
		model.addAttribute("activeKostaSympathy",flag);
		return "content/servicecenter/kosta_sympathy";
	}
	// 회원사/협약사 홍보마당
	@GetMapping("/moveMembershipAdvertise")
	public String moveMembershipAdvertise(Model model) {
		model.addAttribute("activeMembershipAdvertise",flag);
		return "content/servicecenter/membership_advertise";
	}
	//intro 회원사&협약사 글쓰기 폼
	@GetMapping("/moveWritePostCompany")
	public String moveWritePostCompany(Model model) {
		model.addAttribute("activeIntroduceAndRegister",flag);
		return "content/intro/postcompany_write";
	}
	@GetMapping("/moveWritePostSuccess")
	public String moveWritePostSuccess() {
		return "content/intro/writepost-success";
	}
	@GetMapping("/moveWritePostFail")
	public String moveWritePostFail() {
		return "content/intro/writepost-fail";
	}
	
	@GetMapping("/moveAdminForm")
	public String moveAdminForm(Model model) {
		model.addAttribute("activeAdminForm",flag);
		return "content/admin/admin_form";
	}
	
}
