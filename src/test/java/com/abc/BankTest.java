package com.abc;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;
    private Bank bank;
    @Before
    public void setUp() {
        bank = new Bank();  // Initializing a new Bank instance before each test
    }
    @Test
    public void customerSummary() {
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
 @Test
    public void testFirstCustomerSuccess() {
        Customer customer = new Customer("dummy");
        bank.addCustomer(customer);
        String firstCustomerName = bank.getFirstCustomer();
        assertEquals("dummy", firstCustomerName);
    }
    @Test
    public void testFirstCustomerWithNoCustomers() {
        String firstCustomerName = bank.getFirstCustomer();
        assertEquals("No customers available", firstCustomerName);
    }

}
