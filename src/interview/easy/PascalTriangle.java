package interview.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }

        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            List<List<Integer>> result = new ArrayList<>();
            result.add(list);

            return result;
        }

        List<List<Integer>> remains = generate(numRows - 1);
        List<Integer> lastOne = remains.get(remains.size() - 1);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lastOne.size() - 1; i++) {
            list.add(lastOne.get(i) + lastOne.get(i + 1));
        }
        list.add(0, 1);
        list.add(list.size(), 1);
        result.addAll(remains);
        result.add(list);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(1));
        System.out.println(new PascalTriangle().generate(2));
        System.out.println(new PascalTriangle().generate(3));
        System.out.println(new PascalTriangle().generate(4));
        System.out.println(new PascalTriangle().generate(5));
        System.out.println(new PascalTriangle().generate(6));
    }
}
