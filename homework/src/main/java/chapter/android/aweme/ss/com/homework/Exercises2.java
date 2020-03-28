package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private TextView ViewCountDisplay;
    private ViewGroup test;

    private  void logAndAppend(View view) {
        Log.d("Exercise2","ViewCount Event:"+view);
        ViewCountDisplay.append("ViewCount of testview is "+getAllChildViewCount(view)+"\n");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcount);
        ViewCountDisplay = findViewById(R.id.viewcount);
        test = findViewById(R.id.test);
        logAndAppend(test);
    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        if (view instanceof ViewGroup) {
            int viewCount = 1;
            for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++){
                View child = ((ViewGroup) view).getChildAt(i);
                if(child instanceof  ViewGroup){
                    viewCount += getAllChildViewCount(child);
                }
                else{
                    viewCount++;
                }
            }
            return viewCount;
        }
        else
            return 0;
    }
}
