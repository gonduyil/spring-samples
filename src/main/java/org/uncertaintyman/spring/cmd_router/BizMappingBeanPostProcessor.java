package org.uncertaintyman.spring.cmd_router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class BizMappingBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(BizMappingBeanPostProcessor.class);

    private static Map<String, BizMethod> cmdMethodMap = new HashMap<>();

    public static Object execute(String cmd, Object param){
        BizMethod bizMethod = cmdMethodMap.get(cmd);
        Object bean = bizMethod.getBean();
        try {
            return bizMethod.getMethod().invoke(bean, param);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(bean);

        if (AnnotationUtils.isCandidateClass(targetClass, Arrays.asList(BizRouter.class))) {

            Map<Method, BizMapping> annotatedMethods = null;
            try {

                // CmdMethod需要
                annotatedMethods = MethodIntrospector.selectMethods(targetClass,
                        (MethodIntrospector.MetadataLookup<BizMapping>) method ->
                                AnnotatedElementUtils.findMergedAnnotation(method, BizMapping.class));


                annotatedMethods.forEach((method, annotation) -> {
                    log.info("methodName:{}|annotationValue:{}", method.getName(), annotation.value());

                    BizMethod bizMethod = BizMethod.CmdMethodBuilder.aCmdMethod()
                            .withMethod(method)
                            .withBean(bean)
                            .build();
                    cmdMethodMap.put(annotation.value(), bizMethod);
                });

//                annotatedMethods.keySet().forEach(a -> {
//                    try {
//                        a.invoke("", "");
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                });

            } catch (Exception e) {

            }

        }

        return bean;
    }
}
