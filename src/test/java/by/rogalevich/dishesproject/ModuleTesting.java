package by.rogalevich.dishesproject;

import org.junit.Test;
import javax.mail.MessagingException;

public class ModuleTesting {
    @Test
    public void emailTest() throws MessagingException {
        SendEmail e = new SendEmail();
        e.SendSimpleEmail("testing", "module test", "student.it.rvs@gmail.com");
    }

}
