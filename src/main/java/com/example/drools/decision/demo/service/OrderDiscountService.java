package com.example.drools.decision.demo.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drools.decision.demo.model.OrderDiscount;
import com.example.drools.decision.demo.model.OrderRequest;

import javax.annotation.Resource;


@Service
public class OrderDiscountService {
 
    private KieContainer kieContainer;
    public OrderDiscountService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public OrderDiscount getDiscount(OrderRequest orderRequest) {
        OrderDiscount orderDiscount = new OrderDiscount();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderDiscount;
    }
}