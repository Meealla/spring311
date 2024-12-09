package com.example.spring311.controllers;

import com.example.spring311.model.User;
import com.example.spring311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {

	private final UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String show(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/user")
	public String index(@RequestParam("id") Long id, Model model) {
		User user = userService.getByIdUser(id);
		model.addAttribute("user", user);
		return "user";
	}

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/users";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Long id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@GetMapping("/update")
	public String edit(Model model, @RequestParam("id") Long id) {
		model.addAttribute("user", userService.getByIdUser(id));
		return "update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
		userService.update(id, user);
		return "redirect:/users";
	}
}