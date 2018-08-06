package com.machikoro.game.logic.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameGenerator {
    private static final String[] NAMES_ARRAY = new String[] {
        "Oliver", "George", "Harry", "Jack", "Jacob", "Noah", "Charlie",
        "Muhammad", "Thomas", "Oscar", "William", "James"
    };
    private static ArrayList<String> NAMES = new ArrayList<String>(Arrays.asList(NAMES_ARRAY));

    public static String extractRandomName() {
        int randomIndex = Math.round((float)Math.random()*(NAMES.size()-1));
        String name = NAMES.get(randomIndex);
        NAMES.remove(randomIndex);
        return name;
    }

    public static void returnNameToList(String name) {
        NAMES.add(name);
    }


}
