package com.example.xu.yufengdemmo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int mCurrentView=0;
    private Button mButton;
    private FrameLayout mFrameLayout;
    private View View1;
    private View View2;
    private View View3;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mUserSettings;

    @Override
    //test
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserSettings = getSharedPreferences("setting", 0);
        mEditor = mUserSettings.edit();
        if (mUserSettings.getInt("CurrentView",0)!=0){
            mCurrentView=mUserSettings.getInt("CurrentView",0);
            System.out.println(mCurrentView+"--");
        }
        setContentView(R.layout.activity_main);

        init3View();
        initfbc();

        initclick();

        initopenView(mCurrentView);


    }

    private void initopenView(int currentView) {
        switch (currentView) {
            case 1:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View1);
                break;
            case 2:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View2);
                break;
            case 3:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View3);
                break;
        }
    }

    private void init3View() {
        View1 = View.inflate(MainActivity.this, R.layout.view1, null);
        View2 = View.inflate(MainActivity.this, R.layout.view2, null);
        View3 = View.inflate(MainActivity.this, R.layout.view3, null);
    }

    private void initclick() {
        mButton.setOnClickListener(this);
    }

    private void initfbc() {
        mButton = (Button) findViewById(R.id.button);
        mFrameLayout = (FrameLayout) findViewById(R.id.fl);

    }

    @Override
    public void onClick(View v) {
        switch (mCurrentView) {
            case 0:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View1);
                mCurrentView=1;
                mEditor.putInt("CurrentView",mCurrentView);
                mEditor.commit();
                break;
            case 1:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View2);
                mCurrentView=2;
                mEditor.putInt("CurrentView",mCurrentView);
                mEditor.commit();
                break;
            case 2:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View3);
                mCurrentView=3;
                mEditor.putInt("CurrentView",mCurrentView);
                mEditor.commit();
                break;
            case 3:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(View1);
                mCurrentView=1;
                mEditor.putInt("CurrentView",mCurrentView);
                mEditor.commit();
        }

    }
}
