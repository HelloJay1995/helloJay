package cn.hello.jay.util;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 周健以
 * @Date 2020年02月28日
 */
public class XXX {
    public static void mainReplace(String[] args) throws Exception {

        FileReader fr = new FileReader(new File("/Users/hellojay/Desktop/mergeAssistCopy.txt"));
        BufferedReader br = new BufferedReader(fr);
        String data = br.readLine();
//        while (!StringUtils.isEmpty(data)) {
            String[] infos = data.split(",");
            Map<String, Object> parm = new HashMap<>();
            parm.put("id", "4169");
            parm.put("andInvokeFlag", "0");
            parm.put("name", "【黑洞】合并ASSIST");
            parm.put("group", "SHARECORE");
            parm.put("type", "REPEAT");
            parm.put("time", "");
            parm.put("cron", "0 0  0/1 * * ?");
            parm.put("urls", "http://172.21.43.21:8154/job");
            parm.put("classPath", "com.weidai.sharecore.job.GoodsShareFixDataJob");
            parm.put("invokePolicy", "PRIORITY");
            Map map = new HashMap();
            map.put("code", "C14");
            map.put("goodsNo", infos[0]);
            map.put("assetNo", infos[2]);
            map.put("userId", infos[1]);
//            parm.put("param", JSON.toJSONString(map));
            parm.put("param", "{\"code\":\"C14\",\"goodsNo\":\"111\",\"assetNo\":\"222\",\"userId\":333}");
            parm.put("desc", "\"{\\\"code\\\":\\\"C14\\\",\\\"goodsNo\\\":\\\"\\\",\\\"assetNo\\\":\\\"\\\",\\\"userId\\\":}\"");
            parm.put("ownerPhone", "");
            parm.put("executeTimeout", "10");
            parm.put("sendSuccessMsg", "0");
            parm.put("asyncResult", "0");
            parm.put("jobLevel", "0");
            parm.put("isActivity", "false");
//            parm.put("authId", "sso-7lfh5s8kf0i15dbaaf3bb93445fbb1c0f915f4a4c63");

        Map<String, String> headers = new HashMap<>();
//        headers.put("authId","sso-7lfh5s8kf0i15dbaaf3bb93445fbb1c0f915f4a4c63");
        headers.put("Cookie","authId=sso-7lfh5s8kf0i15dbaaf3bb93445fbb1c0f915f4a4c63");
        String post = HttpUtil.post("http://legends.weidai.com.cn/jobinfo/executeJob", JSON.toJSONString(parm),headers);
        System.out.println(post);

//        }
    }
}