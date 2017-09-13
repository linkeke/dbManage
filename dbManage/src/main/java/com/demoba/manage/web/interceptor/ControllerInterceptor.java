package com.demoba.manage.web.interceptor;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demoba.manage.web.entity.SystemUser;
import com.demoba.manage.web.system.service.PermissionService;
import com.owl.common.content.Status;
import com.owl.common.content.SysContent;
import com.owl.common.util.Help;
import com.owl.common.util.Result;

@Aspect
@Component
@Order(-5)
public class ControllerInterceptor {
	private static final Logger log= LoggerFactory.getLogger(ControllerInterceptor.class);
	@Autowired
	private PermissionService permissionService;
    /**
     * 定义一个切入点.
     * 解释下：
     *
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在web包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
     @Pointcut("execution(public * com.xiaoyuan.manage.web.*.controller.*.*Controller(..))")
     public void permission(){}
     
     @Before("permission()")
     public void doBefore(JoinPoint joinPoint){
        
       // 接收到请求，记录请求内容
    
    	    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
           
      // 记录下请求内容
       //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames(); 
        while(enu.hasMoreElements()){ 
            String paraName=(String)enu.nextElement(); 
            System.out.println(paraName+": "+request.getParameter(paraName)); 
        } 
     }
     @Around("permission()")
     public Object around(ProceedingJoinPoint thisJoinPoint){
         System.err.println ("切面执行了。。。。");
         Object proceed = null;
         Result result = new Result();
         try {
        	    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                SystemUser loginUser = (SystemUser) request.getSession().getAttribute("user");
                if(Help.isNull(loginUser)){
                	//登录拦截
                	log.debug("登录超时！重新登录");
	        		result.setStatus(Status.login_timeout_status);
	        		result.setInfo(Status.login_timeout_info);
	        		return result;
                }else{
                	//权限拦截
                	 String requestURI = request.getRequestURI();
 	    	        String contextPath = request.getContextPath();
 	    	        String permitStr=requestURI.replace(contextPath, "");
 	    	        boolean permitted=isPermission(permitStr,loginUser.getnUserId());
 	    	        if(!permitted){
 	    	        	log.debug("权限不足！！");
    	        		result.setStatus(Status.access_deny_status);
    	        		result.setInfo(Status.access_deny_info);
    	        		return result;
 	    	        }
                	
                }
                
                proceed = thisJoinPoint.proceed();
                
         } catch (Throwable e) {
             e.printStackTrace ();
         }
         return proceed;
     }
     @AfterReturning("permission()")
     public void  doAfterReturning(JoinPoint joinPoint){
       // 处理完请求，返回内容
     }
     /**
     * 判断ajax请求
     * @param request
     * @return
     */
    boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString())   ) ;
    }
    boolean isPermission(String permitStr,Long userId){
    	if("/user/userMenus.do".equals(permitStr)||"/user/userInfo.do".equals(permitStr)||"/system/resetPwd.do".equals(permitStr)){
    		return true;
    	}
    	HttpServletRequest request = SysContent.getRequest();
	        HttpServletResponse response = SysContent.getResponse();
		Map<String, Object> authorization = permissionService.authorization(userId);
		List<String> permissions = (List<String>) authorization.get("permissions");
		if(Help.isNotNull(permissions)&&permissions.contains(permitStr)){
			return true;
		}else{
			return false;
		}
    }
}
