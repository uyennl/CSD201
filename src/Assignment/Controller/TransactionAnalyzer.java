package Assignment.Controller;



import Assignment.Model.Transaction;
import Assignment.Model.User;
import java.util.*;

public class TransactionAnalyzer {
    private List<Transaction> transactions;
    private User user;

    public TransactionAnalyzer(List<Transaction> transactions, User user) {
        this.transactions = transactions;
        this.user = user;
    }

    public TransactionAnalyzer() {
    }

    public List<Double> calculateBalanceHistory() {
        List<Double> balanceHistory = new ArrayList<>();
        double balance = user.getBalance();
        balanceHistory.add(balance);

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("deposit")) {
                balance += transaction.getAmount();
            } else if (transaction.getType().equals("withdrawal")) {
                balance -= transaction.getAmount();
            }
            balanceHistory.add(balance);
        }

        return balanceHistory;
    }

    public double[] findMinMaxBalance() {
        double minBalance = Double.MAX_VALUE;
        double maxBalance = Double.MIN_VALUE;

        for (Double balance : calculateBalanceHistory()) {
            if (balance < minBalance) {
                minBalance = balance;
            }
            if (balance > maxBalance) {
                maxBalance = balance;
            }
        }

        return new double[]{minBalance, maxBalance};
    }

    public List<Double> findTopDeposits() {
        List<Double> topDeposits = new ArrayList<>();
        List<Double> depositAmounts = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("deposit")) {
                depositAmounts.add(transaction.getAmount());
            }
        }

        depositAmounts.sort((a, b) -> Double.compare(b, a));

        for (int i = 0; i < Math.min(3, depositAmounts.size()); i++) {
            topDeposits.add(depositAmounts.get(i));
        }

        return topDeposits;
    }

    public List<Double> findTopWithdrawals() {
        List<Double> topWithdrawals = new ArrayList<>();
        List<Double> withdrawalAmounts = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("withdrawal")) {
                withdrawalAmounts.add(transaction.getAmount());
            }
        }

        withdrawalAmounts.sort((a, b) -> Double.compare(b, a));

        for (int i = 0; i < Math.min(3, withdrawalAmounts.size()); i++) {
            topWithdrawals.add(withdrawalAmounts.get(i));
        }

        return topWithdrawals;
    }

    public double findMeanTransaction(String type) {
        double totalAmount = 0;
        int count = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals(type)) {
                totalAmount += transaction.getAmount();
                count++;
            }
        }

        return count > 0 ? totalAmount / count : 0;
    }

    public List<Double> findMostFrequentTransactions() {
        List<Double> mostFrequentTransactions = new ArrayList<>();
        List<Double> transactionAmounts = new ArrayList<>();

        for (Transaction transaction : transactions) {
            transactionAmounts.add(transaction.getAmount());
        }

        double[] counts = new double[transactionAmounts.size()];

        for (int i = 0; i < transactionAmounts.size(); i++) {
            double currentAmount = transactionAmounts.get(i);
            int currentCount = 0;

            for (int j = 0; j < transactionAmounts.size(); j++) {
                if (transactionAmounts.get(j) == currentAmount) {
                    currentCount++;
                }
            }

            counts[i] = currentCount;
        }

        double maxCount = Double.MIN_VALUE;

        for (double count : counts) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxCount && !mostFrequentTransactions.contains(transactionAmounts.get(i))) {
                mostFrequentTransactions.add(transactionAmounts.get(i));
            }
        }

        return mostFrequentTransactions;
    }


    public List<Transaction> generateRandomTransactions(int count) {
        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String date = "2022-01-01"; // Replace with random date generation logic
            double amount = random.nextDouble() * 20000 - 10000;
            String type = random.nextBoolean() ? "deposit" : "withdrawal";
            transactions.add(new Transaction(date, amount, type));
        }

        return transactions;
    }
}