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

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.com.uol.pagseguro.domain.TransactionSearchResult;
import br.com.uol.pagseguro.domain.TransactionSummary;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.TransactionSearchService;

public class SearchTransactionByDate {

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        TransactionSearchResult transactionSearchResult = null;
        try {

            Calendar initialDate = Calendar.getInstance();
            initialDate.set(2014, Calendar.FEBRUARY, 01, 0, 00);

            Calendar finalDate = Calendar.getInstance();
            finalDate.set(2014, Calendar.FEBRUARY, 28, 17, 30);

            Integer page = Integer.valueOf(1);

            Integer maxPageResults = Integer.valueOf(10);

            // Set your account credentials on src/pagseguro-config.properties
            transactionSearchResult = TransactionSearchService.searchByDate(PagSeguroConfig.getAccountCredentials(),
                    initialDate.getTime(), finalDate.getTime(), page, maxPageResults);

        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }

        if (transactionSearchResult != null) {
            System.out.println("Search date: " + transactionSearchResult.getDate());

            List<TransactionSummary> listTransactionSummaries = transactionSearchResult.getTransactionSummaries();
            Iterator<TransactionSummary> transactionSummariesIterator = listTransactionSummaries.iterator();

            int counter = 0;

            while (transactionSummariesIterator.hasNext()) {
                TransactionSummary currentTransactionSummary = (TransactionSummary) transactionSummariesIterator.next();
                System.out.println();
                System.out.println("Transaction: " + ++counter);
                System.out.println("date: " + currentTransactionSummary.getDate());
                System.out.println("reference: " + currentTransactionSummary.getReference());
                System.out.println("code: " + currentTransactionSummary.getCode());
                System.out.println("type: " + currentTransactionSummary.getType());
                System.out.println("status: " + currentTransactionSummary.getStatus());
                System.out.println("paymentMethodType: " + currentTransactionSummary.getPaymentMethod().getType());
                System.out.println("grossAmount: " + currentTransactionSummary.getGrossAmount());
                System.out.println("disccountAmount: " + currentTransactionSummary.getDiscountAmount());
                System.out.println("feeAmount: " + currentTransactionSummary.getFeeAmount());
                System.out.println("netAmount: " + currentTransactionSummary.getNetAmount());
                System.out.println("extraAmount: " + currentTransactionSummary.getExtraAmount());
                System.out.println("lastEventDate: " + currentTransactionSummary.getLastEvent());
            }

            System.out.println();
            System.out.println(transactionSearchResult.getResultsInThisPage() + " result(s) in the page "
                    + transactionSearchResult.getPage() + " of " + transactionSearchResult.getTotalPages() + " pages.");
        }
    }

    private SearchTransactionByDate() {
    }
}
