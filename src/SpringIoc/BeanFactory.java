package SpringIoc;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory工厂： 加载和缓存bean；
 */
public class BeanFactory {


    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private BeanRegister beanRegister;

    public BeanFactory() {
        //bean注册器
        beanRegister=new BeanRegister();
        // 加载资源
        this.beanDefinitionMap= ResourceLoader.getResource();
    }

    // 获取bean

    public Object getBean(String beanName){
        Object singletonObject = beanRegister.getSingletonObject(beanName);
        if (singletonObject!=null){
            return singletonObject;
        }
        //创建bean；
        return createBean(beanDefinitionMap.get(beanName));
    }


    // 创建bean
    public Object createBean(BeanDefinition beanDefinition) throws RuntimeException {

        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            // 缓存bean:
            beanRegister.registerSingletonObject(beanDefinition.getBeanName(),bean);
            return bean;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
