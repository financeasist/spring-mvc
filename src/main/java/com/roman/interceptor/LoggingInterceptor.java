package com.roman.interceptor;

import com.roman.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * Created by roman.hrupskyi on 6/13/2017.
 */
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.debug("---Before Method Execution---");
        String controllerName = "";
        String actionName = "";
        String requestUrl = request.getRequestURL().toString();
        Map<String, String> headersInfo = WebUtils.getRequestHeadersInfo(request);

        if (handler instanceof HandlerMethod) {
            // there are cases where this handler isn't an instance of HandlerMethod, so the cast fails.
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            controllerName = handlerMethod.getBean().getClass().getSimpleName();//.replace("Controller", "");
            actionName = handlerMethod.getMethod().getName();
        }

        logger.debug("controller : {}", controllerName);
        logger.debug("method: {} ", actionName);
        logger.debug("url : {} ", requestUrl);
        logger.debug("request headers : ");
        for (Map.Entry<String, String> entry : headersInfo.entrySet()) {
            logger.debug("{} : {} ", entry.getKey(), entry.getValue());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        Map<String, String> headersInfo = WebUtils.getResponseHeadersInfo(response);
        logger.debug("---method executed---");
        logger.debug("response headers : ");
        for (Map.Entry<String, String> entry : headersInfo.entrySet()) {
            logger.debug("{} : {} ", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        logger.debug("---Request Completed---");
    }
}
