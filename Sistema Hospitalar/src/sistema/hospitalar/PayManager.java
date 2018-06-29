/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import cieloecommerce.sdk.Environment;
import cieloecommerce.sdk.Merchant;
import cieloecommerce.sdk.ecommerce.CieloEcommerce;
import cieloecommerce.sdk.ecommerce.Payment;
import cieloecommerce.sdk.ecommerce.Sale;
import cieloecommerce.sdk.ecommerce.SaleResponse;
import cieloecommerce.sdk.ecommerce.request.CieloError;
import cieloecommerce.sdk.ecommerce.request.CieloRequestException;
import java.io.IOException;


/**
 *
 * @author ArthurFerreiraPinto
 */

public class PayManager {
    
        final Merchant merchant;
        CieloEcommerce ecomm;

    public PayManager() {
        this.merchant = new Merchant(" 34b58841-9744-46f9-8ea5-ad88b34c62e6", "KPSBFGMVKQAJTBNNVKYLGDOPREKBOFCEXUYYEGNK");
        
    }
    
    public int criarVenda(String id, int valor, int tipo)
    {
        Sale sale = new Sale(id);
        Payment payment = sale.payment(valor);
        SaleResponse resposta = null;
         CieloEcommerce ecomm = new CieloEcommerce(merchant,cieloecommerce.sdk.ecommerce.Environment.SANDBOX);
        if (tipo == 0)
        {
            payment.creditCard("123", "Visa").setExpirationDate("12/2018").setCardNumber("0000000000000001").setHolder("Fulano de Tal");
        }
        if (tipo == 1)
        {
            payment.debitCard("123", "Visa").setExpirationDate("12/2018").setCardNumber("0000000000000002").setHolder("Fulano de Tal");
        }
        try {
        
            // Configure o SDK com seu merchant e o ambiente apropriado para criar a venda
               
//                sale = new CieloEcommerce(merchant, cieloecommerce.sdk.ecommerce.Environment.SANDBOX).createSale(sale);
              //  sale = new CieloEcommerce(merchant, cieloecommerce.sdk.ecommerce.Environment.SANDBOX);
                return (ecomm.createSale(sale)).getPayment().getStatus();
            // Com a venda criada na Cielo, já temos o ID do pagamento, TID e demais
            // dados retornados pela Cielo
        //    String paymentId = sale.getPayment().getPaymentId();

           // resposta = new CieloEcommerce(merchant, cieloecommerce.sdk.ecommerce.Environment.SANDBOX).captureSale(paymentId, valor, 0);
            
            // E também podemos fazer seu cancelamento, se for o caso
           // sale = new CieloEcommerce(merchant, Environment.SANDBOX).cancelSale(paymentId, 15700);
        } catch (CieloRequestException e) {
            // Em caso de erros de integração, podemos tratar o erro aqui.
            // os códigos de erro estão todos disponíveis no manual de integração.
            CieloError error = e.getError();
        } catch (IOException e) {
                e.printStackTrace();
        }
                return 0;
    }
    
   
    
   
     
}
