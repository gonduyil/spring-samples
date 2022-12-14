package org.uncertaintyman.spring.cmd_router;

import java.lang.reflect.Method;

public class BizMethod {

    private Object bean;

    private Method method;


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }


    public static final class CmdMethodBuilder {
        private Object bean;
        private Method method;

        private CmdMethodBuilder() {
        }

        public static CmdMethodBuilder aCmdMethod() {
            return new CmdMethodBuilder();
        }

        public CmdMethodBuilder withBean(Object bean) {
            this.bean = bean;
            return this;
        }

        public CmdMethodBuilder withMethod(Method method) {
            this.method = method;
            return this;
        }

        public BizMethod build() {
            BizMethod bizMethod = new BizMethod();
            bizMethod.setBean(bean);
            bizMethod.setMethod(method);
            return bizMethod;
        }
    }
}
