package kr.sweetycat.carculator.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import kr.sweetycat.carculator.R;
import kr.sweetycat.carculator.common.ClickEvent;
import kr.sweetycat.carculator.common.Define;
import kr.sweetycat.carculator.main.Main;

public class MainActivity extends Activity {
    Define cDefine;
    ClickEvent cClickEvent;
    Main cMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        cDefine = new Define();
        cClickEvent = new ClickEvent(this);
        cMain = new Main(this);

        cMain.ChangeFont();

    }

    public void onClick(View v){
        cClickEvent.ClickTool(v);
        cClickEvent.ClickSign(v);
        cClickEvent.ClickNumber(v);

    }
}
