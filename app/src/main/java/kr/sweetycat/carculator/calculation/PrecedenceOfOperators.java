package kr.sweetycat.carculator.calculation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Yi on 2017-03-07.
 */

public class PrecedenceOfOperators {
    public PrecedenceOfOperators(){

    }

    public int PrecedenceOfOperators(ArrayList<String> alsEquation) {
        //!< 곱하기 나누기가 있으면 해당 위치를 리턴하고 없으면 플마 위치 찾아서 리턴
        ArrayList<Integer> alOperatorsPosition = new ArrayList<Integer>();

        if(alsEquation.contains("×") || alsEquation.contains("÷")) {
            alOperatorsPosition.add(alsEquation.indexOf("×"));
            alOperatorsPosition.add(alsEquation.indexOf("÷"));
            System.out.println(alOperatorsPosition);

            if(alOperatorsPosition.contains(-1))
                alOperatorsPosition.remove(alOperatorsPosition.indexOf(-1));

            return Collections.min(alOperatorsPosition);

        }else if(alsEquation.contains("+") || alsEquation.contains("-")){
            alOperatorsPosition.add(alsEquation.indexOf("+"));
            alOperatorsPosition.add(alsEquation.indexOf("-"));
            System.out.println(alOperatorsPosition);

            if(alOperatorsPosition.contains(-1))
                alOperatorsPosition.remove(alOperatorsPosition.indexOf(-1));

            return Collections.min(alOperatorsPosition);
        }else {
            return 0;
        }


    }
}
