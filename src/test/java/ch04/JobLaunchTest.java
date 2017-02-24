package ch04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/9.
 */
public class JobLaunchTest {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch04/job-spring-scheduler.xml");
    }
}
