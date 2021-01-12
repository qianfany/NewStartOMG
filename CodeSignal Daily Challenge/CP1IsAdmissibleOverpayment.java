/*
prices = [110, 95, 70]
notes = ["10.0% higher than in-store",
         "5.0% lower than in-store",
         "Same as in-store"]
determine whether the price is over than customer willing to pay more

 */

public class CP1IsAdmissibleOverpayment {
    public boolean isAdmissibleOverpayment (double[] prices, String[] notes, double x) {
        double over = 0.0;
        for (int i = 0; i < prices.length; i++) {
            if (!notes[i].startsWith("S")) {
                String[] np = notes[i].split("%");
                double num = Double.parseDouble(np[0]);
                if (np[1].contains("higher")) {
                    double more = (prices[i] / (100 + num)) * num;
                    over = over + more;
                } else {
                    double less = (prices[i] / (100 - num)) * num;
                    over = over - less;
                }
            }
        }
        return over <= x;
    }

    public static void main (String[] args) {
        double[] prices = {110, 95, 70};
        String[] notes = {
                "10.0% higher than in-store",
                "5.0% lower than in-store",
                "Same as in-store"
        };
        CP1IsAdmissibleOverpayment sol = new CP1IsAdmissibleOverpayment();
        System.out.println(sol.isAdmissibleOverpayment(prices, notes, 5));
    }
}
