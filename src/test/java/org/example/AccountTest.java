package org.example;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private String test;
    private boolean isValid;
    private Account account;
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    public AccountTest(String test, boolean isValid) {
        this.test = test;
        this.isValid = isValid;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"to", false},//less than 2 symbols
                {"asdfghjk oqwertyuiopvxs", false},//20 symbols
                {"nbvjntqifkfvjd", false},//no blanks
                {"nbvjnb i fkfvt", false},//2 blanks
                {" timoti shalame", false},//starts with blank
                {"timoti shalame ", false},//ends with blank
                {"timoti shalame", true},//ends with blank
        };
    }
    @Test
    public void isValidName() {
        account = new Account(test);
        boolean actualIsValid = account.checkNameToEmboss();
        assertEquals(actualIsValid, isValid);
    }
}