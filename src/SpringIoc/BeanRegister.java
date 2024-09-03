package SpringIoc;

import java.util.HashMap;
import java.util.Map;
/**
 * Bean 注册器, 用于存储和注册Bean
 */
public class BeanRegister {

    Map<String,Object> singletonMap=new HashMap<String, Object>(32);

    /**
     * 获取bean；
     */
    public Object getSingletonObject(String beanName){
        return singletonMap.get(beanName);
    }

    public void registerSingletonObject(String beanName,Object bean){
        if (singletonMap.containsKey(beanName)){
            return;
        }
        // 没有话直接注册
        singletonMap.put(beanName,bean);
    }

}
