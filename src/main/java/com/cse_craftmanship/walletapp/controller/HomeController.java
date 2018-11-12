package com.cse_craftmanship.walletapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping(value="/")
  public ModelAndView showViewHome() {
    ModelAndView modelAndView = new ModelAndView("home");
    return modelAndView;
  }

  @RequestMapping(value="/wallet")
  public ModelAndView showViewWallet() {
    ModelAndView modelAndView = new ModelAndView("wallet");
    return modelAndView;
  }
}