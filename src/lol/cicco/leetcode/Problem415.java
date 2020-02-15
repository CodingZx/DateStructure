package lol.cicco.leetcode;

public class Problem415 {

    public String addStrings(String num1, String num2) {
        char[] arr = new char[Math.max(num1.length(), num2.length()) + 1];
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int aIdx = n1.length - 1;
        int bIdx = n2.length - 1;
        int dataIdx = arr.length - 1;

        boolean add = false;
        while (aIdx >= 0 && bIdx >= 0) {
            add = plusValue(n1[aIdx--], n2[bIdx--], add, arr, dataIdx--);
        }
        while(aIdx >= 0) {
            add = plusValue(n1[aIdx--], '0', add, arr, dataIdx--);
        }
        while(bIdx >= 0) {
            add = plusValue(n2[bIdx--], '0', add, arr, dataIdx--);
        }
        if(add) {
            arr[0] = '1';
        } else {
            return new String(arr, 1, arr.length - 1);
        }
        return new String(arr);
    }

    private boolean plusValue(char a, char b, boolean addOne, char[] content, int dataIdx) {
        boolean add = false;
        int sum = convertToInt(a) + convertToInt(b) + (addOne ? 1 : 0);
        if (sum >= 10) {
            sum -= 10;
            add = true;
        }
        content[dataIdx] = (char)(sum + '0');
        return add;
    }

    private static int convertToInt(char value) {
        return value - '0';
    }

}
