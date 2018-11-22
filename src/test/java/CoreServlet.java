
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoreServlet extends HttpServlet {
 
    private static final long serialVersionUID = -7002640712248365625L;
    String TAG = "CoreServlet";
 
    /*
     * 1）、包括内容 服务器配置主要是当我们写好自己的接入微信开发平台的代码之后要配置的服务器和微信接入接口。 2）、服务器操作
     * 打开服务器的tomcat,将写好的代码放到webapps文件下。 3）、微信公众平台操作
     * 申请微信测试账号（直接用微信扫一扫即可以登录）：http:/
     * /mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login
     * 打开微信公众平台测试号，配置接口配置信息。配置如下 URL:http://ip/WeixinApiDemo/CoreServlet
     * Token:wgyscsf提交，配置成功和失败均会有提醒。 第二步：验证服务器地址的有效性
     * 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上，
     * GET请求携带四个参数：signature、timestamp、nonce、echostr
     * 开发者通过检验signature对请求进行校验（下面有校验方式）。 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，
     * 则接入生效， 成为开发者成功，否则接入失败。
     *
     * 加密/校验流程如下： 1. 将token、timestamp、nonce三个参数进行字典序排序 2.
     * 将三个参数字符串拼接成一个字符串进行sha1加密 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    /*
     * 字典排序（lexicographical
     * order）是一种对于随机变量形成序列的排序方法。其方法是，按照字母顺序，或者数字小大顺序，由小到大的形成序列。
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("html/text;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        // 获取输出流
        PrintWriter printWriter = resp.getWriter();
 
        // 设置一个全局的token,开发者自己设置。api这样解释：Token可由开发者可以任意填写，
        // 用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）
        String token = "reyo";
        // 根据api说明，获取上述四个参数
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        // // temp:临时打印，观看返回参数情况
        System.out.println(TAG + ":signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce + ",echostr:" + echostr);
        // 根据api所说的“加密/校验流程”进行接入。共计三步
 
        // 第一步:将token、timestamp、nonce三个参数进行字典序排序
        String[] parms = new String[] { token, timestamp, nonce };// 将需要字典序排列的字符串放到数组中
        Arrays.sort(parms);// 按照api要求进行字典序排序
        // 第二步:将三个参数字符串拼接成一个字符串进行sha1加密
        // 拼接字符串
        String parmsString = "";// 注意，此处不能=null。
        for (int i = 0; i < parms.length; i++) {
            parmsString += parms[i];
        }
        // sha1加密
        String mParms = null;// 加密后的结果
        MessageDigest digest = null;
        try {
            digest = java.security.MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        digest.update(parmsString.getBytes());
        byte messageDigest[] = digest.digest();
        // Create Hex String
        StringBuffer hexString = new StringBuffer();
        // 字节数组转换为 十六进制 数
        for (int i = 0; i < messageDigest.length; i++) {
            String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        mParms = hexString.toString();// 加密结果
 
        /*
         * api要求： 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容， 则接入生效， 成为开发者成功，否则接入失败。
         */
        // 第三步： 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信接入成功。
        System.out.println(TAG + ":" + mParms + "---->" + signature);
        if (mParms.equals(signature)) {
            System.out.println(TAG + ":" + mParms + "---->" + signature);
            printWriter.write("echostr:" + echostr);
        } else {
            // 接入失败,不用回写
            System.out.println(TAG + "接入失败");
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
 
}