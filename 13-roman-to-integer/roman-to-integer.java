class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = 0;
            char c = s.charAt(i);

            if (c == 'I') current = 1;
            else if (c == 'V') current = 5;
            else if (c == 'X') current = 10;
            else if (c == 'L') current = 50;
            else if (c == 'C') current = 100;
            else if (c == 'D') current = 500;
            else if (c == 'M') current = 1000;

            if (current < prev) {
                total -= current;
            } else {
                total += current;
            }

            prev = current;
        }

        return total;
    }
}
