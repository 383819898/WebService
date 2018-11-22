import java.security.MessageDigest;
import java.util.Arrays;

public final class test1 {
      
    /** 
     * 单例持有类 
     * @author liguocai 
     * 
     */  
    private static class SingletonHolder{  
        static final test1 INSTANCE = new test1();  
    }  
      
    /** 
     * 获取单例 
     * @return 
     */  
    public static test1 getInstance() {  
        return SingletonHolder.INSTANCE;  
    }  
      
    private MessageDigest digest;
      
    private test1() {  
        try {  
            digest = MessageDigest.getInstance("SHA-1");
        } catch(Exception e) {  
            throw new InternalError("init MessageDigest error:" + e.getMessage());  
        }  
    }  
  
      
  
    /** 
     * 将字节数组转换成16进制字符串 
     * @param b 
     * @return 
     */  
    private static String byte2hex(byte[] b) {  
        StringBuilder sbDes = new StringBuilder();  
        String tmp = null;  
        for (int i = 0; i < b.length; i++) {  
            tmp = (Integer.toHexString(b[i] & 0xFF));  
            if (tmp.length() == 1) {  
                sbDes.append("0");  
            }  
            sbDes.append(tmp);  
        }  
        return sbDes.toString();  
    }  
      
    private String encrypt(String strSrc) {  
        String strDes = null;  
        byte[] bt = strSrc.getBytes();  
        digest.update(bt);  
        strDes = byte2hex(digest.digest());  
        return strDes;  
    }  
  
    /** 
     * 校验请求的签名是否合法 
     *  
     * 加密/校验流程： 
     * 1. 将token、timestamp、nonce三个参数进行字典序排序 
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密 
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信 
     * @param signature 
     * @param timestamp 
     * @param nonce 
     * @return 
     */  
    public boolean validate(String signature, String timestamp, String nonce){  
        //1. 将token、timestamp、nonce三个参数进行字典序排序  
        String token = getToken();  
        String[] arrTmp = { token, timestamp, nonce };
        Arrays.sort(arrTmp);
        StringBuffer sb = new StringBuffer();  
        //2.将三个参数字符串拼接成一个字符串进行sha1加密  
        for (int i = 0; i < arrTmp.length; i++) {
            sb.append(arrTmp[i]);  
        }  
        String expectedSignature = encrypt(sb.toString());


        //3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信  
        System.out.println(expectedSignature);
        if(expectedSignature.equals(signature)){  
            return true;  
        }  
        return false;  
    }  
      
    private String getToken(){  
        return "Ba800CEb80968de49EE1144a3E18e89b";
    }  
  
    public static void main(String[] args) {
  //      be6af162d71638ded85612bb67289fd9fdd78150
        String signature="7654f10600d0c2825d481991406508eca2302ac6";//加密需要验证的签名
/*        String timestamp="1477825310";//时间戳
        String nonce="458263696";//随机数*/
        
        String nonce=(int )(Math.random()*999999999)+"";//随机数
        
        String timestamp=System.currentTimeMillis()+"";//时间戳

        System.out.println(System.currentTimeMillis());
        System.out.println(nonce);
        test1 wxDigest = test1.getInstance();  
        boolean bValid = wxDigest.validate(signature, timestamp, nonce);
        if (bValid) {  
            System.out.println("token 验证成功!");  
        }else {  
            System.out.println("token 验证失败!");  
        }  
    }  
  
} 
