class Solution {
    public String fractionAddition(String expression) {
        List<Integer> denominators = new ArrayList<>();
        List<Integer> numerators = new ArrayList<>();
        
        // Parsing the expression properly
        int i = 0;
        while (i < expression.length()) {
            int sign = 1;
            if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (expression.charAt(i) == '+') {
                i++;
            }

            int numerator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                numerator = numerator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            numerator *= sign;

            i++; // Skip the '/'

            int denominator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                denominator = denominator * 10 + (expression.charAt(i) - '0');
                i++;
            }

            numerators.add(numerator);
            denominators.add(denominator);
        }

        // Finding the least common denominator (LCM)
        int lcm = lcm_of_array(denominators);
        
        // Converting each fraction to have the same denominator and summing up the numerators
        int sumNumerator = 0;
        for (int j = 0; j < numerators.size(); j++) {
            sumNumerator += numerators.get(j) * (lcm / denominators.get(j));
        }

        if (sumNumerator == 0) {
            return "0/1";
        } else {
            int gcd = gcd(Math.abs(sumNumerator), lcm);
            sumNumerator /= gcd;
            lcm /= gcd;

            if (lcm < 0) {
                sumNumerator = -sumNumerator;
                lcm = -lcm;
            }

            return sumNumerator + "/" + lcm;
        }
    }

    public static int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }

    public static int lcm_of_array(List<Integer> arr) {
        int lcm = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int gcd_val = gcd(lcm, arr.get(i));
            lcm = (lcm * arr.get(i)) / gcd_val;
        }
        return lcm;
    }
}
