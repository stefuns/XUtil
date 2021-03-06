package com.stepyen.xutildemo.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.stepyen.xutil.common.SpanUtils;
import com.stepyen.xutil.resource.ResUtils;
import com.stepyen.xutil.system.PhoneUtils;
import com.stepyen.xutildemo.R;
import com.stepyen.xutildemo.base.BaseFragment;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.base.XPageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * date：2019/7/17
 * author：stepyen
 * description：
 */
@Page(name = "测试")
public class TestFragment extends XPageFragment {

    TextView mTvTest;
    TextView tv_imei;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initViews() {
        mTvTest = findViewById(R.id.tv_test);
        tv_imei = findViewById(R.id.tv_imei);
        setPayAgree(mTvTest);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            tv_imei.setText(PhoneUtils.getIMEI());
        }else{
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_PHONE_STATE}, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode ==123) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                tv_imei.setText(PhoneUtils.getIMEI());
            }
        }
    }

    @Override
    protected void initListeners() {

    }

    public  void setPayAgree(TextView tv) {
        SpannableStringBuilder sb = new SpanUtils()
                .append("支付即表示同意")
                .setForegroundColor(ResUtils.getColor(R.color.__picker_black_40))
                .setFontSize(ResUtils.getDimensionPixelSize(R.dimen.public_subtitle))
                .append("《嗖嗖伙伴平台协议》")
                .setClickSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(getContext(), "平台协议", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void updateDrawState(TextPaint ds) {
                        ds.setColor(ds.linkColor);
                        //去除超链接的下划线
                        ds.setUnderlineText(false);
                    }
                })
                .setForegroundColor(ResUtils.getColor(R.color.public_red))
                .setFontSize(ResUtils.getDimensionPixelSize(R.dimen.public_subtitle))
                .create();
        tv.setText(sb);
        //去掉点击后的背景颜色为透明
        tv.setHighlightColor(ContextCompat.getColor(getContext(),R.color.public_transparent));
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }


}
