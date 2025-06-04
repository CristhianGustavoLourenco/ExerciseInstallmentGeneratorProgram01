/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

/**
 *
 * @author crist
 */
public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public ContractService() {
    }

    public void processContract(Contract contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;
        LocalDate startDate = contract.getDate();
        
        for(int i = 1; i <= months; i++){
            
            LocalDate dueDate = startDate.plusMonths(i);
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota,i);
            double finalQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
        
            contract.getInstallment().add(new Installment(dueDate, finalQuota));
        }
    }

}
