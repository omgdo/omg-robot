package top.omgdo.listener;

import catcode.CatCodeUtil;

import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Filter;

import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;

import love.forte.simbot.filter.MatchType;

import top.omgdo.utils.MyHttpConnection;


import java.io.IOException;

/**
 * 聊天监听机器人
 */

@Beans
public class ChatRobotListener {



//    指定文件路径
    private String pathImg="C:\\Users\\zhangsan\\Desktop\\baidu.png";

    private String []tr;



    /** 当私聊 hi的时候，发送一张图片
     *
     * @param msg 消息接收方
     * @param sender 消息发送机器人
     */
    @OnPrivate
    @Filter(value = "hi",trim = true,matchType = MatchType.CONTAINS)
    public void privateChatRobot(PrivateMsg msg,MsgSender sender){

//        图片发送工具
        CatCodeUtil util = CatCodeUtil.INSTANCE;

//        猫猫码发送
        String image = util.toCat("image", true, "file="+ pathImg);
        System.out.println(image);
        sender.SENDER.sendPrivateMsg(msg,image);

//        另一种发送方式
//        Neko image1 = util.toNeko("image", true, "file=" + pathImg);
//        System.out.println(image1);
//        sender.SENDER.sendPrivateMsg(msg,image1.toString());


    }

        @OnGroup  //群聊
        @Filter(groups = {"877360220"},trim = true)
    public void groupChatRobot(GroupMsg groupMsg,MsgSender sender) throws IOException {
//        获取登录账号的名字
//        String botName = sender.GETTER.getBotInfo().getBotName();

//        获取监听的人的信息
        String msg = groupMsg.getMsgContent().getMsg();


//        获取api聊天信息
        String get = MyHttpConnection.getGet(msg);

//        发送消息
        sender.SENDER.sendGroupMsg(groupMsg,get);

    }


}
