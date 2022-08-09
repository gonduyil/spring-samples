package org.kwdixu.spring.cmd_router;

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
public class CmdMappingBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CmdMappingBeanPostProcessor.class);

    private static Map<String, CmdMethod> cmdMethodMap = new HashMap<>();

    public static Object execute(String cmd, Object param){
        CmdMethod cmdMethod = cmdMethodMap.get(cmd);
        Object bean = cmdMethod.getBean();
        try {
            return cmdMethod.getMethod().invoke(bean, param);
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

        if (AnnotationUtils.isCandidateClass(targetClass, Arrays.asList(CmdRouter.class))) {

            Map<Method, CmdMapping> annotatedMethods = null;
            try {

                // CmdMethod需要
                annotatedMethods = MethodIntrospector.selectMethods(targetClass,
                        (MethodIntrospector.MetadataLookup<CmdMapping>) method ->
                                AnnotatedElementUtils.findMergedAnnotation(method, CmdMapping.class));


                annotatedMethods.forEach((method, annotation) -> {
                    log.info("methodName:{}|annotationValue:{}", method.getName(), annotation.value());

                    CmdMethod cmdMethod = CmdMethod.CmdMethodBuilder.aCmdMethod()
                            .withMethod(method)
                            .withBean(bean)
                            .build();
                    cmdMethodMap.put(annotation.value(), cmdMethod);
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
