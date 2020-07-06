package com.codersbay;

public class Main {

    public static void main(String[] args) {
        EmailChecker emailChecker1 = new EmailChecker("te@t.est.com");

        System.out.println(emailChecker1.toString());
        emailChecker1.transformCapitalLetters();
        System.out.println("Set all letters to lowercase.");
        System.out.println("Address has an @ sign: " + emailChecker1.oneAtExists());
        System.out.println("Address is not empty: " + emailChecker1.stringIsNotEmpty());
        System.out.println("Address is not NULL: " + emailChecker1.stringIsNotNull());
        System.out.println("There are no two periods right after another: " + emailChecker1.sequentialPeriodsDoNotExist());
        System.out.println("Address is free of surrounding periods: " + emailChecker1.stringIsNotNull());
        System.out.println("Local section reaches minimum length: " + emailChecker1.twoLocalCharsNonPeriod());
        System.out.println("Host and Top Level Domain are separated by a period: " + emailChecker1.domainPeriodExists());
        System.out.println("Host name reaches minimum length: " + emailChecker1.minLengthOfHostIsValid());
        System.out.println("Domain name reaches minimum length: " + emailChecker1.minLengthOfDomainIsValid());
        System.out.println("Local section is not too long: " + emailChecker1.maxLengthOfLocalNotExceeded());
        System.out.println("Domain is not too long: " + emailChecker1.maxLengthOfEntireDomainNotExceeded());
        System.out.println("Address is not too long: " + emailChecker1.maxLengthOfAddressNotExceeded());
        System.out.println("Only permitted ASCII signs found: " + emailChecker1.onlyPermittedASCIIFound());
        System.out.println("No blank spaces found:" + emailChecker1.noBlankSpaceFound());


    }







}
