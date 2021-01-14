import java.util.*;

public class CP12GroupingDishes {

    public String[][] groupingDishes (String[][] dishes) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] ingredient : dishes) {
            for (int i = 1; i < ingredient.length; i++) {
                if (map.containsKey(ingredient[i])) {
                    List<String> foods = map.get(ingredient[i]);
                    foods.add(ingredient[0]);
                    map.put(ingredient[i], foods);
                } else {
                    List<String> foods = new ArrayList<>();
                    foods.add(ingredient[0]);
                    map.put(ingredient[i], foods);
                }
            }
        }
        List<String[]> list = new ArrayList<>();
        for (String ingredient: map.keySet()) {
            List<String> foods = map.get(ingredient);
            if (foods.size() > 1) {
                Collections.sort(foods);
                String[] fin = new String[foods.size() + 1];
                fin[0] = ingredient;
                for (int i = 0; i < foods.size(); i++) {
                    fin[i+1] = foods.get(i);
                }
                list.add(fin);
            }
        }
        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        return list.toArray(new String[0][]);
    }
}
