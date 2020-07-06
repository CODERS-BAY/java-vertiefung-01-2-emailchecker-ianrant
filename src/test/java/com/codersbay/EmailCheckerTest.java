package com.codersbay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailCheckerTest {

    @Test
    @DisplayName("Checks if the address has exactly one @ sign in it")
    public void testCheckForExistingAt() {
        EmailChecker emailChecker = new EmailChecker("something.at");
        assertEquals(emailChecker.oneAtExists(), false);
    }

    @Test
    @DisplayName("Checks if the address is not empty")
    public void testStringIsNotEmpty() {
        EmailChecker emailChecker = new EmailChecker("");
        assertEquals(emailChecker.stringIsNotEmpty(), false);
    }

    @Test
    @DisplayName("Checks if the address is not NULL")
    public void testStringIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmailChecker(null);
        });
    }

    @Test
    @DisplayName("Checks if not two (or more) sequential periods appear in the address")
    public void testSequentialPeriodsDoNotExist() {
        EmailChecker emailChecker = new EmailChecker("test..test@test.com");
        assertEquals(emailChecker.sequentialPeriodsDoNotExist(), false);
    }

    @Test
    @DisplayName("Checks if there is no period at the beginning and/or the end of the address")
    public void testFringePeriodsDoNotExist() {
        EmailChecker emailChecker = new EmailChecker(".test@test.com.");
        assertEquals(emailChecker.fringePeriodsDoNotExist(), false);
    }

    @Test
    @DisplayName("Checks (after the sequential periods) if there are at least two characters in the local section")
    public void testTwoLocalCharsNonPeriod() {
        EmailChecker emailChecker = new EmailChecker("..@test.com");
        assertEquals(emailChecker.twoLocalCharsNonPeriod(), false);
    }

    @Test
    @DisplayName("Checks if there is at least one period in the domain section")
    public void testDomainPeriodExists() {
        EmailChecker emailChecker = new EmailChecker("test@testcom");
        assertEquals(emailChecker.domainPeriodExists(), false);
    }

    @Test
    @DisplayName("Checks if the host section contains at least one letter or number")
    public void testMinLengthOfHostIsValid() {
        EmailChecker emailChecker = new EmailChecker("test@.at");
        assertEquals(emailChecker.minLengthOfHostIsValid(), false);
    }

    @Test
    @DisplayName("Checks if the top level domain section contains at least 2 letters")
    public void testMinLengthOfDomainIsValid() {
        EmailChecker emailChecker = new EmailChecker("test@c.a");
        assertEquals(emailChecker.minLengthOfDomainIsValid(), false);
    }

    @Test
    @DisplayName("Checks if the local section contains a maximum of 64 characters")
    public void testMaxLengthOfLocalNotExceeded() {
        EmailChecker emailChecker = new EmailChecker("derdomainteilderddressedarfmaximal255zeichenlangseinzeichenlangseindarfmaximal@test.at");
        assertEquals(emailChecker.maxLengthOfLocalNotExceeded(), false);
    }

    @Test
    @DisplayName("Checks if the entire domain (a.k.a all after @) contains a maximum of 255 characters")
    public void testMaxLengthOfEntireDomainNotExceeded() {
        EmailChecker emailChecker = new EmailChecker("sheev@somethingsomethingsomethingsomethingdarkside.empire");
        assertEquals(emailChecker.maxLengthOfEntireDomainNotExceeded(), true);
    }

    @Test
    @DisplayName("Checks if entire address contains a maximum of 320 characters")
    public void testMaxLengthOfAddressNotExceeded() {
        EmailChecker emailChecker = new EmailChecker("derdomainteilderddressedarfmaximal255zeichenlangseinzeichenlangseindarfmaximal@somethingsomethingsomethingsomethingdarkside.empire");
        assertEquals(emailChecker.maxLengthOfAddressNotExceeded(), true);
    }

    @Test
    @DisplayName("Checks if there are no ASCII characters above 127 in the address")
    public void testOnlyPermittedASCIIFound() {
        EmailChecker emailChecker = new EmailChecker("max.müller@derödetrödelladen.at");
        assertEquals(emailChecker.onlyPermittedASCIIFound(), false);
    }

    @Test
    @DisplayName("Checks if there are no blank spaces in the address")
    public void testNoBlankSpaceFound() {
        EmailChecker emailChecker = new EmailChecker("my address@test.com");
        assertEquals(emailChecker.noBlankSpaceFound(), false);
    }

    @Test
    @DisplayName("Replaces capital letters with small letters")
    public void testTransformCapitalLetters() {
        EmailChecker emailChecker = new EmailChecker("LETTER@gmail.com");
        emailChecker.transformCapitalLetters();
        assertEquals(emailChecker.toString(), "letter@gmail.com");
    }
}
