package com.smn.sample;

public class SmsDemo {

    public static void main(String[] args) {
        ClientDemo clientDemo = new ClientDemo();
        // 发送消息
        clientDemo.smsPublish();

        //查询短信的发送状态的demo
        clientDemo.listSmsMsgReport();

        // 查询短信回调事件的demo
        clientDemo.listSmsCallbackEvent();

        //更新短信回调事件
        clientDemo.updateSmsCallbackEvent();
    }
}