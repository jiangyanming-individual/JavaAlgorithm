package classloader;
import java.lang.reflect.Method;
public class TestMyClassLoader {
	public static void main(String []args) throws Exception{
		//自定义类加载器的加载路径
		MyClassLoader myClassLoader=new MyClassLoader("D:\\WorkSpace\\Java_workspace\\JavaAlgorithm\\src\\classloader\\classloader");
		//包名+类名
		Class c=myClassLoader.loadClass("Test");
		if(c!=null){
			Object obj=c.newInstance();
			Method method=c.getMethod("say", null);
			method.invoke(obj,null);
			System.out.println(c.getClassLoader().toString());
		}
	}
}
