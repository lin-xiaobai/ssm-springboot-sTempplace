package com.itheima.travel.domain;

import com.github.wxpay.sdk.WXPayConfig;
import lombok.Data;

import java.io.InputStream;

/**
 * @date 2021/10/28 -17:21
 */
@Data
public class PayConfig implements WXPayConfig {
    private String appID; // 公众账号ID

    private String mchID; // 商户号

    private String key; // 生成签名的密钥

    private int httpConnectTimeoutMs; // 连接超时时间

    private int httpReadTimeoutMs;// 读取超时时间

    @Override
    public InputStream getCertStream(){
        return null;
    }

//    public IWXPayDomain getWXPayDomain(){
//        return WXPayDomainSimpleImpl.instance();
//    }
}
