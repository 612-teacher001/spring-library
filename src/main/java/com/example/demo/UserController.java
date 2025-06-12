package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/user/signup")
	public String signup(
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String address,
			@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String password,
			Model model) {
		
		// リクエストパラメータから利用者クラスをインスタンス化しデータ置き場に放置
		User user = new User(name, address, email, phone, password);
		model.addAttribute("user", user);
		
		// 入力値チェック
		List<String> errors = service.validate(user);
		
		// エラーの有無による遷移先の分岐
		String nextPage = "";
		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			nextPage = "user/signup";
		} else {
			nextPage = "redirect:/";
		}
		
		// 画面遷移
		return nextPage;
	}
	
}
