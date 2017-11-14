package com.iag.java.designmode.watcher;

import org.junit.Test;

public class ObserverTest {

    @Test
    public void test(){
        WeixinUser weixinUser1 = new WeixinUser("粉丝1");
        WeixinUser weixinUser2 = new WeixinUser("粉丝2");
        WeixinUser weixinUser3 = new WeixinUser("粉丝3");

        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        subscriptionSubject.attach(weixinUser1);
        subscriptionSubject.attach(weixinUser2);
        subscriptionSubject.attach(weixinUser3);

        subscriptionSubject.notify("谢谢大家的关注");
    }
}
