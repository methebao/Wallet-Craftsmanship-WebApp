package com.cse_craftmanship.walletapp.controller;

import com.cse_craftmanship.walletapp.exception.NotFoundException;
import com.cse_craftmanship.walletapp.model.BillPayment;
import com.cse_craftmanship.walletapp.model.Wallet;
import com.cse_craftmanship.walletapp.service.BillPaymentManager;
import com.cse_craftmanship.walletapp.service.WalletManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillPaymentController {
  @Autowired
  BillPaymentManager billPaymentManager;
  @Autowired
  WalletManager walletManager;

  // Get All BillPayments
  @GetMapping("/wallets/{walletId}/bill-payments")
  public List<BillPayment> getAllBillPaymentsByWalletId(@PathVariable(value = "walletId") Long walletId) {
    if (!walletManager.isExists(walletId)) {
      throw new NotFoundException("Walet is not found!");
    }
    return billPaymentManager.getAllBillPaymentsByWalletId(walletId);
  }

  // Create a new Payment
  @PostMapping(value = "/wallets/{walletId}/bill-payment")
  public BillPayment createBillPayment(@PathVariable(value = "walletId") Long walletId,
      @Valid @RequestBody BillPayment billPayment) {
    // TODOS: Calculate initAmount to minus the total amount of wallet
    return walletManager.findById(walletId).map(wallet -> {
      Wallet savedWallet = walletManager.chargeBill(wallet, billPayment.getInitAmount());
      billPayment.setWallet(savedWallet);
      return billPaymentManager.saveBillPayment(billPayment);
    }).orElseThrow(() -> new NotFoundException("Wallet is not found "));
  }

  // Get a Single Payment
  @GetMapping("/BillPayments/{BillPaymentId}")
  public BillPayment getCreditById(@PathVariable(value = "billPaymentId") Long billPaymentId) {
    return billPaymentManager.findById(billPaymentId)
        .orElseThrow(() -> new NotFoundException("BillPayment is not found"));
  }

  // Update a Payment
  @PutMapping("/wallets/{walletId}/credit-cards/{BillPaymentId}")
  public BillPayment updateBillPayment(@PathVariable(value = "walletId") Long walletId,
      @PathVariable(value = "billPaymentId") Long billPaymentId, @Valid @RequestBody BillPayment billPaymentUpdated) {
    if (!walletManager.isExists(walletId)) {
      throw new NotFoundException("Walet is not found!");
    }

    return billPaymentManager.findById(billPaymentId).map(billPayment -> {
      billPayment.setBillno(billPaymentUpdated.getBillno());
      billPayment.setConsumerNo(billPaymentUpdated.getConsumerNo());
      billPayment.setInitAmount(billPaymentUpdated.getInitAmount());
      billPayment.setName(billPaymentUpdated.getName());
      return billPaymentManager.saveBillPayment(billPayment);
    }).orElseThrow(() -> new NotFoundException("Credit card not found!"));
  }

  // Delete a Payment
  @DeleteMapping("/wallets/{walletId}/credit-cards/{billPaymentId}")
  public String deleteBillPayment(@PathVariable Long billPaymentId, @PathVariable Long walletId) {
    if (!walletManager.isExists(walletId)) {
      throw new NotFoundException("Walet is not found!");
    }
    return billPaymentManager.findById(billPaymentId).map(billPayment -> {
      billPaymentManager.deleteBillPayment(billPayment);
      return "Deleted Successfully!";
    }).orElseThrow(() -> new NotFoundException("Contact not found!"));
  }
}
