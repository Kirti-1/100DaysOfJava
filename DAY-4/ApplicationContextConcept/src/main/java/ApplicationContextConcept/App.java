package secondproject;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("spring.xml"));
		//It won't instantiate alien object unless requested -- lazy loading
		Alien alien = (Alien) factory.getBean("alien");
		alien.code();
		
		
		//As soon as context initiated bean is created -- eagerly loading bean
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
		//Even if we comment the below line or will not request the bean for alien class by deafult single class will be created -- singleton scope
		// -- Eagerly Loading Beans -- 
		Alien alien1 = (Alien) context.getBean("alien");
		alien1.code();
	
	}
}
