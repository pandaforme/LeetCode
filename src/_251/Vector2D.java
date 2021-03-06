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
    private int row;
    private int column;

    public Vector2D(List<List<Integer>> vec2d) {
        vector = vec2d;
        while (row < vector.size() && vector.get(row).isEmpty()) {
            row++;
        }

        column = -1;
    }

    @Override
    public Integer next() {
        return vector.get(row).get(column);
    }

    @Override
    public boolean hasNext() {
        if (vector == null || vector.isEmpty())
            return false;

        if (row >= vector.size())
            return false;

        if (column + 1 >= vector.get(row).size() && row + 1 >= vector.size())
            return false;

        if (column + 1 >= vector.get(row).size()) {
            do {
                row++;
            }
            while (row < vector.size() && vector.get(row).isEmpty());

            if (row >= vector.size())
                return false;

            column = 0;
        } else {
            column++;
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> vector = new ArrayList<>();
        vector.add(new ArrayList<>());
        vector.add(new ArrayList<>());
        vector.add(Arrays.asList(1, 2));
        vector.add(Arrays.asList(3));
        vector.add(new ArrayList<>());
        vector.add(new ArrayList<>());
        vector.add(Arrays.asList(4, 5, 6));
        vector.add(new ArrayList<>());
        vector.add(new ArrayList<>());
        Vector2D vector2D = new Vector2D(vector);

        while (vector2D.hasNext())
            System.out.println(vector2D.next());
    }
}
