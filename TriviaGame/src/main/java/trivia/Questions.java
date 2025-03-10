package trivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Questions {

    Map<String, ArrayList<String>> categories = new HashMap<>();
    public Questions(){
        categories.put("POP", new ArrayList<>());
        categories.put("Science", new ArrayList<>());
        categories.put("Sports", new ArrayList<>());
        categories.put("Rock", new ArrayList<>());
    }
}
