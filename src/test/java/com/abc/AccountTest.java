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
    private Account superSavingsAccount;
    private Account maxiSavingsAccount;
    public AccountTest() {
    }
    @Before
    public void setUp() {
        checkingAccount = new Account(Account.CHECKING);
        savingsAccount = new Account(Account.SAVINGS);
        superSavingsAccount = new Account(Account.SUPER_SAVINGS);
        maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
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
    @Test
    public void testSuperSavingsInterest() {

      // Test interest for amount <= 1000
      superSavingsAccount.deposit(1000);
      assertEquals(40, superSavingsAccount.interestEarned(), 0.001);

      // Test interest for amount between 1000 and 2000
      superSavingsAccount.deposit(1000); // Total 2000
      assertEquals(110, superSavingsAccount.interestEarned(), 0.001);

      // Test interest for amount > 2000
      superSavingsAccount.deposit(1000); // Total 3000
      assertEquals(230, superSavingsAccount.interestEarned(), 0.001);
   }
  @Test
  public void testMaxiSavingsInterest() {

     // Test interest for amount <= 1000
     maxiSavingsAccount.deposit(1000);
     assertEquals(20, maxiSavingsAccount.interestEarned(), 0.001);

     // Test interest for amount between 1000 and 2000
     maxiSavingsAccount.deposit(1000); // Total 2000
     assertEquals(70, maxiSavingsAccount.interestEarned(), 0.001);

    // Test interest for amount > 2000
    maxiSavingsAccount.deposit(1000); // Total 3000
    assertEquals(170, maxiSavingsAccount.interestEarned(), 0.001);
 }
}
