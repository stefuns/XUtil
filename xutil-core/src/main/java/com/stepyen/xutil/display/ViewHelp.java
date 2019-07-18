package com.stepyen.xutil.display;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * date：2019/6/11
 * author：stepyen
 * description：view的帮助类
 *
 *  XUtil.getContext()
 */
public class ViewHelp {
    private ViewHelp() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 获取文本
     */
    public static CharSequence getText(TextView tv) {
        if (tv!= null) {
            return tv.getText().toString().trim();
        }

        return "";
    }


    /**
     * 设置控件是否可用
     * @param enable
     */
    public static void enable(View view, boolean enable) {
        if (view == null) {
            throw new IllegalStateException("view is null");
        }
        view.setEnabled(enable);
        if (view instanceof EditText) {
            view.setFocusable(enable);
            view.setFocusableInTouchMode(enable);
        }
    }

    /**
     * EditText设置文本和光标置后
     */
    public static void editTextSetText(EditText editText,CharSequence charSequence) {
        editText.setText(charSequence);
        editText.setSelection(charSequence.length());
    }



}
