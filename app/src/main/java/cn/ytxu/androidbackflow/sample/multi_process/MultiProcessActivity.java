package cn.ytxu.androidbackflow.sample.multi_process;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.ytxu.androidbackflow.BaseActivity;
import cn.ytxu.androidbackflow.R;
import cn.ytxu.androidbackflow.sample.App;
import cn.ytxu.androidbackflow.sample.request_activity.letter.LetterAActivity;
import cn.ytxu.androidbackflow.sample.request_activity_and_fragment.ContainerAF1Activity;
import cn.ytxu.androidbackflow.sample.request_activity_and_fragment.letter.LetterAFAFragment;
import cn.ytxu.androidbackflow.sample.request_fragment.ContainerActivity;
import cn.ytxu.androidbackflow.sample.request_fragment.letter.LetterAFragment;

/**
 * Created by ytxu on 17/1/4.
 */
public class MultiProcessActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = MultiProcessActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Multi Process View");
        $(R.id.main_btn_4_requedst_activity).setOnClickListener(this);
        $(R.id.main_btn_4_requedst_fragment).setOnClickListener(this);
        $(R.id.main_btn_4_requedst_activity_and_fragment).setOnClickListener(this);


        Log.i(TAG, "init-->current process name:" + ((App) getApplication()).getCurProcessName(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_4_requedst_activity:
                startActivity(new Intent(this, LetterAActivity.class));
                break;
            case R.id.main_btn_4_requedst_fragment: {
                Intent intent = new Intent(this, ContainerActivity.class);
                intent.putExtra(ContainerActivity.PARAM_CLASSNAME, LetterAFragment.class.getName());
                startActivity(intent);
            }
            break;
            case R.id.main_btn_4_requedst_activity_and_fragment: {
                Intent intent = new Intent(this, ContainerAF1Activity.class);
                intent.putExtra(ContainerAF1Activity.PARAM_CLASSNAME, LetterAFAFragment.class.getName());
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}