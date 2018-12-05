package com.cse_craftmanship.walletapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.cse_craftmanship.walletapp.model.Wallet;
import com.cse_craftmanship.walletapp.model.HomeModel;
import com.cse_craftmanship.walletapp.service.BillPaymentManager;
import com.cse_craftmanship.walletapp.service.CreditCardManager;
import com.cse_craftmanship.walletapp.service.WalletManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @Autowired
  WalletManager walletManager;

  @Autowired
  BillPaymentManager billPaymentManager;
  @Autowired
  CreditCardManager creditCardMananger;

  @RequestMapping(value = "/")
  public ModelAndView showViewHome() {
    ModelAndView homeModelView = new ModelAndView("home");
    List<Wallet> wallets = walletManager.getAll();
    HomeModel homeDataModel = new HomeModel();
    homeDataModel.setWallets(wallets);

    if (!wallets.isEmpty()) {
      Long defaultWalletId = wallets.get(0).getId();
      homeDataModel.setDefaultWalletid(defaultWalletId);
      homeDataModel.setCreditCards(creditCardMananger.getAllCreditCardsByWalletId(defaultWalletId));

      homeDataModel.setBillPayments(billPaymentManager.getAllBillPaymentsByWalletId(defaultWalletId));
    }
    homeModelView.addObject("homeData", homeDataModel);

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
    ModelAndView billPaymentModelView = new ModelAndView("billpayment");
    List<Wallet> wallets = walletManager.getAll();
    billPaymentModelView.addObject("wallets", wallets);

    return billPaymentModelView;
  }

}