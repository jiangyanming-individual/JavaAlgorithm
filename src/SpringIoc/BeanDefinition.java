package SpringIoc;

/**
 * bean的定义类
 */
public class BeanDefinition {

    private String beanName;

    private Class beanClass;

    public BeanDefinition() {
    }

    public BeanDefinition(String beanName, Class beanClass) {
        this.beanName = beanName;
        this.beanClass = beanClass;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
