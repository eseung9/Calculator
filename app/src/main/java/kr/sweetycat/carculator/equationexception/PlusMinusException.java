package kr.sweetycat.carculator.equationexception;

import java.util.ArrayList;
import java.util.Collections;

import kr.sweetycat.carculator.common.Define;

/**
 * Created by Yi on 2017-03-05.
 */

public class PlusMinusException {

//    static final int DEF_PLUS = 0;
//    static final int DEF_MINUS = 1;
//    static final int DEF_MULTFLY = 2;
//    static final int DEF_DEVISION = 3;
//
//
//    public PlusMinusException() {}
//
//    public void PlusMinusException() {
//        //!< 부호의 위치를 반환하기 위한 부분
//        ArrayList<Integer> alOperationIndexValue = new ArrayList<Integer>();
//        alOperationIndexValue.add(Define.ins().sEquation.lastIndexOf("+"));
//        alOperationIndexValue.add(Define.ins().sEquation.lastIndexOf("-"));
//        alOperationIndexValue.add(Define.ins().sEquation.lastIndexOf("×"));
//        alOperationIndexValue.add(Define.ins().sEquation.lastIndexOf("÷"));
//        System.out.println("위치반환 : " + Collections.max(alOperationIndexValue));
//
//        //!< 문자열이 비어있는 상태에서 눌렸을 때
//        if(Define.ins().sEquation.equals("")) {
//            Define.ins().sEquation += "(-";
//        }else if(Define.ins().sEquation.equals("(-")) {
//            Define.ins().sEquation = "";
//        }
//
//        //!< 문자열에 부호가 없고 숫자만 1개 있을 때
//        if(alOperationIndexValue.get(DEF_PLUS).equals(-1) && alOperationIndexValue.get(DEF_MINUS).equals(-1) && alOperationIndexValue.get(DEF_MULTFLY).equals(-1) && alOperationIndexValue.get(DEF_DEVISION).equals(-1)) {
//            Define.ins().sEquation = "(-" + Define.ins().sEquation;
//
//        }
//
//        if(Define.ins().sEquation.indexOf("(-") == 0) {
//            Define.ins().sEquation = Define.ins().sEquation.replace("(-", "");
//        }
//
//
//
//    }

}
