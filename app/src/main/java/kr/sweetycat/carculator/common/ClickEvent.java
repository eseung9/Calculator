package kr.sweetycat.carculator.common;

import android.app.Activity;
import android.view.View;

import kr.sweetycat.carculator.R;

/**
 * Created by Yi on 2017-02-28.
 */

public class ClickEvent {
    private Activity aClickEvent;

    public ClickEvent(Activity activity) {
        aClickEvent = activity;
        
    }

    public void ClickTool(View v) {
        switch(v.getId()) {
            case R.id.idImgBtn_Copy:

                break;

            case R.id.idImgBtn_Back:

                break;

            case R.id.idImgBtn_Clear:

                break;
        }
    }

    public void ClickSign(View v) {
        switch(v.getId()) {
            case R.id.idImgBtn_Plus:

                break;

            case R.id.idImgBtn_Minus:

                break;

            case R.id.idImgBtn_Multiply:

                break;

            case R.id.idImgBtn_Division:

                break;

            case R.id.idImgBtn_Equals:

                break;

            case R.id.idImgBtn_StartBrackets:

                break;

            case R.id.idImgBtn_EndBrackets:

                break;

            case R.id.idImgBtn_PlusMinusSign:

                break;
        }

    }

    public void ClickNumber(View v) {
        switch(v.getId()) {
            case R.id.idImgBtn_0:

                break;

            case R.id.idImgBtn_1:

                break;

            case R.id.idImgBtn_2:

                break;

            case R.id.idImgBtn_3:

                break;

            case R.id.idImgBtn_4:

                break;

            case R.id.idImgBtn_5:

                break;

            case R.id.idImgBtn_6:

                break;

            case R.id.idImgBtn_7:

                break;

            case R.id.idImgBtn_8:

                break;

            case R.id.idImgBtn_9:

                break;

        }

    }

}
