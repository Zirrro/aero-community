package com.salieri.community.provider;

import com.alibaba.fastjson.JSON;
import com.salieri.community.dto.AccessTokenDTO;
import com.salieri.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {


    // 获得AccessToken
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        System.setProperty("https.proxySet", "true");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "7890");

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
    } catch (Exception e) {
                System.out.println("response failed");
                e.printStackTrace();
            }
            return null;
    }

    // 根据AccessToken获取user信息
    public GithubUser getUser(String accessToken) {

        System.setProperty("https.proxySet", "true");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "7890");

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .header("Authorization","token " + accessToken)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class); //json转换成类
            return githubUser;
        } catch (IOException e) {

        }
        return null;
    }

}
