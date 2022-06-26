package com.hienvv.service.impl;

import com.hienvv.entity.Purchase;
import com.hienvv.model.dto.PurchaseItem;
import com.hienvv.repository.PurchaseRepository;
import com.hienvv.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase addPurchase(Purchase purchase) {
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseItem> findPurchaseItemOfUser(Long id) {
        return purchaseRepository.findAllPurchaseOfUser(id);
    }
}
