package com.stepyen.xutil.display;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * date：2019/9/18
 * author：stepyen
 * description：输入框工具类
 * <p>
 * 监听多个输入框，输入框都有值，按钮才可用
 */
public class EditTextUtils {

    private TextView tv;
    private EditText[] editTexts;
    private IEditTextChangeListener mChangeListener;

    public EditTextUtils() {

    }

    public EditTextUtils setButton(TextView tv) {
        this.tv = tv;
        return this;
    }

    public EditTextUtils addAllEditText(EditText... editTexts) {
        this.editTexts = editTexts;
        for (EditText editText : editTexts) {
            editText.addTextChangedListener(new TextChange(tv,editTexts, mChangeListener ));
        }
        return this;
    }

    public EditTextUtils setChangeListener(IEditTextChangeListener changeListener) {
        mChangeListener = changeListener;
        return this;
    }

    private static class TextChange implements TextWatcher {
        private TextView tv;
        private EditText[] editTexts;
        private IEditTextChangeListener mChangeListener;
        public TextChange(TextView tv,  EditText[] editTexts, IEditTextChangeListener mChangeListener) {
            this.tv = tv;
            this.editTexts = editTexts;
            this.mChangeListener = mChangeListener;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (checkAllEdit()) {
                mChangeListener.textChange(true);
                tv.setEnabled(true);
            } else {
                mChangeListener.textChange(false);
                tv.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }

        private boolean checkAllEdit() {
            for (EditText editText : editTexts) {
                if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public interface IEditTextChangeListener {
        void textChange(boolean isAllHaveText);
    }
}
