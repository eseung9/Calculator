package kr.sweetycat.carculator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.Queue;

import kr.sweetycat.carculator.R;
import kr.sweetycat.carculator.common.Calculator;
import kr.sweetycat.carculator.common.CalculatorEngine;
import kr.sweetycat.carculator.common.CalculatorEngineTest;
import kr.sweetycat.carculator.common.ClickEvent;
import kr.sweetycat.carculator.common.TestEngine;
import kr.sweetycat.carculator.main.Main;
import kr.sweetycat.carculator.main.SetTextView;


public class MainActivity extends Activity {

    ClickEvent cClickEvent;
    SetTextView cSetTextView;
    Main cMain;

    TestEngine cTestEngine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        cClickEvent = new ClickEvent(this);
        cSetTextView = new SetTextView(this);
        cMain = new Main(this);

        cMain.ChangeFont();

//        cCalculatorEngine = new CalculatorEngine();

//        cTestEngine.precedenceOfOperators("1.3+2*(3.1-2.7)");
//        System.out.println("result : " + cCalculatorEngineTest.getCalculate("1.3+2*(3.1-2.7)"));

//      System.out.println("Result" + cCalculatorEngineTest.getCalculate("1+2*3/2+(2*3)-(10/(10-(5-3)))+(20-1)"));
//        System.out.println("Result" + cCalculatorEngineTest.getCalculate("-45-2)"));
//        System.out.println("Result" + cCalculatorEngineTest.getCalculate("45.23(10.27-4.31)"));
//      System.out.println("Result" + cCalculatorEngine.calculationsResult("-10(2+2)"));

//        Calculator cCalculator = new Calculator();
//        System.out.println("calReslt : " + cCalculator.Calculate("-10*(2+2)"));
    }

    public void onClick(View v){
        cClickEvent.ClickTool(v);
        cClickEvent.ClickSign(v);
        cClickEvent.ClickNumber(v);
        cSetTextView.setEquationTextView();

        //cMain.setEquationTextView();
        //System.out.println("String : " + Define.ins().sEquation);
        //System.out.println("Result : " + cCalculatorEngine.calculationsResult(Define.ins().sEquation));

    }
}
