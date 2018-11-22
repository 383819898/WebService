package com.risechina.inter;
import org.apache.ws.security.WSPasswordCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
 
 
public class DemoServerPasswordCallback implements CallbackHandler {
    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        String pw = pc.getPassword();
        String idf = pc.getIdentifier();
        //特别注意的是 这里的pw肯是null, 无论你password是否传值。cxf 2.4之后，
        //密码的比较是框架自动帮我们完成，因此不需要我们获取传递过来的密码，如果你
        //一定要查看密码的话,可以通过new String(pc.getKey())获取。在该回调函数中
        //我们只需要使用 idf 从数据库中查询出密码，使用pc.setPassword()方法将密码设
        //置进去,框架获取的的密码后会进行比较，并通过抛出异常的方式提示验证出错。
        System.out.println("密码是: " + pw);
        System.out.println("身份是: " + idf);
        //根据idf 我们从数据中查询出的密码 假如是 "abc"
        pc.setPassword("abc");
    }
}
