package kr.sweetycat.carculator.calculation;

import java.util.ArrayList;

/**
 * Created by Yi on 2017-03-07.
 */

public class DivideBracket {
    public DivideBracket() {

    }

    public ArrayList<String> DivideBracket(String equation) {
        ArrayList<String> alBracketToken = new ArrayList<String>();
        alBracketToken.add(equation.substring(0, equation.lastIndexOf("(")));
        alBracketToken.add(equation.substring(equation.lastIndexOf("(")+1, equation.indexOf(")")));
        alBracketToken.add(equation.substring(equation.indexOf(")")+1));

        return alBracketToken;
    }

}
