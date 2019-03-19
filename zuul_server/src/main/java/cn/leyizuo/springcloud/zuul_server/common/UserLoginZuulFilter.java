package cn.leyizuo.springcloud.zuul_server.common;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserLoginZuulFilter extends ZuulFilter {
    //可以重写n个过滤器
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //这个是zuulRequestContext
        RequestContext requestContext = RequestContext.getCurrentContext();
        //实例出一个HttpServlet
        HttpServletRequest httpServletRequest=requestContext.getRequest();
        //从请求参数中获取toke
        String token = httpServletRequest.getParameter("token");
        if(StringUtils.hasText(token)){
            //这个是不过滤的
            return null;
        }else{
            //停止继续执行
            requestContext.setSendZuulResponse(false);
            //返回未登录
            requestContext.setResponseStatusCode(401);
            return null;
        }

    }
}
