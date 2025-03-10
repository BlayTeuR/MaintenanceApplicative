package trivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Questions {

    private static final List<String> CATEGORIES = List.of("Pop", "Science", "Sports", "Rock");
    private final Map<String, LinkedList<String>> questionsByCategory = new HashMap<>();

    public Questions() {
        for (String c : CATEGORIES) {
            questionsByCategory.put(c, new LinkedList<>());
        }
        for (int i = 0; i < 50; i++) {
            questionsByCategory.get("Pop").add("Pop Question " + i);
            questionsByCategory.get("Science").add("Science Question " + i);
            questionsByCategory.get("Sports").add("Sports Question " + i);
            questionsByCategory.get("Rock").add("Rock Question " + i);
        }
    }

    public String getNextQuestion(String category) {
        LinkedList<String> queue = questionsByCategory.get(category);
        return queue.removeFirst();
    }

    public static List<String> getCategories() {
        return CATEGORIES;
    }
}
