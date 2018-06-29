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

import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.TransactionSearchService;

public class SearchTransactionByCode {

    public static void main(String[] args) {

        // Substitute the code below with a valid transaction code for your
        // account

        String transactionCode = "4EDCA6AD-112D-4474-BA4E-E613A095B93A";

        Transaction transaction = null;

        try {

            // Set your account credentials on src/pagseguro-config.properties
            transaction = TransactionSearchService.searchByCode(PagSeguroConfig.getAccountCredentials(),
                    transactionCode);

        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }

        if (transaction != null) {
            printTransaction(transaction);
        }
    }

    private static void printTransaction(Transaction transaction) {

        System.out.println("date: " + transaction.getDate());
        System.out.println("code: " + transaction.getCode());
        System.out.println("reference: " + transaction.getReference());
        System.out.println("type: " + transaction.getType());
        System.out.println("status: " + transaction.getStatus());

        if (transaction.getStatus().getValue() == 7) {
            System.out.println("cancellationSource: " + transaction.getCancellationSource());
        }

        System.out.println("lastEventDate: " + transaction.getLastEventDate());
        System.out.println("paymentMethodType: " + transaction.getPaymentMethod().getType());
        System.out.println("paymentMethodCode: " + transaction.getPaymentMethod().getCode());

        if (transaction.getPaymentLink() != null) {
            System.out.println("paymentLink: " + transaction.getPaymentLink());
        }

        System.out.println("grossAmount: " + transaction.getGrossAmount());
        System.out.println("discountAmount: " + transaction.getDiscountAmount());
        System.out.println("feeAmount: " + transaction.getFeeAmount());
        System.out.println("netAmount: " + transaction.getNetAmount());
        System.out.println("extraAmount: " + transaction.getExtraAmount());
        System.out.println("installmentCount: " + transaction.getInstallmentCount());
        System.out.println("itemCount: " + transaction.getItemCount());

        for (int i = 0; i < transaction.getItems().size(); i++) {
            System.out.println("itemId: " + transaction.getItems().get(i).getId());
            System.out.println("itemDescription: " + transaction.getItems().get(i).getDescription());
            System.out.println("itemQuantity: " + transaction.getItems().get(i).getQuantity());
            System.out.println("itemAmount: " + transaction.getItems().get(i).getAmount());
        }

        System.out.println("senderName: " + transaction.getSender().getName());
        System.out.println("senderEmail: " + transaction.getSender().getEmail());

        if (transaction.getSender() != null) {
            System.out.println("senderPhoneAreaCode: " + transaction.getSender().getPhone().getAreaCode());
            System.out.println("senderPhoneNumber: " + transaction.getSender().getPhone().getNumber());
        }

        if (transaction.getShipping() != null) {
            if (transaction.getShipping().getAddress() != null) {
                System.out.println("shippingAddressStreet: " + transaction.getShipping().getAddress().getStreet());
                System.out.println("shippingAddressNumber: " + transaction.getShipping().getAddress().getNumber());
                System.out.println("shippingAddressComplement: "
                        + transaction.getShipping().getAddress().getComplement());
                System.out.println("shippingAddressDistrict: " + transaction.getShipping().getAddress().getDistrict());
                System.out.println("shippingAddressCity: " + transaction.getShipping().getAddress().getCity());
                System.out.println("shippingAddressState: " + transaction.getShipping().getAddress().getState());
                System.out.println("shippingAddressCountry: " + transaction.getShipping().getAddress().getCountry());
                System.out.println("shippingAddressPostalCode: "
                        + transaction.getShipping().getAddress().getPostalCode());
            }
            System.out.println("shippingType: " + transaction.getShipping().getType());
            System.out.println("shippingCost: " + transaction.getShipping().getCost());
        }

    }

    private SearchTransactionByCode() {
    }

}