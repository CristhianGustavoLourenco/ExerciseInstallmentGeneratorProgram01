/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

/**
 *
 * @author crist
 */
public class PaypalService implements OnlinePaymentService{
    
    public double paymentFee(Double amount){
        return amount * 0.02;
    }

    public double interest(Double amount, Integer months){   
       return amount * 0.01 * months;
    }
}
