package se.ecutbildning.hala;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.ecutbildning.hala.config.AppConfig;
import se.ecutbildning.hala.data.AppUserStorage;
import se.ecutbildning.hala.service.CreateNewUserService;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

             /*   AnnotationConfigApplicationContext context =
                        new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        AppUserStorage storage = context.getBean("appUserStorageImpl",AppUserStorage.class);
        System.out.println(storage.createNewAppUser("Nisse","Nys","nisse@gmail.com"));
 */
        CreateNewUserService service = context.getBean(CreateNewUserService.class);
        System.out.println(service.createNewAppUser());
    }
}
