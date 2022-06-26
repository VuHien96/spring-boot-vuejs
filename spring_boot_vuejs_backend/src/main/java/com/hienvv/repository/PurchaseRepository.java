package com.hienvv.repository;

import com.hienvv.entity.Purchase;
import com.hienvv.model.dto.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT " +
            "d.name AS name," +
            "d.deviceType AS type, " +
            "p.price AS price, " +
            "p.color AS color, " +
            "p.purchaseTime AS purchaseTime " +
            "FROM Purchase p " +
            "LEFT JOIN Device d ON p.device.id = d.id " +
            "WHERE p.user.id =: userId ")
    List<PurchaseItem> findAllPurchaseOfUser(@Param("userId") Long userId);
}
