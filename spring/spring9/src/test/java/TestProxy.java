import com.spring9.handler.CgLibProxy;
import com.spring9.handler.PreformHandler;
import com.spring9.service.LoginService;
import com.spring9.service.impl.LoginServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author: bai
 * @date: 2022/4/22 8:20
 * @description: Spring Aop动态代理实现寄机制
 */
public class TestProxy {
    /**
     * jdk
     */
    @Test
    public void testPreformHandler() {
        //目标对象
        LoginService loginService = new LoginServiceImpl();
        //处理器
        PreformHandler preformHandler = new PreformHandler(loginService);
        //创建代理对象
        loginService = (LoginService) Proxy.newProxyInstance(loginService.getClass().getClassLoader(),
                loginService.getClass().getInterfaces(), preformHandler);
        loginService.login();
    }

    /**
     * cgLib
     */
    @Test
    public void testCglibProxy() {
        CgLibProxy cgLibProxy = new CgLibProxy();
        LoginServiceImpl loginService = (LoginServiceImpl) cgLibProxy.getProxy(LoginServiceImpl.class);
        loginService.login();
    }
}
