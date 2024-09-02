package SpringIoc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 *资源加载器
 */
public class ResourceLoader {
    /**
     * 读取配置文件中的配置
     * @return
     */
    public static Map<String, BeanDefinition> getResource(){
        Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(16);
        Properties properties = new Properties();
        try {
            InputStream inputStream = ResourceLoader.class.getResourceAsStream("SpringIoc/beans.properties");
            System.out.println(inputStream);
            properties.load(inputStream);
            // 获取属性
            Iterator<String> iterator = properties.stringPropertyNames().iterator();
            while (iterator.hasNext()){
                //读取文件的属性：
                String key = iterator.next();
                String className= properties.getProperty(key);
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanName(key);
                // 反射
                Class<?> clazz = Class.forName(className);
                beanDefinition.setBeanClass(clazz);
                beanDefinitionMap.put(key,beanDefinition);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return beanDefinitionMap;

    }
}
