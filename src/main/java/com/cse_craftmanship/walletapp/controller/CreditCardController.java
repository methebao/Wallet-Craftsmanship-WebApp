package com.cse_craftmanship.walletapp.controller;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.service.CreditCardManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class CreditCardController {
    @Autowired
    CreditCardManager creditCardManager;

    // Get All CreditCards
    @GetMapping("/creditcards")
    public List<CreditCard> getAllNotes() {
        return creditCardManager.getAllCreditCards();
    }

    // Create a new Credit
    @PostMapping(value = "/topup")
    public CreditCard createCreditCard(@Valid @RequestBody CreditCard creditCard) {

        return creditCardManager.createCreditCard(creditCard);

    }
    // Get a Single Credit
    @GetMapping("/credit/{id}")
    public CreditCard getCreditById(@PathVariable(value = "id") Long creditCardId) {

        return creditCardManager.findById(creditCardId);
    }
    // Update a Credit
    @PutMapping("/credits/{id}")
    public CreditCard updateCreditCard(@PathVariable(value = "id") Long creditCardId,
                               @Valid @RequestBody CreditCard CreditCardDetails) {

        CreditCard creditCard = creditCardManager.findById(creditCardId);
        creditCard.setName(CreditCardDetails.getName());
        creditCard.setExpiredDate(CreditCardDetails.getExpiredDate());
        creditCard.setCardNo(CreditCardDetails.getCardNo());

        CreditCard updateCreditCard = creditCardManager.createCreditCard(creditCard);
        return updateCreditCard;
    }
    // Delete a Credit
    @DeleteMapping("/credits/{id}")
    public ResponseEntity<?> deleteCreditCard(@PathVariable(value = "id") Long creditCardId) {
        CreditCard creditCard = creditCardManager.findById(creditCardId);

        creditCardManager.deleteCreditCard(creditCard);

        return ResponseEntity.ok().build();
    }
}
