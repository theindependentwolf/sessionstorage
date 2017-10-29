package com.aoblah.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoblah.hello.User;
import com.aoblah.hello.UserRepository;

@Controller 
@RequestMapping
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/add")
	public String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "redirect:/users";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	

    @RequestMapping("/users")
    public String listUsers(Model model) {
    	List<User> users = new ArrayList<User>();
    	userRepository.findAll().forEach(users::add);    	
    	model.addAttribute("users", users);
    	return "users";    	
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id) {    	
    	userRepository.delete(Integer.valueOf(id));
        return "redirect:/users";
    }
    
}