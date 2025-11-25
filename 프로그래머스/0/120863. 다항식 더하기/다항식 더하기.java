public class Solution {
    public String solution(String polynomial) {
        int xCoef = 0;
        int constCoef = 0;

        for (String s : polynomial.split(" ")) {
            if (s.equals("+")) continue;

            if (s.contains("x")) {
                String coef = s.replace("x", "");
                if (coef.equals("")) coef = "1";
                xCoef += Integer.parseInt(coef);
            } else {
                constCoef += Integer.parseInt(s);
            }
        }

        if (xCoef != 0 && constCoef != 0) {
            return (xCoef == 1 ? "x" : xCoef + "x") + " + " + constCoef;
        } else if (xCoef != 0) {
            return (xCoef == 1 ? "x" : xCoef + "x");
        } else {
            return String.valueOf(constCoef);
        }
    }
}
