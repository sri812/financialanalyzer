package com.service.financialanalyzer;

public class ApplicationConstants {

    private ApplicationConstants() {}

    public static final String CUSTOMER_API = "/api/customers";
    public static final String CUSTOMER_AGGREGATED_TRANSACTION = "/{customerID}/transactions/statement";
    public static final String CUSTOMER_ID = "/{customerID}";

    public static final String RECORD_NOT_FOUND = "Customer ID not found. please enter valid customer ID";

    public static final String TRANSACTION_SUMMARY_QUERY =
            "SELECT *, @a" + "\\:=" + "@a+ (totalIncoming - totalOutgoing) AS 'closingBalance' "
                    + "FROM ( "
                    + "SELECT "
                    + "    CONCAT(MONTHNAME(transaction_timestamp), YEAR(transaction_timestamp)) as transactionMonth "
                    + "    , customer_id as customerNumber"
                    + "    ,SUM(COALESCE(CASE WHEN payment_type = \"credit\" THEN amount else 0  end)) as 'totalIncoming'  "
                    + "    ,SUM(COALESCE(CASE WHEN payment_type = \"debit\" THEN amount else 0 end)) as 'totalOutgoing'  "
                    + "FROM "
                    + "    financialanalyzer.customer_transactions t  "
                    + "WHERE "
                    + "    customer_id = ?1 "
                    + "GROUP BY DATE_FORMAT(transaction_timestamp,'%Y-%m') "
                    + "ORDER BY MONTH (t.transaction_timestamp ) ASC "
                    + ") A "
                    + "JOIN (SELECT @a" + "\\:=" + "0) t ";
}
