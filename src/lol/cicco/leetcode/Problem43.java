package lol.cicco.leetcode;

public class Problem43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] min = num1.length() > num2.length() ? num2.toCharArray() : num1.toCharArray();
        char[] max = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();

        int[] arr = new int[min.length + max.length];

        for (int minIdx = min.length - 1, start = 0; minIdx >= 0; minIdx--, start++) {
            int sum = 0;
            int arrIdx = arr.length - 1 - start;
            for (int maxIdx = max.length - 1; maxIdx >= 0; maxIdx--) {
                int value = (max[maxIdx] - '0') * (min[minIdx] - '0');
                sum = sum + value + arr[arrIdx];

                arr[arrIdx] = sum % 10;
                sum /= 10;

                arrIdx--;
            }
            if(sum > 0) {
                arr[arrIdx] = sum;
            }
        }

        StringBuilder builder = new StringBuilder(arr.length);
        for(int a : arr) {
            if(a == 0 && builder.length() == 0) {
                continue;
            }
            builder.append(a);
        }
        return builder.toString();
    }

}
