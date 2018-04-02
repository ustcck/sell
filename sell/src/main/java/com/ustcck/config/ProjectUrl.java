package com.ustcck.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by CaoKai on 2018/4/2 15:17.
 * Email:caokai@yijiahe.com
 */
@Component
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrl {

    private String wechatMpAuthorize;
    private String wechatOpenAuthorize;
    private String sell;

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getWechatMpAuthorize() {
        return wechatMpAuthorize;
    }

    public void setWechatMpAuthorize(String wechatMpAuthorize) {
        this.wechatMpAuthorize = wechatMpAuthorize;
    }

    public String getWechatOpenAuthorize() {
        return wechatOpenAuthorize;
    }

    public void setWechatOpenAuthorize(String wechatOpenAuthorize) {
        this.wechatOpenAuthorize = wechatOpenAuthorize;
    }
}
