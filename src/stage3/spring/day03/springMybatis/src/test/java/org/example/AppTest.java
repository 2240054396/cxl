package org.example;

import static org.junit.Assert.assertTrue;

import com.zlt.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) context.getBean("userController");
        System.out.println(userController.login("cxl","123"));
    }
}
