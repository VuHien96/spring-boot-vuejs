package com.hienvv.service;

import com.hienvv.entity.Purchase;
import com.hienvv.model.dto.PurchaseItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    Purchase addPurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemOfUser(Long id);
}
