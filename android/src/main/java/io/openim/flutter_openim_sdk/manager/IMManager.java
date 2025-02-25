package io.openim.flutter_openim_sdk.manager;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.openim.flutter_openim_sdk.listener.BaseListener;
import io.openim.flutter_openim_sdk.listener.SDKListener;
import io.openim.flutter_openim_sdk.util.CommonUtil;
import open_im_sdk.Open_im_sdk;

public class IMManager {

    public void initSDK(MethodCall methodCall, MethodChannel.Result result) {
        CommonUtil.runMainThreadReturn(result, Open_im_sdk.initSDK(CommonUtil.getSDKJsonParam(methodCall), new SDKListener()));
//        CommonUtil.runMainThreadReturn(result, null);
    }

    public void login(MethodCall methodCall, MethodChannel.Result result) {
        Open_im_sdk.login(CommonUtil.getUid(methodCall), CommonUtil.getToken(methodCall), new BaseListener(result));
    }

    public void logout(MethodCall methodCall, MethodChannel.Result result) {
        Open_im_sdk.logout(new BaseListener(result));
    }

    public void getLoginStatus(MethodCall methodCall, MethodChannel.Result result) {
        CommonUtil.runMainThreadReturn(result, Open_im_sdk.getLoginStatus());
    }

    public void getLoginUid(MethodCall methodCall, MethodChannel.Result result) {
        CommonUtil.runMainThreadReturn(result, Open_im_sdk.getLoginUid());
    }

    public void getUsersInfo(MethodCall methodCall, MethodChannel.Result result) {
        Open_im_sdk.getUsersInfo(CommonUtil.getUidList(methodCall), new BaseListener(result));
    }

    public void setSelfInfo(MethodCall methodCall, MethodChannel.Result result) {
        Open_im_sdk.setSelfInfo(CommonUtil.getSDKJsonParam(methodCall), new BaseListener(result));
    }

    public void forceSyncLoginUerInfo(MethodCall methodCall, MethodChannel.Result result) {
        Open_im_sdk.forceSyncLoginUerInfo();
    }

    public void forceReConn(MethodCall methodCall, MethodChannel.Result result) {
        Open_im_sdk.forceReConn();
    }
}
