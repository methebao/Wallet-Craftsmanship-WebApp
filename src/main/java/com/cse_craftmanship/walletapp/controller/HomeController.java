package com.cse_craftmanship.walletapp.controller;

import org.springframework.boot.SpringApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableJpaAuditing
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView renderHome(String[] args) {
    SpringApplication.run(HomeController.class, args);

    ModelAndView model = new ModelAndView("index");

    return model;
  }

}
