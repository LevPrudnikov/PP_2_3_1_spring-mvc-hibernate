package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String displayAllUser(Model model){
        model.addAttribute("users",userService.showUsers());
        return "users/index";
    }

    @GetMapping("/show")
    public String showUser(@RequestParam("id") int id, Model model){
        model.addAttribute("user",userService.showUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model){
        model.addAttribute("user",userService.showUser(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete (@RequestParam("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
