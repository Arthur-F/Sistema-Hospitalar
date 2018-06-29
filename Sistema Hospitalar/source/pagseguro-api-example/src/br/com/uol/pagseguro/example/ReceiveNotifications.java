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
import br.com.uol.pagseguro.service.NotificationService;

public class ReceiveNotifications {

    public static void main(String[] args) {

        // The notificationCode received by your system
        String notificationCode = "83C949615C535C53ECEAA453CF8848D59180";

        Transaction transaction = null;

        try {

            transaction = NotificationService.checkTransaction(PagSeguroConfig.getAccountCredentials(),
                    notificationCode);

        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }

        if (transaction != null) {
            System.out.println("code: " + transaction.getCode());
            System.out.println("reference: " + transaction.getReference());
            System.out.println("status: " + transaction.getStatus());
        }

    }

    private ReceiveNotifications() {
    }
}