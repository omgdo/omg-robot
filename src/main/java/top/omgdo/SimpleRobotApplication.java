package top.omgdo;
import love.forte.common.configuration.Configuration;
import love.forte.simbot.annotation.SimbotApplication;

import love.forte.simbot.annotation.SimbotResource;
import love.forte.simbot.api.sender.BotSender;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.core.SimbotApp;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.core.SimbotProcess;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import top.omgdo.pojo.DateTime;
import top.omgdo.utils.DateTimeUtils;

//指定配置文件


//@SpringBootApplication

@SimbotApplication({@SimbotResource(value = "application.properties", orIgnore = true),
        @SimbotResource(value = "application.yaml", orIgnore = true)})
public class SimpleRobotApplication  implements SimbotProcess {
    public static void main(String[] args) {
        SimbotApp.run(SimpleRobotApplication.class, args);

    }

//    在启动之后处理信息
    @Override
    public void post(@NotNull SimbotContext context) {
//        获取机器人信息
        Bot bot = context.getBotManager().getDefaultBot();


//      指定机器人名字，接收者qq号，以及上线时间
        String name = bot.getBotInfo().getBotName();
        String recipient = "869893201";
        String currentTime = DateTimeUtils.getCurrentTime(DateTime.DATE_TIME);

//        上线后给指定用户发送信息
        BotSender sender = bot.getSender();
        sender.SENDER.sendPrivateMsg(recipient,
                name+"在 "+currentTime+" 上线了");
    }

//    在机器人启动前处理信息
    @Override
    public void pre(@NotNull Configuration config) {

    }
}
