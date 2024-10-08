package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import java.util.Date;

public class TransactionTest {

    private DateProvider dateProviderMock;

    @Before
    public void setUp() {
        dateProviderMock = mock(DateProvider.class);
        DateProvider.setInstance(dateProviderMock);
    }
    @Test
    public void testTransactionDate() {
        Date fixedDate = new Date();
        when(dateProviderMock.now()).thenReturn(fixedDate);

        Transaction t = new Transaction(5);
        assertEquals(fixedDate, t.getTransactionDate());
    }
}
