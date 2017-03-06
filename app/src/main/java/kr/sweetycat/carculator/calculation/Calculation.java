package kr.sweetycat.carculator.calculation;

import java.util.ArrayList;

import kr.sweetycat.carculator.common.Tokenizer;

/**
 * Created by Yi on 2017-03-07.
 */

public class Calculation {
    FindBracket cFindBracket = new FindBracket();
    DivideBracket cDevideBaracket = new DivideBracket();
    Tokenizer cTokenizer = new Tokenizer();
    CalculationBracket cCalculationBracket = new CalculationBracket();

    PrecedenceOfOperators cPrecedenceOfOperators = new PrecedenceOfOperators();

    ArrayList<String> alBracketToken = new ArrayList<String>();

    String sEquation = "";
    public Calculation(String equation) {
        sEquation = equation;
    }

    public String Calculation() {

        System.out.println();
        System.out.println("괄호 수 : " + cFindBracket.FindBracket(sEquation));

        //!< 여기서 괄호를 기점으로 나눈다
        ArrayList<String> alsToken = new ArrayList<String>();

        //!< 괄호가 있는 경우와 없는경우
        if(cFindBracket.FindBracket(sEquation) == -1) {
            //!< 괄호가 없는경우 바로 연산하면 된다.

        }else if(cFindBracket.FindBracket(sEquation) != -1) {
            //!< 괄호가 있는경우 괄호 수만큼 연산후 치환해서 수식을 가져온다.
            cCalculationBracket.CalculationBracket(sEquation);
        }


        return "";
    }


//    public String Cal(String op, String firstVal, String secVal) {
//        Double dResult = 0.00;
//        char[] Operation = op.toCharArray();
//        switch(Operation[0]) {
//            case '+':  dResult = Double.parseDouble(firstVal) + Double.parseDouble(secVal); break;
//            case '-':  dResult = Double.parseDouble(firstVal) - Double.parseDouble(secVal); break;
//            case '×': dResult = Double.parseDouble(firstVal) * Double.parseDouble(secVal); break;
//            case '÷': dResult = Double.parseDouble(firstVal) / Double.parseDouble(secVal); break;
//        }
//        System.out.println("dResult : " + dResult);
//        return Double.toString(dResult);
//    }


}
