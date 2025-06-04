/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model.application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.exceptions.DomainException;
import model.services.ContractService;
import model.services.PaypalService;

/**
 *
 * @author crist
 */
public class ExerciseInstallmentGeneratorProgram01 {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            //Nesta Etapa é criado o objeto com as informações do Contrato.
            System.out.println("Informe os dados do Contrato:");
            System.out.print("\nNúmero do Contrato: ");
            Integer numbercotnract = scan.nextInt();
            System.out.print("\nData de Início do Contrato(dd/MM/yyyy):  ");
            scan.nextLine();
            LocalDate contractStartdate = LocalDate.parse(scan.nextLine(), dtf);
            System.out.print("\nValor do Contrato: ");
            Double contractValue = scan.nextDouble();
            Contract contract = new Contract(numbercotnract, contractStartdate, contractValue);
            
            //Nesta etapa é dado inicialização aos serviços de Contrato.
            ContractService contractService = new ContractService(new PaypalService());
            
            //Nesta etapa é solicitado em quantas parcelas se deseja dividir.
            System.out.print("\nEntre com o Número de Parcelas: ");
            Integer numberInstallments = scan.nextInt();
            
            //Neste momento é feitoa o processo de cálculos de Contrato.
            contractService.processContract(contract, numberInstallments);
            
            //Neste momento é apresentado as informações do Contrato
            System.out.println("PARCELAS: ");
            for(Installment installment: contract.getInstallment()){
                System.out.println(installment.getDueDate() + " - " + String.format("%.2f", installment.getAmount()));
            }
        }catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
    
}
