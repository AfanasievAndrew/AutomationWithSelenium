package Enums;

import java.util.HashMap;
import java.util.Map;

public enum PersonalData{
    Surname(1),
    Name(2),
    Middlename(3),
    BirthDate(4),
    PassportSeries(5),
    PassportNumber(6),
    PassportIssueDate(7),
    PassportIssuePlace(8);

    private int number;
    private static Map map = new HashMap<>();

    PersonalData(int i) {
        this.number = i;
    }

    public int getValue() {
        return number;
    }

    static {
        for (PersonalData personalData : PersonalData.values()) {
            map.put(personalData.number, personalData);
        }
    }

    public static PersonalData valueOf(int personalType) {
        return (PersonalData) map.get(personalType);
    }
}
