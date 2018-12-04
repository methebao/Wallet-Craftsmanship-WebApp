package com.cse_craftmanship.walletapp.controller;

import com.cse_craftmanship.walletapp.service.WalletManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @Autowired
  WalletManager walletManager;

  @RequestMapping(value = "/")
  public ModelAndView showViewHome() {
    ModelAndView homeModelView = new ModelAndView("home");
    homeModelView.addObject("wallets", walletManager.getAll());

    return homeModelView;
  }

  @RequestMapping(value = "/topup")
  public ModelAndView showViewTopup() {
    ModelAndView topupModelView = new ModelAndView("topup");
    topupModelView.addObject("wallets", walletManager.getAll());

    return topupModelView;
  }

  @RequestMapping(value = "/wallet")
  public ModelAndView showViewWallet() {
    ModelAndView walletModelView = new ModelAndView("wallet");
    walletModelView.addObject("wallets", walletManager.getAll());

    return walletModelView;
  }

  @RequestMapping(value = "/billpayment")
  public ModelAndView showViewBillPayment() {
    ModelAndView billPaymentModelView = new ModelAndView("wallet");
    billPaymentModelView.addObject("wallets", walletManager.getAll());

    return billPaymentModelView;
  }

}