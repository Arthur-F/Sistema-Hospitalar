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

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.paymentmethod.PaymentMethod;
import br.com.uol.pagseguro.domain.paymentmethod.PaymentMethods;
import br.com.uol.pagseguro.enums.PaymentMethodType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.PaymentMethodService;

/**
 * Class with a main method to illustrate the usage of the InstallmentService to get the installments available
 */
public class GetPaymentMethods {

    public static void main(String[] args) {
        try {
            final AccountCredentials accountCredentials = PagSeguroConfig.getAccountCredentials();

            final String publicKey = "PUBE469778A81D64C838DA121DB3180FE36";
            final PaymentMethods paymentMethods = PaymentMethodService.getPaymentMethods(accountCredentials, //
                    publicKey);

            for (PaymentMethod paymentMethod : paymentMethods.getPaymentMethodsByType(PaymentMethodType.CREDIT_CARD)) {
                System.out.println(paymentMethod);
            }
        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }
    }

}
