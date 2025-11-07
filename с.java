import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combinationsCorrect(List<Integer> l, int k) {
        if (k == 0) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;  // Правильный базовый случай
        }
        if (k > l.size()) {
            return new ArrayList<>();  // Невозможно создать сочетание
        }

        List<List<Integer>> comb = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            Integer item = l.get(i);
            List<Integer> remItems = l.subList(i + 1, l.size());  // Элементы после текущего
            List<List<Integer>> remComb = combinationsCorrect(remItems, k - 1);
            for (List<Integer> c : remComb) {
                List<Integer> newComb = new ArrayList<>();
                newComb.add(item);
                newComb.addAll(c);
                comb.add(newComb);
            }
        }
        return comb;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<Integer> inputList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            inputList.add(i);
        }
        List<List<Integer>> result = combinationsCorrect(inputList, k);
        System.out.println(result);  // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
