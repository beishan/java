package com.iag.java.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author weixueshan
 * @date 2017/11/13 16:56
 */
public class JsonTest {

    @Test
    public void test() throws ParseException {
        String str = "{\n" +
                "                    \"phone_with_other_idcards\" : [ \n" +
                "                        {\n" +
                //"                            \"susp_updt\" : \"2017-06-20 13:48:36\",\n" +
                "                            \"susp_idcard\" : \"110101198001010010\"\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"susp_updt\" : \"2017-06-19 18:28:09\",\n" +
                "                            \"susp_idcard\" : \"110101198001010416\"\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"susp_updt\" : \"2017-06-19 17:22:42\",\n" +
                "                            \"susp_idcard\" : \"130827198607184416\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"phone_applied_in_orgs\" : [ \n" +
                "                        {\n" +
                "                            \"susp_updt\" : \"2017-06-20 13:48:36\",\n" +
                "                            \"susp_org_type\" : \"线上信用现金贷\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"phone_with_other_names\" : []\n" +
                "                }";

        System.out.println(str);

        JSONObject jo1 = JSON.parseObject("");
        JSONObject jo2 = JSON.parseObject(null);


        JSONObject jsonObject = JSON.parseObject(str);

        JSONArray jsonArray = jsonObject.getJSONArray("phone_with_other_idcards");
        JSONArray jsonArray1 = jsonObject.getJSONArray("phone_with_other_names");
        JSONArray jsonArray2 = jsonObject.getJSONArray("phone_with_other_names222");

        for (int i = 0; i < jsonArray.size(); i++) {
            Map map = (Map)jsonArray.get(i);
            //Date date = Calendar.
            String strtime =  (String)map.get("susp_updt");
            System.out.println("");
        }


        System.out.println("");
    }
    @Test
    public void test22(){
        Demo demo = new Demo();
        String str = JSON.toJSONString(demo);

        JSONObject jsonObject = JSON.parseObject(str);

        Date d = jsonObject.getDate("time");



        Demo demo2 = null;
        String str2 = JSON.toJSONString(demo2);

        JSONObject jsonObject2 = JSON.parseObject(str2);

        Date d2 = jsonObject.getDate("time");


        System.out.println("");

    }
}
