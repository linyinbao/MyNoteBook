package web_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求路径
        String requestURI = req.getRequestURI();//brand_case/BrandServlet/method
        //获取对应的最后一段路径
        int index = requestURI.lastIndexOf("/");
        String methodName = requestURI.substring(index + 1);
        //执行方法
        //获取BrandServlet的字节码对象
        Class<? extends BaseServlet> c = this.getClass();//这里的this代表调用service方法的对象即BrandServlet

        //获取method对象
        try {
            Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
