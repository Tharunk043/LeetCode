class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int prevUpper = 0;

        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];

            if (income > prevUpper) {
                int taxable = Math.min(income, upper) - prevUpper;
                tax += taxable * percent / 100.0;
            } else {
                break;
            }

            prevUpper = upper;
        }

        return tax;
    }
}
