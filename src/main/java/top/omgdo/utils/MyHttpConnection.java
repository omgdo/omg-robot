package top.omgdo.utils;

import com.alibaba.fastjson.JSONObject;
import kotlinx.serialization.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import top.omgdo.pojo.DateTime;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
/**
 * 封装了HttpClient
 */
public class MyHttpConnection {
//    HttpClient客户端
    private static HttpClient httpClient= HttpClientBuilder.create().build();

    // ai聊天机器人
    private static String AiChatApiUrl="http://api.qingyunke.com/api.php?key=free&appid=0&msg=";

    public static String getGet(String msg) throws IOException {

        String message;

//        将字符进行转码
        String encode = URLEncoder.encode(msg, "utf-8");

//        发送一个get请求
        HttpGet httpGet=new HttpGet(AiChatApiUrl+encode);

        HttpResponse httpResponse = httpClient.execute(httpGet);

//        如果返回两百，对其进行处理
        if(httpResponse.getStatusLine().getStatusCode()==200){

            String temp = EntityUtils.toString(httpResponse.getEntity());

//            拿到json字符串
            JSONObject jsonObject = JSONObject.parseObject(temp);
            String content = jsonObject.getString("content");

//            将json解析成人可阅读的字符串
            message = UrlToString(content);

        }else {
//            打印错误信息
            message = "在"+DateTimeUtils.getCurrentTime(DateTime.DATE_TIME)+"；访问错误，错误信息："+httpResponse.getStatusLine();
            log.error(message);
        }

        return message;

    }


    /**
     * 将url解析成文本可读
     * @param content  url格式
     * @return  文本格式
     */
    private static String UrlToString(String content){
        return content.replace("%20", " ")
                .replace("{br}", "\n")
                .replace("菲菲", "悦悦");
    }
}
