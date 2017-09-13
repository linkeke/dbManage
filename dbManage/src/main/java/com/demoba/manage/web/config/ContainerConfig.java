package com.demoba.manage.web.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ContainerConfig implements EmbeddedServletContainerCustomizer  {  
    /** 
     * @param container 
     * @see org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer#customize(org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer) 
     */  
    @Override  
    public void customize(ConfigurableEmbeddedServletContainer container) {  
         container.setContextPath("/dmManage");  
         container.setSessionTimeout(60*30);  //单位为S
    }  
       
}  