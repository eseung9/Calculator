package kr.sweetycat.carculator.main;

import android.app.Activity;
import android.widget.TextView;

import kr.sweetycat.carculator.R;
import kr.sweetycat.carculator.common.Define;

/**
 * Created by Yi on 2017-03-01.
 */

public class SetTextView {
    Activity aSetTextView;
    public SetTextView(Activity activity) {
        aSetTextView = activity;
    }

    public void setEquationTextView() {
        TextView tvEquation = (TextView)aSetTextView.findViewById(R.id.idTV_Equation);
        tvEquation.setText(Define.ins().sEquation);

    }

    public void setResultTextView() {
        TextView tvResult = (TextView)aSetTextView.findViewById(R.id.idTV_Result);
        tvResult.setText(Define.ins().sResult);
    }

}
