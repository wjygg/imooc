package com.youdu.network.http;

/**
 * @author: vision
 * @function:
 * @date: 16/8/12
 */
public class HttpConstants {

    private static final String ROOT_URL = "http://qjtest.qianjing.com";

    /**
     * 请求本地产品列表
     */
    public static String PRODUCT_LIST = ROOT_URL + "/fund/search.php";

    /**
     * 本地产品列表更新时间措请求
     */
    public static String PRODUCT_LATESAT_UPDATE = ROOT_URL + "/fund/upsearch.php";

    /**
     * 登陆接口
     */
    public static String LOGIN = ROOT_URL + "/user/login_phone.php";

    /**
     * 检查更新接口
     */
    public static String CHECK_UPDATE = ROOT_URL + "/config/check_update.php";

    /**
     * 首页产品请求接口
     */
    public static String HOME_RECOMMAND = ROOT_URL + "/product/home_recommand.php";


}
