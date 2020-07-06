package com.codersbay;

import java.util.ArrayList;
import java.util.List;

public class EmailChecker {
    private List<Character> characterList;


    public EmailChecker() {
        characterList = new ArrayList<>();

    }

    public EmailChecker(String toAdd) {
        characterList = new ArrayList<>();
        if (toAdd == null) {
            throw new IllegalArgumentException("No characters in email address!");
        } else {
            this.splitAndAddString(toAdd);
        }
    }


    public void splitAndAddString(String text) {
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            this.characterList.add(c);
        }
    }


    public boolean oneAtExists() {
        for (int i = 0; i < this.characterList.size(); i++) {
            if (this.characterList.get(i).equals('@')) {
                return true;
            }
        }
        return false;
    }


    public boolean stringIsNotEmpty() {
        if (this.characterList.size() > 0) {
            return true;
        }
        return false;
    }


    public boolean stringIsNotNull() {
        if (this.characterList.equals(null)) {
            return false;
        }
        return true;
    }


    public boolean sequentialPeriodsDoNotExist() {
        for (int i = 0; i < this.characterList.size() - 1; i++) {
            if (this.characterList.get(i).equals('.') && this.characterList.get(i + 1).equals('.')) {
                return false;
            }
        }
        return true;
    }

    public boolean fringePeriodsDoNotExist() {
        if (!this.characterList.get(0).equals('.') && !this.characterList.get(this.characterList.size() - 1).equals('.')) {
            return true;
        }
        return false;
    }

    public boolean twoLocalCharsNonPeriod() {

        int characterCount = 0;
        int periodCount = 0;

        for (int i = 0; i < positionOfAt(); i++) {
            if (!this.characterList.get(i).equals('.')) {
                characterCount++;
            } else {
                periodCount++;
            }
        }

        if (characterCount >= 2 && characterCount > periodCount) {
            return true;
        }

        return false;
    }

    public boolean domainPeriodExists() {
        for (int i = positionOfAt() + 1; i < this.characterList.size() - 1; i++) {
            if (this.characterList.get(i).equals('.')) {
                return true;
            }
        }
        return false;
    }

    public boolean minLengthOfHostIsValid() {
        if (!this.characterList.get(positionOfAt() + 1).equals('.')) {
            return true;
        }
        return false;
    }


    public boolean minLengthOfDomainIsValid() {
        List<Integer> periodsInEntireDomain = new ArrayList<>();
        Integer positionOfLastPeriod;

        for (int i = positionOfAt() + 1; i < this.characterList.size() - 1; i++) {
            if (this.characterList.get(i).equals('.')) {
                periodsInEntireDomain.add(i);
            }
        }
        positionOfLastPeriod = periodsInEntireDomain.get(periodsInEntireDomain.size() - 1);

        if ((this.characterList.size() - 1) - (positionOfAt() + 1) - positionOfLastPeriod >= 2) {
            return true;
        }

        return false;
    }

    public boolean maxLengthOfLocalNotExceeded() {

        if (positionOfAt() < 64) {
            return true;
        }

        return false;
    }

    public boolean maxLengthOfEntireDomainNotExceeded() {
        //- der Domain-Teil der Adresse darf maximal 255 zeichen lang sein-

        if ((this.characterList.size() - 1) - (positionOfAt() + 1) <= 255) {
            return true;
        }
        return false;
    }

    public boolean maxLengthOfAddressNotExceeded() {
        //- die gesamte Email-Adresse maximal 320 Zeichen lang sein-
        if (this.characterList.size() <= 320) {
            return true;
        }
        return false;
    }

    public boolean onlyPermittedASCIIFound() {
        for (Character c : this.characterList) {
            if (c > (char) 127) {
                return false;
            }
        }
        return true;
    }

    public boolean noBlankSpaceFound() {
        for (Character c : this.characterList) {
            if (c.equals(' ')) {
                return false;
            }
        }
        return true;
    }

    public void transformCapitalLetters() {
        for (int i = 0; i < this.characterList.size() - 1; i++) {
            Character temp = this.characterList.get(i);

            if (Character.isUpperCase(temp)) {
                temp = Character.toLowerCase(temp);
                this.characterList.set(i, temp);
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (Character c : this.characterList) {
            output += c.toString();
        }
        return output;
    }

    private int positionOfAt() {
        return this.characterList.indexOf('@');
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }


}
