package com.cse_craftmanship.walletapp.controller;

import com.cse_craftmanship.walletapp.exception.NotFoundException;
import com.cse_craftmanship.walletapp.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;

import com.cse_craftmanship.walletapp.service.WalletManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class WalletController {

  @Autowired
  WalletManager walletManager;

  // Get All Wallets
  @GetMapping("/wallets")
  public List<Wallet> getAllWallets() {
    return walletManager.getAll();
  }

  // Create a new Wallet
  @PostMapping(value = "/wallet")
  public Wallet createWallet(@Valid @RequestBody Wallet wallet) {

    return walletManager.saveWallet(wallet);

  }

  // Get a Single Wallet
  @GetMapping("/wallets/{id}")
  public Wallet getWalletById(@PathVariable(value = "id") Long walletId) {

    return walletManager.findById(walletId).orElseThrow(() -> new NotFoundException("Wallet is not found "));
  }

  // Update a Wallet
  @PutMapping("/wallets/{id}")
  public Wallet updateWallet(@PathVariable(value = "id") Long walletId, @Valid @RequestBody Wallet walletDetails) {

    Wallet wallet = walletManager.findById(walletId).orElseThrow(() -> new NotFoundException("Wallet is not found "));
    wallet.setName(walletDetails.getName());
    wallet.setDescription(walletDetails.getDescription());
    wallet.setBalance(walletDetails.getBalance());

    Wallet updatedWallet = walletManager.saveWallet(wallet);
    return updatedWallet;
  }

  // Delete a Wallet
  @DeleteMapping("/wallets/{id}")
  public ResponseEntity<?> deleteWallet(@PathVariable(value = "id") Long walletId) {
    Wallet wallet = walletManager.findById(walletId).orElseThrow(() -> new NotFoundException("Wallet is not found "));

    walletManager.deleteWallet(wallet);

    return ResponseEntity.ok().build();
  }

}
