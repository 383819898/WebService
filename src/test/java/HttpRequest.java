

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.CRC32;

public class HttpRequest {



    static String CRC32_PASSWORD ="CMBChina2009";
    static String CRC32_PREFIX ="Z";

    /**
     * 生成规则: CRC32_PASSWORD + key + xmlData(需去掉回车换行符) 拼接成一个字符串,通过crc32校验规则生成字符串.
     *把该字符串转换成16进制,然后再大写,如果不足八位,则左补0,最后再加前缀CRC32_PREFIX
     * @param key
     * @param xmlData
     * @return
     */
    public static String GetCheckSumWithCRC32(String key, String xmlData){
        CRC32 crc32 = new CRC32();
        String str = CRC32_PASSWORD + key + xmlData.replaceAll("\n","").replaceAll("\r", "");
        crc32.update(str.getBytes());
        String result = Long.toHexString(crc32.getValue()).toUpperCase();
        String pattern="00000000";
        return CRC32_PREFIX + pattern.substring(0, pattern.length()-result.length()) + result ;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String head ="<?xml version='1.0' encoding='GBK'?><PGK><DATA><![CDATA[";
    //    String body = "<?xml version='1.0' encoding='GB2312'?><CBSERPPGK><INFO><FUNNAM>APPAYSAV</FUNNAM></INFO><APPAYSAVX><BNKTYP>CMB</BNKTYP><BUSTYP>0</BUSTYP><CCYNBR>10</CCYNBR><CLTACC>000110100002</CLTACC><CLTNBR>0003</CLTNBR><EPTDAT>2018-11-21</EPTDAT><EPTTIM>14:23:31</EPTTIM><EXTTX1>摘要信息03</EXTTX1><OPRMOD>3</OPRMOD><OPRTYP>202</OPRTYP><REFNBR>NF0001</REFNBR><REVACC>8512384214654654</REVACC><REVBNK>招商银行科技园支行</REVBNK><REVCIT>深圳市</REVCIT><REVEML></REVEML><REVMOB></REVMOB><REVNAM>招商银行</REVNAM><REVPRV>广东省</REVPRV><TRSAMT>200.00</TRSAMT><TRSUSE>摘要信息01</TRSUSE></APPAYSAVX></CBSERPPGK>";
        String body = "<?xml version='1.0' encoding ='GBK'?>" +
                "<CBSERPPGK>" +
                "<INFO>" +
                "<FUNNAM>ERPAYBUS</FUNNAM>" +
                "</INFO>" +
                "<ERPAYBUSX>" +
                "<CLTACC>860185818910001</CLTACC>" +
                "<REVACC>6222620910032216347</REVACC>" +
                "<TRSAMT>0.11</TRSAMT>" +
                "<REFNBR>20180522ZF03</REFNBR>" +
                "</ERPAYBUSX>" +
                "</CBSERPPGK>";
        String s = GetCheckSumWithCRC32("123456", body);
        String end ="]]></DATA><CHECKCODE>"+s+"</CHECKCODE></PGK>";
        //其中127.1.0.1 是ip地址,1234 是端口号
        String sr=HttpRequest.sendPost("http://119.254.226.159:6789", head+body+end);
        System.out.println("=========================");
        System.out.println(sr);
    }
}