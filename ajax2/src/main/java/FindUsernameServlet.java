import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/2 8:57
 * @describe
 */
@WebServlet("/findUsername")
public class FindUsernameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获取请求参数
        String username = req.getParameter("username");
//        获取输出流
        PrintWriter out = resp.getWriter();
//        模拟数据库
        if ("zhangsan".equals(username)) {
            out.println(JSON.toJSONString(false));
        } else {
            out.println(JSON.toJSONString(true));
        }
    }
}
