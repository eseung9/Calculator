package kr.sweetycat.carculator.calculation;

import java.util.ArrayList;
import java.util.Collections;
import kr.sweetycat.carculator.common.Tokenizer;

/**
 * Created by Yi on 2017-03-07.
 */

public class DivideEquation {


    public DivideEquation(){}

    public ArrayList<String> divisionEquation(String equation) {
        Tokenizer cTokenizer = new Tokenizer();
        ArrayList<String> alDivisionEqiation = new ArrayList<String>();
        ArrayList<Integer> alOperationPosition = new ArrayList<Integer>();

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
