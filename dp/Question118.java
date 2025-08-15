package dp;

import doublePointer.Question11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>(Collections.nCopies(i + 1, 1)));
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> thisRow = result.get(i);
            List<Integer> lastRow = null;
            if (i > 0) {
                lastRow = result.get(i - 1);
            }
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    thisRow.set(j, 1);
                } else {
                    thisRow.set(j, lastRow.get(j - 1) + lastRow.get(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Question118().generate(5));
    }
}
