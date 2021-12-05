package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint("/chat/{username}")
@Component
public class WebSocketController {
    private static final Map<String, Session> clinets=new HashMap<>();
    private Session session;

    private String username;

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "username") String param) {
        this.username=param;
        this.session = session;
        clinets.put(param, session);
        sendLoginMsg();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        sendUserList();
    }

    private void sendUserList() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("head","userList");
        jsonObject.put("data",clinets.keySet());
        for(Session session:clinets.values()){
            session.getAsyncRemote().sendText(JSON.toJSONString(jsonObject));
        }
    }

    private void sendLoginMsg() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("head","onLine");
        jsonObject.put("data",this.username);
        for(Session session:clinets.values()){
            session.getAsyncRemote().sendText(JSON.toJSONString(jsonObject));
        }
    }

    @OnClose
    public void onClose() {
        System.out.println("关闭了");
    }

    @OnError
    public void onError(Throwable t) {

    }


    @OnMessage
    public void onMessage(String message) {
        System.out.println("客户端发来的消息是:" + message);

        //确认当前消息来自谁,需要操作的类型
        JSONObject jsonObj = JSON.parseObject(message);
        String head = jsonObj.getString("head");
        if ("sendAll".equals(head)) {
            sendAll(jsonObj.getString("data"));
        } else if (head.equals("sendTo")) {
            sendTo(jsonObj.getString("data"));
        }
    }

    private void sendTo(String data) {
        JSONObject receiveData= JSON.parseObject(data);

        JSONObject jsonObj=new JSONObject();
        jsonObj.put("head","sendTo");

        JSONObject dataObj=new JSONObject();
        dataObj.put("msgInfo",receiveData.getString("msgInfo"));
        dataObj.put("fromUser",this.username);

        jsonObj.put("data",dataObj);

        for (String name : clinets.keySet()) {
            if(name.equals(receiveData.getString("toUSer"))){
                //私发消息
                clinets.get("name").getAsyncRemote().sendText(JSON.toJSONString(jsonObj));
            }
        }

    }

    private void sendAll(String data) {
        JSONObject receiveData= JSON.parseObject(data);

        JSONObject jsonObj=new JSONObject();
        jsonObj.put("head","sendAll");

        JSONObject dataObj=new JSONObject();
        dataObj.put("msgInfo",receiveData.getString("msgInfo"));
        dataObj.put("fromUser",this.username);

        jsonObj.put("data",dataObj);

        for (Session session:clinets.values()) {
            session.getAsyncRemote().sendText(JSON.toJSONString(jsonObj));
        }
    }
}
