package com.demo.controller;

import com.demo.model.User;
import com.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
  @Autowired
  private IUserService userService;

  @GetMapping("/user")
  public ModelAndView showForm(){
    ModelAndView modelAndView = new ModelAndView("/error");
    modelAndView.addObject("user", new User());
    return modelAndView;
  }

  @PostMapping("/validateUser")
  public ModelAndView checkValidator(@Validated User user, BindingResult bindingResult){
    if (bindingResult.hasFieldErrors()){
      return new ModelAndView("/error");
    }
    userService.save(user);
    return new ModelAndView("/result");
  }
}
