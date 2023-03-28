package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class digitalbusinessController {
	@GetMapping("/moveVideoLectureDetail")
	public String moveVideoLectureDetail(Model model) {
		model.addAttribute("activeVideoLecture",true);
		return "content/digitalbusiness/videolecturedetail";
	}
}
