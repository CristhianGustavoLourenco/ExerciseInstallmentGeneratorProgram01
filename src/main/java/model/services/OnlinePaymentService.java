/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.services;

/**
 *
 * @author crist
 */
public interface OnlinePaymentService {
    double paymentFee(Double amount);
    double interest(Double amount, Integer months);
}
