/*
 ************************************************************************
 Copyright [2011] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ************************************************************************
 */
package br.com.uol.pagseguro.example;

import java.math.BigDecimal;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.SenderDocument;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.domain.direct.BoletoPaymentRequest;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.enums.PaymentMode;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.TransactionService;

/**
 * Class with a main method to illustrate the usage of the domain class BoletoPaymentRequest
 */
public class CreateTransactionUsingBoleto {

    public static void main(String[] args) {
        // default mode
        createTransactionUsingDefaultMode();

        // gateway mode
        createTransactionUsingGatewayMode();
    }

    public static void createTransactionUsingDefaultMode() {
        final BoletoPaymentRequest request = new BoletoPaymentRequest();

        request.setPaymentMode(PaymentMode.DEFAULT);

        request.setReceiverEmail("backoffice@lojamodelo.com.br");

        request.setCurrency(Currency.BRL);

        request.setNotificationURL("http://www.meusite.com.br/notification");

        request.setReference("REF1234");

        request.setSender(new Sender("João Comprador", //
                "comprador@uol.com.br", //
                new Phone("11", "56273440"), //
                new SenderDocument(DocumentType.CPF, "000.000.001-91")));

        request.setShippingAddress(new Address("BRA", //
                "SP", //
                "Sao Paulo", //
                "Jardim Paulistano", //
                "01452002", //
                "Av. Brig. Faria Lima", //
                "1384", //
                "5º andar"));
        
        request.setShippingType(ShippingType.SEDEX);
        
        request.setShippingCost(new BigDecimal("5.00"));

        request.addItem(new Item("1", //
                "Notebook Prata", //
                Integer.valueOf(1), //
                new BigDecimal("2500.00")));
        
        request.addItem(new Item("2", //
                "Notebook Rosa", //
                Integer.valueOf(1), //
                new BigDecimal("2500.00")));

        try {
            final AccountCredentials accountCredentials = PagSeguroConfig.getAccountCredentials();

            final Transaction transaction = TransactionService.createTransaction(accountCredentials, //
                    request);

            if (transaction != null) {
                System.out.println("Transaction Code - Default Mode: " + transaction.getCode());
            }
        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void createTransactionUsingGatewayMode() {
        final BoletoPaymentRequest request = new BoletoPaymentRequest();

        request.setPaymentMode(PaymentMode.GATEWAY);

        request.setReceiverEmail("backoffice@lojamodelo.com.br");

        request.setCurrency(Currency.BRL);

        request.setNotificationURL("http://www.meusite.com.br/notification");

        request.setReference("REF1234");

        request.setSender(new Sender("João Comprador", "comprador@uol.com.br"));

        request.addItem(new Item("1", "Notebook Prata", Integer.valueOf(1), new BigDecimal("2500.00")));
        request.addItem(new Item("2", "Notebook Rosa", Integer.valueOf(1), new BigDecimal("2500.00")));

        try {
            final AccountCredentials accountCredentials = PagSeguroConfig.getAccountCredentials();

            final Transaction transaction = TransactionService.createTransaction(accountCredentials, //
                    request);

            if (transaction != null) {
                System.out.println("Transaction Code - Gateway Mode: " + transaction.getCode());
            }
        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }
    }

}
