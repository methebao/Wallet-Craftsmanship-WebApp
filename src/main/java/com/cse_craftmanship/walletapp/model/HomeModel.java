package com.cse_craftmanship.walletapp.model;

import java.io.Serializable;
import java.util.List;

public class HomeModel implements Serializable {
  private static final long serialVersionUID = -8138063240254512372L;

  List<Wallet> wallets;

  public List<Wallet> getWallets() {
    return this.wallets;
  }

  public void setWallets(List<Wallet> wallets) {
    this.wallets = wallets;
  }

  List<BillPayment> billPayments;

  public List<BillPayment> getBillPayments() {
    return this.billPayments;
  }

  public void setBillPayments(List<BillPayment> billPayments) {
    this.billPayments = billPayments;
  }

  List<CreditCard> creditCards;

  public List<CreditCard> getCreditCards() {
    return this.creditCards;
  }

  public void setCreditCards(List<CreditCard> creditCards) {
    this.creditCards = creditCards;
  }

  private Long defaultWalletId;

  public Long getDefaultWalletid() {
    return this.defaultWalletId;
  }

  public void setDefaultWalletid(Long defaultWalletId) {
    this.defaultWalletId = defaultWalletId;
  }

}