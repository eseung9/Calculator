package kr.sweetycat.carculator.main;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

import kr.sweetycat.carculator.R;
import kr.sweetycat.carculator.common.Define;

/**
 * Created by Yi on 2017-03-01.
 */

public class Main {
    private Activity aMain;

    public Main(Activity activity) {
        aMain = activity;

    }

    public void ChangeFont() {
        //!< 결과창 폰트
        TextView tvResult = (TextView)aMain.findViewById(R.id.idTV_Result);
        tvResult.setTypeface(Typeface.createFromAsset(aMain.getAssets(), "DINRegular.ttf"));

        //!< 입력된 식 폰트
        TextView tvEquation = (TextView)aMain.findViewById(R.id.idTV_Equation);
        tvEquation.setTypeface(Typeface.createFromAsset(aMain.getAssets(), "DINRegular.ttf"));

    }


//    public void setEquationTextView() {
//        TextView tvEquation = (TextView)aMain.findViewById(R.id.idTV_Equation);
//        tvEquation.setText(Define.ins().sEquation);
//
//    }
//
//    public void setResultTextView() {
//        TextView tvResult = (TextView)aMain.findViewById(R.id.idTV_Result);
//        tvResult.setText(Define.ins().sResult);
//    }

}
