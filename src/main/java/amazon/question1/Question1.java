package amazon.question1;

import java.util.*;

public class Question1 {


    static List<String> retrieveMostFrequentlyUsedWords(String helpText,
                                                        List<String> wordsToExclude)
    {
//        create result list
        ArrayList<String> resultList = new ArrayList<>();

//        trim list
        List<String> filteredList = trimFilteredList(wordsToExclude);

//        if helpText is empty return
        if( helpText.length() == 0)
            return resultList;

//         cleanup string using regex
        String lowerCaseHelpText = helpText.toLowerCase()
                .replaceAll("\\W", " ");

//        create dictionary of words using exclude list
        Map<String, Integer> map = createDictionary(filteredList, lowerCaseHelpText);

//        Sort entries by values
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

//        get top entry value
        Iterator<Map.Entry<String, Integer>> iterator = reverseSortedMap.entrySet().iterator();
        if( reverseSortedMap.size() == 0)
            return resultList;

        Map.Entry<String, Integer> topEntry = iterator.next();
        Integer max = topEntry.getValue();
        resultList.add(topEntry.getKey());

//        get top elements
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if (next.getValue().equals(max)) {
                resultList.add(next.getKey());
            } else {
                break;
            }
        }
//      return result list
        return resultList;
    }

    private static List<String> trimFilteredList(List<String> wordsToExclude) {
        List<String> filteredList = new ArrayList<>();
        for (String word : wordsToExclude) {
            String s = word.replaceAll("\\W", " ");
            String[] split = s.split(" ");
            filteredList.addAll(Arrays.asList(split));
        }
        return filteredList;
    }

    private static Map<String, Integer> createDictionary(List<String> wordsToExclude, String lowerCaseHelpText) {

        // create HashMap
        Map<String, Integer> map = new HashMap<>();

        String[] words = lowerCaseHelpText.split(" ");

        for (String s: words) {
            if(!wordsToExclude.contains(s)) {
                if(map.containsKey(s)) {
                    Integer val = map.get(s);
                    map.put(s, val+1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        return map;
    }
}

