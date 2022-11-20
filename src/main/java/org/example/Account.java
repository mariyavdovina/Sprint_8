package org.example;

public class Account {
    private final String name;
    public Account(String name) {
        this.name = name;
    }
    public boolean checkNameToEmboss() {
        boolean length = name.length() >= 3 && name.length() <= 19;
        int count = 0;
        for (int i = 0; i < name.length() ; i++) {
            if (name.charAt(i) == ' ') {
                count++;
            }
        }
        boolean hasOneBlank = (count == 1);
        boolean blankPosition = !name.startsWith(" ") && !name.endsWith(" ");
        return length && hasOneBlank && blankPosition;
    }

}
