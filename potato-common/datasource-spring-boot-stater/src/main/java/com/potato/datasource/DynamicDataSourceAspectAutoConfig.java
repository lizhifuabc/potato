package com.potato.datasource;

import com.potato.datasource.annotation.DynamicAnnotation;
import com.potato.datasource.config.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 多数据源处理
 *
 * @author lizhifu
 * @date 2021/9/8
 */
@Slf4j
@Aspect
@Order(1) // 保障优先执行
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Configuration
@ConditionalOnProperty(prefix = "aspectLog", name = "enable", havingValue = "true", matchIfMissing = true)
public class DynamicDataSourceAspectAutoConfig {
    @Pointcut(value = "@annotation(com.potato.datasource.annotation.DynamicAnnotation)")
    public void methodPointcut(){}

    @Around(value= "methodPointcut() && @annotation(dynamicAnnotation)")
    public Object doAround(ProceedingJoinPoint jp, DynamicAnnotation dynamicAnnotation) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object result = null;
        try {
            HttpServletRequest request = sra.getRequest();
            HttpSession session = sra.getRequest().getSession(true);
            String tenantId = (String)session.getAttribute("tenantId");
            if (null == tenantId || tenantId.equals("")) {
                tenantId = request.getParameter("tenantId");
            }
            log.info("当前租户Id:{}", tenantId);
            DynamicDataSourceContextHolder.setDataSource(tenantId);
            result = jp.proceed();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSource();
        }
        return result;
    }
}
