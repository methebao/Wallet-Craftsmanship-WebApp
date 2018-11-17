package com.cse_craftmanship.walletapp.controller;

import com.cse_craftmanship.walletapp.model.Wallet;
import com.cse_craftmanship.walletapp.service.WalletManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

  @Autowired
  WalletManager walletManager;

  @RequestMapping(value="/")
  public ModelAndView showViewHome() {
    ModelAndView modelAndView = new ModelAndView("home");
    return modelAndView;
  }
  @RequestMapping(value="/topup")
  public ModelAndView showViewTopup() {
    ModelAndView modelAndView = new ModelAndView("topup");
    return modelAndView;
  }
  @RequestMapping(value="/wallet")
  public ModelAndView showViewWallet() {

    List<Wallet> wallets = walletManager.getAll();
    ModelAndView walletModelView = new ModelAndView("wallet");
    walletModelView.addObject("wallets", wallets);

    return walletModelView;
  }

}