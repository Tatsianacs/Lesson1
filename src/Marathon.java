import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Marathon {

    public Map<String, Integer> createHashMap(String[] namesArray, Integer[] timesArray) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < namesArray.length; i++) {
            map.put(namesArray[i], timesArray[i]);
        }
        Map<String, Integer> sortedMap = sortByValue(map);
        return sortedMap;
    }

    private Map<String, Integer> sortByValue(HashMap<String, Integer> mapToBeSorted) {
        Map<String, Integer> sorted = mapToBeSorted
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));
        return sorted;
    }

    public String getParticipantInfo(int place, Map<String, Integer> map) {
        if (place > map.size()) {
            return "No such participant";
        } else {
            Object nameOfParticipant = map.keySet().toArray()[map.size() - place];
            Object timeOfParticipant = map.get(nameOfParticipant);
            return nameOfParticipant + " " + timeOfParticipant;
        }
    }
}
