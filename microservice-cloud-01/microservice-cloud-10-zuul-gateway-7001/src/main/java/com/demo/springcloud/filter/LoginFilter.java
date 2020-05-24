package com.demo.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class LoginFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        //请求路由前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //int值来定义过滤器的执行顺序，数值越小优先级越高
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //该过滤器是否执行，true执行，false不执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest(); //获取请求参数token的值

        String token = null;
        try {
            token = request.getParameter("token");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        if (token == null) {
            logger.warn("此操作需要先登录系统...");
            // 拒绝访问
            context.setSendZuulResponse(false);
            // 设置响应状态码
            context.setResponseStatusCode(200);
            try {
                //响应结果
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
