package com.example.demo.Service;

import org.springframework.stereotype.Service;


// Service è una notazione che si utilizza per logica di business e elaborazione dei dati
@Service
public class OrderService {
    private NotificationService notificationService = new NotificationService();

    //injection automatica tramite costruttore
    public OrderService(NotificationService notificationService) {this.notificationService = notificationService;}
    public void processOrder(String orderId)
    {
        System.out.println("Elaborazione ordine: " + orderId);
        notificationService.sendConfirmation(orderId);
    }
    
}
