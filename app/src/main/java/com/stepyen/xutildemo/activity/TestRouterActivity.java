/*
 * Copyright (C) 2018 stepyenjys(stepyenjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stepyen.xutildemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.stepyen.xutil.app.IntentUtils;
import com.stepyen.xutildemo.R;
import com.stepyen.xutildemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author stepyen
 * @date 2018/3/18 下午6:25
 */
public class TestRouterActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView mTvContent;
    String param;

    /**
     * 布局的资源id
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_router;
    }

    @Override
    protected void initArgs() {
        super.initArgs();
//        param = IntentUtils.getStringExtra(getIntent(), "param");

        showContent("参数1：" + IntentUtils.getStringExtra(getIntent(), "param1") + "， 参数2：" + IntentUtils.getIntExtra(getIntent(), "param2", 0));
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {

    }

    /**
     * 初始化监听
     */
    @Override
    protected void initListeners() {

    }

    private void showContent(String content) {
        mTvContent.setText(content);
    }

    @OnClick(R.id.back)
    void OnClick(View v) {
        switch(v.getId()) {
            case R.id.back:
                Intent i = new Intent();
                i = IntentUtils.putExtra(i, "back", "返回的是1111");
                setResult(RESULT_OK, i);
                finish();
                break;
            default:
                break;
        }
    }

}
