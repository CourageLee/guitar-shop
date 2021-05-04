package com.lee.paymentservice.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Map;


/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/4 11:48
 */
@RestController
public class PayController {

    @PostMapping("/alipay")
    public void alipay(@RequestBody Map<String, String> order, HttpServletResponse httpResponse) throws IOException {

        SecureRandom r= new SecureRandom();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(Config.GATEWAY_URL, Config.APP_ID, Config.APP_PRIVATE_KEY, Config.FORMAT, Config.CHARSET, Config.ALIPAY_PUBLIC_KEY, Config.SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(Config.RETURN_URL);
        request.setNotifyUrl(Config.NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String orderId = order.get("orderId");
//        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String orderSale = order.get("orderSale");
//        String total_amount =Integer.toString(r.nextInt(9999999)+1000000);
        //订单名称，必填
        String orderName = order.get("orderName");
//        String subject ="奥迪A8 2021款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
//        String body = "尊敬的会员欢迎购买奥迪A8 2021款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ orderId +"\","
                + "\"total_amount\":\""+ orderSale +"\","
                + "\"subject\":\""+ orderName +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + Config.CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}
