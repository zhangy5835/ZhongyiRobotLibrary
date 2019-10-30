package com.fubao.robotlibrary;

import android.graphics.Bitmap;
import android.view.SurfaceView;

import com.synjones.idcard.IDCard;


/**
 * 此接口作为对上层应用提供硬件服务的接口，后续放在云平台，通过build.gradle文件进行implementation依赖
 *
 * 还未完善
 */
public interface RobotInterface {

    /**
     * 图像识别状态
     */
    public final static int DL_NO_DISCERN = 0; //图像识别未获取到数据
    public final static int DL_LEW_SCORE_DISCERN = 1;  //图像识别获取到的数据预估值偏低
    public final static int DL_HIGH_SCORE_DISCERN = 2;  //图像识别获取到的数据预估值偏高
    /**
     * 身份证连接状态
     */
    public final static int IDCARD_CONNECTED_DEVICE = 3;  // 连接成功
    public final static int IDCARD_CONNECTING_DEVICE = 4; //正在连接
    public final static int IDCARD_CONNECTFAILED_DEVICE = 5;//连接失败
    public final static int IDCARD_DISCONNECTED_DEVICE = 6;//断开连接
    public final static int IDCARD_RECONNECT_DEVICE = 7;//重新连接




    /**
     * 打开人脸识别
     * @param surfaceView
     */
    void startDLRecognize(SurfaceView surfaceView);

    /**
     * 关闭人脸
     */
    void stopDLRecognize();


    /**
     * 注册图像识别
     * @param callBack
     */
    void registerDLREcognize(DLResultCallBack callBack);


    /**
     * 图像识别的回调
     */
    interface DLResultCallBack{

        void getDLResult(int type, Bitmap bitmap);

    }


    /**
     * 开启语音识别
     */
    void startListening();

    /**
     * 关闭语音识别
     */
    void stopListening();


    /**
     * 注册语音识别返回信息
     */
    void registerListening(SpeechResultCallBack speech);


    /**
     * 取消注册语音识别返回信息
     */
    void unreisterListening();


    interface SpeechResultCallBack{

        /**
         * FAQ回答回调
         * @param content  回答的文字
         * @param url  配置的图片链接
         */
        void robotAnswer(String content, String url);

        /**
         * 麦克风识别的回调
         * @param speech  麦克风识别的文字
         */
        void onSpeechAsr(String speech);

        /**
         * 语音识别错误回调
         * @param errorCode  错误码
         */
        void onError(int errorCode);
    }


    /**
     * 语音播报
     * @param msg
     */
    void speakMessage(String msg);


    /**
     * 开启身份证读卡器
     */
    void startPersonId();


    /**
     * 关闭身份证读卡器
     */
    void stopPersionId();

    /**
     * 注册身份证读卡器的信息
     */
    void registerPersionMessage(IdCardResultCallBack callBack);


    /**
     * 反注册身份证读卡器信息
     */
    void unregisterPersionMessage();


    /**
     * 身份证返回的结果
     */
    interface IdCardResultCallBack{

        /**
         * 身份证返回的结果
         * @param idCard
         */
        void onIdCardResult(IDCard idCard);

        void onConnectState(int type);
    }

    /**
     * 释放资源
     */
    void release();




}
