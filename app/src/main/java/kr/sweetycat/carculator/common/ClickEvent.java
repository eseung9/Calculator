package kr.sweetycat.carculator.common;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import kr.sweetycat.carculator.R;
import kr.sweetycat.carculator.calculation.Calculation;
import kr.sweetycat.carculator.main.SetTextView;

/**
 * Created by Yi on 2017-02-28.
 */

public class ClickEvent {
    static final int DEF_PLUS = 0;
    static final int DEF_MINUS = 1;
    static final int DEF_MULTFLY = 2;
    static final int DEF_DEVISION = 3;

    private Activity aClickEvent;
    CalculatorEngine cCalculatorEngine;
    SetTextView cSetTextView;

    public ClickEvent(Activity activity) {
        aClickEvent = activity;
        cCalculatorEngine = new CalculatorEngine();
        cSetTextView = new SetTextView(aClickEvent);

    }

    public void ClickTool(View v) {
        switch(v.getId()) {
            case R.id.idImgBtn_Copy:

                break;

            case R.id.idImgBtn_Back:
                deleteLastChar();

                break;

            case R.id.idImgBtn_Clear:
                Define.ins().sResult= "";
                Define.ins().sEquation = "";
                TextView tvResult = (TextView)aClickEvent.findViewById(R.id.idTV_Result);
                tvResult.setText(Define.ins().sResult);

                break;
        }
    }

    public void ClickSign(View v) {
        switch(v.getId()) {
            case R.id.idImgBtn_Plus:
                Define.ins().sEquation += "+";

                break;

            case R.id.idImgBtn_Minus:
                Define.ins().sEquation += "-";

                break;

            case R.id.idImgBtn_Multiply:
                Define.ins().sEquation += "×";

                break;

            case R.id.idImgBtn_Division:
                Define.ins().sEquation += "÷";

                break;

            case R.id.idImgBtn_Equals:
//                Define.ins().sEquation += "=" ;
                System.out.println("Equals-Equation : " + Define.ins().sEquation);
//                TestCalculator tc = new TestCalculator();
//                tc.calculatorBracketTokenizer(Define.ins().sEquation);
                Calculation cCalculation = new Calculation(Define.ins().sEquation);
                cCalculation.Calculation();
                break;

            case R.id.idImgBtn_Persent:
                Define.ins().sEquation += "%";

                break;

            case R.id.idImgBtn_StartBrackets:
                if(Define.ins().sEquation.equals("")||
                   Define.ins().sEquation.charAt(Define.ins().sEquation.length()-1) == '+' ||
                   Define.ins().sEquation.charAt(Define.ins().sEquation.length()-1) == '-' ||
                   Define.ins().sEquation.charAt(Define.ins().sEquation.length()-1) == '×' ||
                   Define.ins().sEquation.charAt(Define.ins().sEquation.length()-1) == '÷' ) {
                    Define.ins().sEquation += "(";

                }else {
                    Define.ins().sEquation += "×(";
                }

                break;

            case R.id.idImgBtn_EndBrackets:
                Define.ins().sEquation += ")";

                break;

            case R.id.idImgBtn_Period:
                Define.ins().sEquation += ".";

                break;

            case R.id.idImgBtn_PlusMinusSign:
                String sEquationTemp = Define.ins().sEquation.replace("(-", "&");
                System.out.println("sEquatopmTemp : " + sEquationTemp);
                int iPlusMinusPosition = sEquationTemp.lastIndexOf("&");
                System.out.println("iPlusMinusPosition : " + iPlusMinusPosition);

                //!< 부호의 위치를 반환하기 위한 부분
                ArrayList<Integer> alOperationIndexValue = new ArrayList<Integer>();
                alOperationIndexValue.add(sEquationTemp.lastIndexOf("+"));
                alOperationIndexValue.add(sEquationTemp.lastIndexOf("-"));
                alOperationIndexValue.add(sEquationTemp.lastIndexOf("×"));
                alOperationIndexValue.add(sEquationTemp.lastIndexOf("÷"));
                System.out.println("위치반환 : " + Collections.max(alOperationIndexValue));

                if(Collections.max(alOperationIndexValue) != -1 && !sEquationTemp.contains("&")) {
                    System.out.println("2");
                    ArrayList<String> alEquationTemp = new ArrayList<String>();
                    alEquationTemp.add(sEquationTemp.substring(0, Collections.max(alOperationIndexValue)+1));
                    alEquationTemp.add(sEquationTemp.substring(Collections.max(alOperationIndexValue)+1));
                    System.out.println("in() alEquationTemp : " + alEquationTemp.toString());

                    sEquationTemp = alEquationTemp.get(0) + "(-" + alEquationTemp.get(1);
                    Define.ins().sEquation = sEquationTemp;

                }

                //!< 중간에 부호가 있을경우 삭제
                if(Collections.max(alOperationIndexValue) != -1 && sEquationTemp.contains("&")) {
                    System.out.println("1");
                    ArrayList<String> alEquationTemp = new ArrayList<String>();
                    alEquationTemp.add(sEquationTemp.substring(0, Collections.max(alOperationIndexValue)+1));
                    alEquationTemp.add(sEquationTemp.substring(Collections.max(alOperationIndexValue)+1, Collections.max(alOperationIndexValue) + 2));
                    alEquationTemp.add(sEquationTemp.substring(Collections.max(alOperationIndexValue) + 2));
                    System.out.println("in() alEquationTemp : " + alEquationTemp.toString());

                    sEquationTemp = alEquationTemp.get(0) + alEquationTemp.get(2);
                    Define.ins().sEquation = sEquationTemp;


                }

                if(Collections.max(alOperationIndexValue) == -1 && !sEquationTemp.contains("&")) {
                    System.out.println("3");
                    Define.ins().sEquation = "(-" + Define.ins().sEquation;
                    System.out.println("숫자만 있을 때 in()...");
                }

                //!< 숫자만 있을때 삭제
                if(Collections.max(alOperationIndexValue) == -1 && sEquationTemp.contains("&")) {
                    System.out.println("4");
                    Define.ins().sEquation = Define.ins().sEquation.replace("(-", "");
                    System.out.println("숫자만 있을 때 out()...");
                }

                break;
        }

    }

    public void ClickNumber(View v) {
        switch(v.getId()) {
            case R.id.idImgBtn_0:
                Define.ins().sEquation += 0;

                break;

            case R.id.idImgBtn_1:
                Define.ins().sEquation += 1;

                break;

            case R.id.idImgBtn_2:
                Define.ins().sEquation += 2;

                break;

            case R.id.idImgBtn_3:
                Define.ins().sEquation += 3;

                break;

            case R.id.idImgBtn_4:
                Define.ins().sEquation += 4;

                break;

            case R.id.idImgBtn_5:
                Define.ins().sEquation += 5;

                break;

            case R.id.idImgBtn_6:
                Define.ins().sEquation += 6;

                break;

            case R.id.idImgBtn_7:
                Define.ins().sEquation += 7;

                break;

            case R.id.idImgBtn_8:
                Define.ins().sEquation += 8;

                break;

            case R.id.idImgBtn_9:
                Define.ins().sEquation += 9;

                break;

        }

    }


    public String deleteLastChar() {
        if(!Define.ins().sEquation.equals("")) {
            return Define.ins().sEquation = Define.ins().sEquation.substring(0, Define.ins().sEquation.length() - 1);
        }else{
            return Define.ins().sEquation = "";
        }

    }

}
