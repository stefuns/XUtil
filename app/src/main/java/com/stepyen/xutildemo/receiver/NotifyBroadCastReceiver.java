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

package com.stepyen.xutildemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.stepyen.xutil.tip.ToastUtils;

/**
 * @author stepyen
 * @date 2018/3/22 下午11:54
 */
public class NotifyBroadCastReceiver extends BroadcastReceiver {

    public final static String ACTION_SUBMIT = "com.stepyen.xutildemo.receiver.action_submit";
    public final static String ACTION_CANCEL = "com.stepyen.xutildemo.receiver.action_cancel";
    public final static String ACTION_REPLY = "com.stepyen.xutildemo.receiver.action_reply";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ACTION_SUBMIT.equals(action)) {
            ToastUtils.toast("ACTION_SUBMIT");
        } else if (ACTION_CANCEL.equals(action)) {
            ToastUtils.toast("ACTION_CANCEL");
        } else if (ACTION_REPLY.equals(action)) {
            ToastUtils.toast("ACTION_REPLY");
        }
    }
}
