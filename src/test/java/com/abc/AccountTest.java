/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carrington
 */
public class AccountTest {
    private Account checkingAccount;
    private Account savingsAccount;
    public AccountTest() {
    }
    @Before
    public void setUp() {
        checkingAccount = new Account(Account.CHECKING);
        savingsAccount = new Account(Account.SAVINGS);
    }
    @Test
    public void testDeposit() {
        checkingAccount.deposit(1000);
        assertEquals(1000, checkingAccount.sumTransactions(), 0);
    }
    
    @Test
    public void testWithdraw() {
        checkingAccount.deposit(1000);
        checkingAccount.withdraw(500);
        assertEquals(500, checkingAccount.sumTransactions(), 0);
    }
    @Test
    public void testInterestEarned() {
        savingsAccount.deposit(1500);
        assertEquals(1.5, savingsAccount.interestEarned(), 0.001);
    }
    @Test
    public void testTransfer() {
        checkingAccount.deposit(10000);
        checkingAccount.transfer(savingsAccount, 5000);
        assertEquals(5000, checkingAccount.sumTransactions(), 0);
        assertEquals(5000, savingsAccount.sumTransactions(), 0);
    }
}
