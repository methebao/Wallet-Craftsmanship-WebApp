package com.cse_craftmanship.walletapp.controller;

import com.cse_craftmanship.walletapp.exception.NotFoundException;
import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.service.CreditCardManager;
import com.cse_craftmanship.walletapp.service.WalletManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CreditCardController {
  @Autowired
  CreditCardManager creditCardManager;
  @Autowired
  WalletManager walletManager;

  // Get All CreditCards
  @GetMapping("/wallets/{walletId}/credit-cards")
  public List<CreditCard> getAllCreditCardsByWalletId(@PathVariable(value = "walletId") Long walletId) {
    if (!walletManager.isExists(walletId)) {
      throw new NotFoundException("Walet is not found!");
    }
    return creditCardManager.getAllCreditCardsByWalletId(walletId);
  }

  // Create a new Credit
  @PostMapping(value = "/wallets/{walletId}/credit-card")
  public CreditCard createCreditCard(@PathVariable(value = "walletId") Long walletId,
      @Valid @RequestBody CreditCard creditCard) {
    return walletManager.findById(walletId).map(wallet -> {
      creditCard.setWallet(wallet);
      return creditCardManager.saveCreditCard(creditCard);
    }).orElseThrow(() -> new NotFoundException("Wallet is not found "));
  }

  // Get a Single Credit
  @GetMapping("/creditcards/{creditcardId}")
  public CreditCard getCreditById(@PathVariable(value = "creditcardId") Long creditCardId) {
    return creditCardManager.findById(creditCardId).orElseThrow(() -> new NotFoundException("CreditCard is not found"));
  }

  // Update a Credit
  @PutMapping("/wallets/{walletId}/credit-cards/{creditcardId}")
  public CreditCard updateCreditCard(@PathVariable(value = "walletId") Long walletId,
      @PathVariable(value = "creditcardId") Long creditCardId, @Valid @RequestBody CreditCard creditCardUpdated) {
    if (!walletManager.isExists(walletId)) {
      throw new NotFoundException("Walet is not found!");
    }

    return creditCardManager.findById(creditCardId).map(creditCard -> {
      creditCard.setCardNo(creditCardUpdated.getCardNo());
      creditCard.setExpiredDate(creditCardUpdated.getExpiredDate());
      creditCard.setCvv(creditCardUpdated.getCvv());
      return creditCardManager.saveCreditCard(creditCard);
    }).orElseThrow(() -> new NotFoundException("Credit card not found!"));
  }

  // Delete a Credit
  @DeleteMapping("/wallets/{walletId}/credit-cards/{creditcardId}")
  public String deleteCreditCard(@PathVariable Long creditCardId, @PathVariable Long walletId) {
    if (!walletManager.isExists(walletId)) {
      throw new NotFoundException("Walet is not found!");
    }
    return creditCardManager.findById(creditCardId).map(creditCard -> {
      creditCardManager.deleteCreditCard(creditCard);
      return "Deleted Successfully!";
    }).orElseThrow(() -> new NotFoundException("Contact not found!"));
  }
}
