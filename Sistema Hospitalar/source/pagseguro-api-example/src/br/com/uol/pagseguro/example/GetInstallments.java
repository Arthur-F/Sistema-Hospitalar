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
import br.com.uol.pagseguro.domain.installment.Installment;
import br.com.uol.pagseguro.domain.installment.Installments;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.InstallmentService;

/**
 * Class with a main method to illustrate the usage of the InstallmentService to get the installments available
 */
public class GetInstallments {

    public static void main(String[] args) {
        Installments installments;
        String cardBrand;

        try {
            final AccountCredentials accountCredentials = PagSeguroConfig.getAccountCredentials();

            cardBrand = "visa";
            installments = InstallmentService.getInstallments(accountCredentials, //
                    new BigDecimal("5000.00"), //
                    cardBrand);

            for (Installment installment : installments.get(cardBrand)) {
                System.out.println(installment);
            }

            System.out.println();

            cardBrand = "mastercard";
            installments = InstallmentService.getInstallments(accountCredentials, //
                    new BigDecimal("5000.00"));

            for (Installment installment : installments.get(cardBrand)) {
                System.out.println(installment);
            }
        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }
    }

}
