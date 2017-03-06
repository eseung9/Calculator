package kr.sweetycat.carculator.calculation;

/**
 * Created by Yi on 2017-03-07.
 */

public class RealCalculation {
    public RealCalculation() {}

    public String RealCalculation(String op, String firstVal, String secVal) {
        Double dResult = 0.00;
        char[] Operation = op.toCharArray();
        switch(Operation[0]) {
            case '+':  dResult = Double.parseDouble(firstVal) + Double.parseDouble(secVal); break;
            case '-':  dResult = Double.parseDouble(firstVal) - Double.parseDouble(secVal); break;
            case '×': dResult = Double.parseDouble(firstVal) * Double.parseDouble(secVal); break;
            case '÷': dResult = Double.parseDouble(firstVal) / Double.parseDouble(secVal); break;
        }
        System.out.println("dResult : " + dResult);
        return Double.toString(dResult);
    }
}
