package lol.cicco.leetcode;

public class Problem67 {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;

        StringBuilder answer = new StringBuilder();

        boolean addOne = false;
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        while (aIdx >= 0 && bIdx >= 0) {

            int binA = a.charAt(aIdx) == '0' ? 0 : 1;
            int binB = b.charAt(bIdx) == '0' ? 0 : 1;

            int sum = binA + binB + (addOne ? 1 : 0);
            addOne = sum >= 2;

            answer.append(toBinary(sum));

            --aIdx;
            --bIdx;
        }
        while (aIdx >= 0) {
            int bin = a.charAt(aIdx--) == '0' ? 0 : 1;
            int sum = bin + (addOne ? 1 : 0);
            addOne = sum >= 2;

            answer.append(toBinary(sum));
        }

        while (bIdx >= 0) {
            int bin = b.charAt(bIdx--) == '0' ? 0 : 1;
            int sum = bin + (addOne ? 1 : 0);
            addOne = sum >= 2;

            answer.append(toBinary(sum));
        }

        if (addOne) {
            answer.append(1);
        }
        return answer.reverse().toString();
    }

    private int toBinary(int sum) {
        switch (sum) {
            case 0:
            case 2:
                return 0;
            case 1:
            case 3:
                return 1;
        }
        return -1;
    }
}
