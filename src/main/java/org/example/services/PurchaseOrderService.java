package org.example.services;

import org.example.domain.PurchaseOrder;
import org.example.repositories.PurchaseOrderRepository;
import org.example.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrder find(Integer id) {
        Optional<PurchaseOrder> obj = purchaseOrderRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + PurchaseOrder.class.getName()));

    }
}
