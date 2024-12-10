package com.example.spring311.controllers;

import com.example.spring311.model.User;
import com.example.spring311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/user")
public class UsersController {

	private final UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUser());
		return "allUser";
	}

	@GetMapping("/new")
	public String createUserForm(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping
	public String createUser(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "redirect:/user";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("id") Long id) {
		model.addAttribute("user", userService.showUser(id));
		return "edit";

	}

	@PostMapping("/edit")
	public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
		userService.updateUser(id, user);
		return "redirect:/user";

	}

	@PostMapping("/delete")
	public String deleteUser(Model model, @RequestParam("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/user";
	}
}