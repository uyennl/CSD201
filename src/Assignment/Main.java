package Assignment;

import Assignment.Controller.TransactionAnalyzer;
import Assignment.Model.Transaction;
import Assignment.Model.User;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        TransactionAnalyzer transactionAnalyzer = new TransactionAnalyzer();

        // Create a sample user
        User user = new User("John Doe", "1234567890", 1000.0);

        // Generate a list of random transactions
        List<Transaction> transactions = transactionAnalyzer.generateRandomTransactions(50);

        // Create a transaction analyzer for the user and transactions
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions, user);

        // Calculate balance history
        List<Double> balanceHistory = analyzer.calculateBalanceHistory();
        System.out.println("Balance History: " + balanceHistory);

        // Find min and max balance
        double[] minMaxBalance = analyzer.findMinMaxBalance();
        System.out.println("Min Balance: " + minMaxBalance[0]);
        System.out.println("Max Balance: " + minMaxBalance[1]);

        // Find top deposits and withdrawals
        List<Double> topDeposits = analyzer.findTopDeposits();
        List<Double> topWithdrawals = analyzer.findTopWithdrawals();
        System.out.println("Top Deposits: " + topDeposits);
        System.out.println("Top Withdrawals: " + topWithdrawals);

        // Find mean transaction amount
        double meanDepositAmount = analyzer.findMeanTransaction("deposit");
        double meanWithdrawalAmount = analyzer.findMeanTransaction("withdrawal");
        System.out.println("Mean Deposit Amount: " + meanDepositAmount);
        System.out.println("Mean Withdrawal Amount: " + meanWithdrawalAmount);

        // Find most frequent transactions
        List<Double> mostFrequentTransactions = analyzer.findMostFrequentTransactions();
        System.out.println("Most Frequent Transactions: " + mostFrequentTransactions);
    }

}
