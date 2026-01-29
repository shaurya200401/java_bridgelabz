package collectionsFramework.mapInterface;

import java.util.*;

/**
 * Banking System Implementation.
 * - HashMap: Customer Accounts (AccountNumber -> Balance)
 * - TreeMap: Sort Customers by Balance (Value Sort simulation)
 * - Queue: Process withdrawal requests
 */
public class BankingSystem {

    public static void main(String[] args) {
        // Accounts: AccNo -> Balance
        Map<Integer, Double> accounts = new HashMap<>();
        accounts.put(101, 500.0);
        accounts.put(102, 1000.0);
        accounts.put(103, 250.0);

        System.out.println("Accounts: " + accounts);

        // Sort customers by Balance
        System.out.println("\nCustomers sorted by Balance:");
        List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(accounts.entrySet());
        sortedList.sort(Map.Entry.comparingByValue()); // Ascending order
        // To do descending (richest first):
        // sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Integer, Double> entry : sortedList) {
            System.out.println("Acc " + entry.getKey() + ": $" + entry.getValue());
        }

        // Processing Withdrawals Queue
        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add(new WithdrawalRequest(101, 100.0));
        withdrawalQueue.add(new WithdrawalRequest(103, 300.0)); // Overdraft attempt
        withdrawalQueue.add(new WithdrawalRequest(102, 500.0));

        System.out.println("\nProcessing Withdrawals:");
        processWithdrawals(withdrawalQueue, accounts);

        System.out.println("\nFinal Balance: " + accounts);
    }

    static class WithdrawalRequest {
        int accNo;
        double amount;

        public WithdrawalRequest(int accNo, double amount) {
            this.accNo = accNo;
            this.amount = amount;
        }
    }

    private static void processWithdrawals(Queue<WithdrawalRequest> queue, Map<Integer, Double> accounts) {
        while (!queue.isEmpty()) {
            WithdrawalRequest req = queue.poll();
            if (accounts.containsKey(req.accNo)) {
                double currentBal = accounts.get(req.accNo);
                if (currentBal >= req.amount) {
                    accounts.put(req.accNo, currentBal - req.amount);
                    System.out.println("Success: Withdrawn $" + req.amount + " from Acc " + req.accNo);
                } else {
                    System.out.println("Failed: Insufficient funds for Acc " + req.accNo);
                }
            } else {
                System.out.println("Failed: Account " + req.accNo + " not found.");
            }
        }
    }
}
