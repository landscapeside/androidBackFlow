package cn.ytxu.androidbackflow.sample.normal.request_fragment.letter;

import cn.ytxu.androidbackflow.sample.normal.request_fragment.BaseLetterFragment;

/**
 * Created by newchama on 17/1/3.
 */
public class LetterDFragment extends BaseLetterFragment {

    @Override
    protected void initView() {
        super.initView();

        setRollbackFlow(LetterAFragment.class, "back to header");
    }
}
