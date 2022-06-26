package com.hienvv.controller;

import com.hienvv.entity.Purchase;
import com.hienvv.security.UserPrincipal;
import com.hienvv.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchases")
    public ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return new ResponseEntity<>(purchaseService.findPurchaseItemOfUser(userPrincipal.getId()), HttpStatus.OK);
    }

    @PostMapping("/purchases")
    public ResponseEntity<?> createPurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.addPurchase(purchase), HttpStatus.CREATED);
    }

}
