package com.example.doanweb.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@Autowired
	HttpSession session;
	
	@RequestMapping("/security/login/form")
	public String loginForm( Model model) {
		System.out.println("loginForm");
		model.addAttribute("message","Vui lòng đăng nhập");
		return "login/login";
	}
	
	@RequestMapping("/security/login/success")
	public String vaitro(HttpServletRequest req, Principal principal,Model model) {
		System.out.println("success");
		String username = principal.getName();
		System.out.println("UserName: " + username);

		User loginUser = (User) ((Authentication) principal).getPrincipal();
		session.setAttribute("role",username);
		String a =(String) session.getAttribute("role") ;
		model.addAttribute("roleuser",a);
		System.out.println(loginUser);
		
//		return "redirect:/admin/templates/index.html";
		return "redirect:/";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		System.out.println("loginError");
		model.addAttribute("message","Sai thông tin đăng nhập!");
		return "login/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		System.out.println("unauthoried");
		model.addAttribute("message","Không có quyền truy cập!");
		return "login/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		System.out.println("logoffSuccess");
		model.addAttribute("message","Bạn đã đăng xuất!");
		return "login/login";
	}
//	@CrossOrigins("*")

	//login google

	
}
