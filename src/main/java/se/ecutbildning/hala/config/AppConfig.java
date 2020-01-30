package se.ecutbildning.hala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.ecutbildning.hala.data.AppUserStorage;
import se.ecutbildning.hala.data.AppUserStorageListImpl;
//Annotation constructor/setter injection
@Configuration
@ComponentScan("se.ecutbildning.hala")
public class AppConfig {

   /* @Bean(name = "list_storage")
    public AppUserStorage appUserStorage(){
        return new AppUserStorageListImpl();
    }*/
}
