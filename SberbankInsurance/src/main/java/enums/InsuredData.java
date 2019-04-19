package enums;

import java.util.HashMap;
import java.util.Map;

public enum InsuredData {
    Name(9),
    Surname(10),
    BirthDate(11);

    private int number;
    private static Map map = new HashMap<>();

    InsuredData(int i) {
        this.number = i;
    }

    public int getValue() {
        return number;
    }

    static {
        for (InsuredData insuredData : InsuredData.values()) {
            map.put(insuredData.number, insuredData);
        }
    }

    public static InsuredData valueOf(int insuredType) {
        return (InsuredData) map.get(insuredType);
    }

    public static boolean isFromEnum(int insuredType) {
        return map.containsKey(insuredType);
    }
}
