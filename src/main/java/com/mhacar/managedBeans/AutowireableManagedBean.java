package com.mhacar.managedBeans;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class AutowireableManagedBean {

    protected AutowireCapableBeanFactory ctx;

    @PostConstruct
    protected void init() {
        ctx = WebApplicationContextUtils
                .getWebApplicationContext(
                        (ServletContext) FacesContext.getCurrentInstance()
                                .getExternalContext().getContext())
                .getAutowireCapableBeanFactory();
        // The following line does the magic
        ctx.autowireBean(this);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        init();
    }
}
