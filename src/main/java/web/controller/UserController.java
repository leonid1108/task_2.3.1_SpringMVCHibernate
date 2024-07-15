package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

@Controller
public class UserController {
	// --------Dependency Injection--------
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	// ------------------------------------

	// Отображение таблицы User'ов
	@GetMapping
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "show";
	}

	// GET метод для создания пользователя
	@GetMapping("/user/create")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "create";
	}

	// POST метод для создания пользователя
	@PostMapping("/user/create")
	public String createUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	// GET метод для удаления пользователя
	@GetMapping("/user/delete")
	public String deleteUser(@RequestParam("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "delete";
	}

	// POST метод для удаления пользователя
	@PostMapping("/user/delete")
	public String deleteUser(@RequestParam("id") Long id) {
		User user = userService.findById(id);
		if (user != null) {
			userService.delete(user);
		}
		return "redirect:/";
	}

	// GET метод для редактирования пользователя
	@GetMapping("/user/edit")
	public String editUser(@RequestParam("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "edit";
	}

	// POST метод для редактирования пользователя
	@PostMapping("/user/edit")
	public String editUser(@ModelAttribute("user") User user) {
		if (user != null && user.getId() != null) {
			userService.editUserById(user.getId(), user.getName(), user.getSurname(), user.getAge(), user.getHeight());
		}
		return "redirect:/";
	}
}
