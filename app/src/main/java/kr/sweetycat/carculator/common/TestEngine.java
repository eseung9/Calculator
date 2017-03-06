package kr.sweetycat.carculator.common;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Yi on 2017-03-02.
 */

public class TestEngine {
    char [] chOperationCode = {'+', '-', '*', '/', '%', '(', ')'};
    int iEquationIndex = 0;

    public TestEngine() {

    }

    public String precedenceOfOperators(String equation) {
        ArrayList<String> alPostFix = new ArrayList<String>();
        Stack<Character> stOperation = new Stack<Character>();
        Stack<String> stCalculator = new Stack<String>();

        //!< 인자값으로 받아온 식의 길이만큼 for문
        for(int i = 0 ; i < equation.length() ; i++) {
            //!< op코트의 길이만큼 for문
            for(int j = 0 ; j < chOperationCode.length ; j++) {
                //!< equation 문자열과 연산기호 비교
                if(equation.charAt(i) == chOperationCode[j]) {
                    alPostFix.add(equation.substring(iEquationIndex, i).trim().replace("(", "").replace(")", ""));

                    if(equation.charAt(i) == '(') {
                        if(equation.charAt(i) == ')') {
                            while(true) {
                                alPostFix.add(stOperation.pop().toString());

                                if(stOperation.pop() == '(' || stOperation.isEmpty()) {
                                    break;
                                }

                            }
                        }
                    }

                    if(stOperation.isEmpty()) {
                        stOperation.push(chOperationCode[j]);

                    }else {
                        if(opOrder(chOperationCode[j]) > opOrder(stOperation.peek())) {
                            stOperation.push(chOperationCode[j]);
                        }else if (opOrder(chOperationCode[j]) <= opOrder((stOperation.peek()))) {
                            alPostFix.add(stOperation.peek().toString());
                            stOperation.pop();
                            stOperation.push(chOperationCode[j]);

                        }
                    }

                    iEquationIndex = i+1;

                }

                //alPostFix.add(equation.substring(iEquationIndex, i).);
            }
        }

        alPostFix.add(equation.substring(iEquationIndex, equation.length()).trim().replace("(", "").replace(")", ""));

        System.out.println("alPostFix : " + alPostFix);
        System.out.println("stOperation : " + stOperation);
        System.out.println("stCalculator  " + stCalculator);

        if(stOperation.isEmpty()) {
            for(int i = 0 ; i < stOperation.size();) {
                alPostFix.add(stOperation.peek().toString());
                stOperation.pop();

            }
        }

        for(int i = 0 ; i < alPostFix.size() ; i++) {
            if(alPostFix.get(i).equals("")) {
                alPostFix.remove(i);
                i -= 1;

            }else if(alPostFix.get(i).equals("(")) {
                alPostFix.remove(i);
                i -= 1;

            }else if(alPostFix.get(i).equals("(")) {
                alPostFix.remove(i);
                i -= 1;
            }

        }

        stOperation.clear();

        System.out.println("alPostFix : " + alPostFix);
        System.out.println("stOperation : " + stOperation);
        System.out.println("stCalculator  " + stCalculator);


        //!< 후위연산



        return "";
    }

    public static int opOrder(char op) {

        switch (op) {

            case '+':

            case '-':

                return 1;

            case '*':

            case '/':

                return 2;

            case '%':

            default:

                return -1;

        }
    }

}
