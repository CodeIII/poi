package com.lk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

		@RequestMapping("/")
		public String showPage(){
			return "index";
		}
		@RequestMapping("/page_common_index.action")
		public String showIndex(){
			return "login"; 
		}
	
}
