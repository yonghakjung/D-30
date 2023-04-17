package org.hongsclub.rekosta.controller;

import org.hongsclub.rekosta.model.service.IntroService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
public class introController {
	private final IntroService introService;
	
	@PostMapping("/writePostIntro")
	public String writePostIntro(@RequestParam("id")String id, @RequestParam("category")String category, @RequestParam("title")String title, @RequestParam("content")StringBuilder content) {
		boolean result = introService.writePostIntro(id, category, title, content);
		String resultPath;
		if(result) {
			resultPath = "redirect:/moveWritePostSuccess";
		} else {
			resultPath = "redirect:/moveWritePostFail";
		}
		return resultPath;
	}

}	
