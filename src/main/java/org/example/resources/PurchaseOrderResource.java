package org.example.resources;

import org.example.domain.PurchaseOrder;
import org.example.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/pedidos")
public class PurchaseOrderResource {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        PurchaseOrder obj = purchaseOrderService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
