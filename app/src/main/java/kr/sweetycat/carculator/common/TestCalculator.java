package kr.sweetycat.carculator.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yi on 2017-03-06.
 */

public class TestCalculator {
    Tokenizer cTokenizer;
    ArrayList<String> alCalculatorTokenizer = new ArrayList<String>();

    public TestCalculator(){
        cTokenizer = new Tokenizer();
    }

    public void CalculatorTokenizer(String equation) {
        equation = equation.replace("(-", "&");

        //!< 문자열의 길이만큼 반복문을 돈다.
        for(int i = 0 ; i < equation.length()-1 ; i++) {
            if(equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '×' || equation.charAt(i) == '÷') {

            }
        }

    }

    public void calculatorBracketTokenizer(String equation) {
        ArrayList<String> alBracketTokenTemp = new ArrayList<String>();
        Queue<Double> qBracketCalculation = new LinkedList<Double>();

        System.out.println("equation : " + equation);
        cTokenizer = new Tokenizer();
        int iBracketCount = cTokenizer.TokenizerCount(equation, "\\(");
        System.out.println("BC : " + iBracketCount);
        System.out.println("equation.lastIndexOf : " + equation.lastIndexOf("("));

        //!< 카운트 수만큼
        for(int i = 0 ; i < iBracketCount ; i++) {
            alBracketTokenTemp.add(equation.substring(0, equation.lastIndexOf("(")));
            alBracketTokenTemp.add(equation.substring(equation.lastIndexOf("(")+1, equation.indexOf(")")));
            alBracketTokenTemp.add(equation.substring(equation.indexOf(")")+1));
            System.out.println("alBracketTokenTemp : " + alBracketTokenTemp);

            //!< 괄호에있던 값을 넣는다.
            //System.out.println("Result : " + Calculation(divisionEquation(alBracketTokenTemp.get(1))));
            //Calculation(divisionEquation(alBracketTokenTemp.get(1)));



        }

    }

    public String Calculation(ArrayList<String> equation) {
        System.out.println("Cal - equation : " + equation);
        //int iPosition = 0 ;
        String sResultTemp ;
        cTokenizer = new Tokenizer();
        ArrayList<Integer> alOperationMultplyDivisionPosition = new ArrayList<Integer>();
        ArrayList<Integer> alOperationPlusMinusPosition = new ArrayList<Integer>();

        //!< eqation값에 있는 부호의 갯수만큼 for문을 돈다.
        System.out.println("cTokenizer.TokenizerCount : " + cTokenizer.TokenizerCount(equation, "\\+|\\-|\\×|\\÷"));
//        for(int i = 0 ; i < cTokenizer.TokenizerCount(equation, "\\+|\\-|\\×|\\÷") ; i++) {
        for(int i = 0 ; i < 2 ; i++) {
            System.out.println("for in (i) : " + i);
            int iMDPosition = 0;
            int iPMPosition = 0;

            alOperationMultplyDivisionPosition.add(equation.indexOf("×"));
            alOperationMultplyDivisionPosition.add(equation.indexOf("÷"));
            iMDPosition = Collections.min(alOperationMultplyDivisionPosition);
            System.out.println("iMDPos : " + iMDPosition);

            alOperationPlusMinusPosition.add(equation.indexOf("+"));
            alOperationPlusMinusPosition.add(equation.indexOf("-"));
            iPMPosition = Collections.min(alOperationPlusMinusPosition);
            System.out.println("iPMPos : " + iPMPosition);

            if(iMDPosition != -1) {
                System.out.println("iPMPos in() ");
                sResultTemp = Cal(equation.get(iMDPosition), equation.get(iMDPosition-1), equation.get(iMDPosition+1));
                for(int j = 0 ; j <  3 ; j++) {
                    equation.remove(iMDPosition - 1);
                    System.out.println("remove equation : " + equation);
                }

                equation.add(iMDPosition-1, sResultTemp);
                System.out.println("Cal - equation : " + equation);
            }else if(iMDPosition == -1) {
                System.out.println("iMDPos in() ");
                sResultTemp = Cal(equation.get(iPMPosition), equation.get(iPMPosition-1), equation.get(iPMPosition+1));
                for(int j = 0 ; j <  3 ; j++) {
                    equation.remove(iMDPosition - 1);
                    System.out.println("remove equation : " + equation);
                }

                equation.add(iPMPosition-1, sResultTemp);
                System.out.println("Cal - equation : " + equation);
            }
            alOperationMultplyDivisionPosition.clear();
            alOperationPlusMinusPosition.clear();


        }

        return equation.get(0);
    }

    public String Cal(String op, String firstVal, String secVal) {
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

    //!< 식을 Operation 과 숫자로 나눈다.
    public ArrayList<String> divisionEquation(String equation) {
        ArrayList<String> alDivisionEqiation = new ArrayList<String>();
        ArrayList<Integer> alOperationPosition = new ArrayList<Integer>();
        cTokenizer = new Tokenizer();

        //!< 문자열의 맨 앞에 '-'부호가 있으면 제거해준다.
        //!< 제거해준 '-'부호는 Arr의 0번에 마지막에 추가해준다.
        boolean bFirstPositionMinusSign = false;
        if(equation.charAt(0) == '-') {
            equation = equation.replaceFirst("-", "");
            System.out.println("dE : " + equation);
            bFirstPositionMinusSign = true;
        }

        //!< 가져온 식의 Op위치를 TokenizerPosition함수를 통해 리턴받아 alOperationPosition에 세팅
        alOperationPosition = cTokenizer.TokenizerPosition(equation, "\\+|\\-|\\×|\\÷");
        System.out.println("position : " + alOperationPosition);
        System.out.println("alOperationPosition Size : " + alOperationPosition.size());

        //!< Op의 갯수만큼 for문을 역순으로 돈다.
        //!< Op갯수 + 1 만큼 나누어진다.
        for(int i = alOperationPosition.size()-1 ; i >= 0 ; i--) {
            //!< 맨 끝의 Op위치 다음에 존재하는 숫자를 가져온다.
            alDivisionEqiation.add(equation.substring(alOperationPosition.get(i)+1));
            System.out.println("alDivisionEqiation : " + alDivisionEqiation);

            //!!< 맨 끝 Op를 가져온다.
            alDivisionEqiation.add(equation.substring(alOperationPosition.get(i) ,alOperationPosition.get(i)+1));
            System.out.println("alDivisionEqiation : " + alDivisionEqiation);

            //!< for문의 마지막일 경우 더이상 자를 필요가 없으므로 리스트에 추가한다.
            if(i != 0) {
                equation = equation.substring(0, alOperationPosition.get(i));
                System.out.println("equation : " + equation);
            }else if(i == 0) {
                alDivisionEqiation.add(equation.substring(0, alOperationPosition.get(i)));
                System.out.println("equation : " + equation);
            }

            System.out.println("alDivisionEqiation : " + alDivisionEqiation);

        }

        //!< 역순으로 들어가있는 리스트를 원래대로 돌린다.
        Collections.reverse(alDivisionEqiation);
        System.out.println("alDivisionEqiation : " + alDivisionEqiation);

        //!< 문자열 시작 당시 부호가 마이너스인경우 0번째칸에 부호 추가
        if(bFirstPositionMinusSign) {
            alDivisionEqiation.set(0, '-' + alDivisionEqiation.get(0));
            System.out.println("alDivisionEqiation : " + alDivisionEqiation);
        }

        //!< 완료된 리스트를 리턴
        return alDivisionEqiation;

    }

}
