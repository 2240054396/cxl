package test;

import entity.Entity;
import entity.UserController;
import entity.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) applicationContext.getBean("userController");
        UserService userService = userController.getUserService();
        userService.method();
        UserController bean = (UserController) applicationContext.getBean("entity.UserController#0");
        bean.getUserService().method();
        Entity entity = (Entity) applicationContext.getBean("entity.Entity#0");
        System.out.println(entity);
        Entity entity1 = (Entity) applicationContext.getBean("entity.Entity#1");
        System.out.println(entity1);
    }
}
