package org.hongsclub.rekosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class serviceCenterController {
	@GetMapping("/membershipadvertiseDetail")
	public String membershipadvertiseDetail(Model model) {
		return "content/servicecenter/membershipadvertiseDetail";
	}
}
