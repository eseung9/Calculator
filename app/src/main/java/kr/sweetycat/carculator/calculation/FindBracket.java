package kr.sweetycat.carculator.calculation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import kr.sweetycat.carculator.common.Tokenizer;

/**
 * Created by Yi on 2017-03-07.
 */

public class FindBracket {
    Tokenizer cTokenizer;
    public FindBracket() {}
    /**
     * 식에 괄호가 있는지 확인한다.
     * 괄호가 있으면 열린 괄호의 갯수와 닫힌 괄호의 갯수가 동인한지 확인
     * 갯수가 동일하지 않으면 -1 리턴
     * @param equation
     * @return 괄호갯수
     */
    public int FindBracket(String equation) {
        ArrayList<String> alBracketTokenTemp = new ArrayList<String>();

        System.out.println("equation : " + equation);
        cTokenizer = new Tokenizer();
        int iStartBracketCount = cTokenizer.TokenizerCount(equation, "\\(");
        int iEndBracketCount = cTokenizer.TokenizerCount(equation, "\\)");

        if(iStartBracketCount == iEndBracketCount) {
            return iStartBracketCount;
        }else {
            return -1;
        }

    }
}
