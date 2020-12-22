package guru.springframework.sfgpetclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SfgPetClinicApplication {


    public static void main(String[] args) {

        //@Autowired
        ApplicationContext ctx=SpringApplication.run(SfgPetClinicApplication.class, args);

        System.out.println("ciaocinjjjao");



      // String[] sol=ctx.getBeanDefinitionNames();

        //Arrays.stream(sol).forEach(System.out::println);
    }

}
