package com.youdu.constant;

import android.Manifest;

/**
 * @author: vision
 * @function:
 * @date: 16/6/16
 */
public class Constant {

    public static final String TES_JSON =
            "{\n" +
                    "    \"values\": [\n" +
                    "        {\n" +
                    "            \"resourceID\": \"s1469789982876bzdpjb\",\n" +
                    "            \"adid\": \"00000001112\",\n" +
                    "            \"resource\": \"http://211.151.146.65:8080/wlantest/shanghai_sun/wanghan.mp4\", \n" +
                    "            \"logo\": \"http://10.10.73.67/adsdk/stella/picture/girl1.jpg\",\n" +
                    "            \"title\": \"telunsu\",\n" +
                    "            \"thumb\": \"https://img.alicdn.com/imgextra/i2/268691146/TB2sgKeqFXXXXXZXpXXXXXXXXXX_!!268691146.jpg\",\n" +
                    "            \"text\": \"Not all milk is called telunsu\",\n" +
                    "            \"startMonitor\": [\n" +
                    "                {\n" +
                    "                    \"ver\": \"0\",\n" +
                    "                    \"url\": \"http://imooc.com/show?impression=1\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"ver\": \"0\",\n" +
                    "                    \"url\": \"http://imooc.com/show?impression=2\"\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"middleMonitor\": [\n" +
                    "                {\n" +
                    "                    \"ver\": \"0\",\n" +
                    "                    \"url\": \"http://imooc.com/show?SU=1\",\n" +
                    "                    \"time\": 5\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"endMonitor\": [\n" +
                    "                {\n" +
                    "                    \"ver\": \"0\",\n" +
                    "                    \"url\": \"http://imooc.com/show?end=1\"\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"clickUrl\": \"https://www.baidu.com\",\n" +
                    "            \"clickMonitor\": [\n" +
                    "                {\n" +
                    "                    \"ver\": \"0\",\n" +
                    "                    \"url\": \"http://imooc.com/click?v=397388709&pp=1&ct=a&cs=2148&ca=1219383&ie=748301&uid=800997742&ck=146457765428041G&al=15&bl=0&s=&td=1&st=4&vl=71.0&ap=2&sid=846460005520810e7e216&cr=1&pr=37&oidtype=111935%7C0&dq=auto%7Cmp4&uri=-1&dc=3464273&bak=1&pc=12500&hyid=&ps=0&eff=1&adsid=146460005988547572325&bd=&mdl=&tag=&ip=218.30.180.179&htch=__htch__&tp=2&prp=30&reqid=a04-06E0-02eozw-0af-2G0&pid=&advid=394439875&mb=0&os=2&dt=3&aw=w&avs=&sc=&gd=\"\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"event\": {\n" +
                    "                \"full\": {\n" +
                    "                    \"content\": [\n" +
                    "                        {\n" +
                    "                            \"ver\": \"0\",\n" +
                    "                            \"url\": \"http://imooc.com/show?fullscreen=1\"\n" +
                    "                        }\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                \"exitFull\": {\n" +
                    "                    \"content\": [\n" +
                    "                        {\n" +
                    "                            \"ver\": \"0\",\n" +
                    "                            \"url\": \"http://imooc.com/show?exitFullscreen=1\"\n" +
                    "                        }\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                \"pause\": {\n" +
                    "                    \"content\": [\n" +
                    "                        {\n" +
                    "                            \"ver\": \"0\",\n" +
                    "                            \"url\": \"http://imooc.com/show?pause=1\"\n" +
                    "                        }\n" +
                    "                    ]\n" +
                    "                }\n" +
                    "            }\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"version\": \"3.0\"\n" +
                    "}";

    /**
     * 权限常量相关
     */
    public static final int WRITE_READ_EXTERNAL_CODE = 0x01;
    public static final String[] WRITE_READ_EXTERNAL_PERMISSION = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    public static final int HARDWEAR_CAMERA_CODE = 0x02;
    public static final String[] HARDWEAR_CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};

    public static final String IMOOC_MSG = "3";
}
