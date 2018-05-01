package _251;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Need to handle empty List<Integer>
// For example:
// [[], [], [1, 2, 3], [4, 5], [], [6], []]
public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> vector;
    private int rowPointer;
    private int elementPointer;

    public Vector2D(List<List<Integer>> vec2d) {
        vector = vec2d;
        rowPointer = 0;
        elementPointer = -1;
    }

    @Override
    public Integer next() {
        return vector.get(rowPointer).get(elementPointer);
    }

    @Override
    public boolean hasNext() {
        if (vector.isEmpty())
            return false;

        if (!vector.get(rowPointer).isEmpty() && (elementPointer + 1) < vector.get(rowPointer).size()) {
            elementPointer++;
            return true;
        }

        if (rowPointer + 1 >= vector.size())
            return false;

        int tmp = rowPointer + 1;
        while (tmp < vector.size() && vector.get(tmp).isEmpty())
            tmp++;

        if (tmp >= vector.size())
            return false;

        rowPointer = tmp;
        elementPointer = 0;
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> vector = new ArrayList<>();
        vector.add(Arrays.asList(1, 2));
        vector.add(Arrays.asList(3));
        vector.add(Arrays.asList(4, 5, 6));
        vector.add(new ArrayList<>());
        vector.add(new ArrayList<>());
        Vector2D vector2D = new Vector2D(vector);

        while (vector2D.hasNext())
            System.out.println(vector2D.next());
    }
}
