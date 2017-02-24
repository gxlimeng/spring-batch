package ch02;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/8.
 */
public class Ch02App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch02/job.xml");
        JobLauncher launcher = (JobLauncher) ctx.getBean("jobLauncher");
        Job job = (Job) ctx.getBean("billJob");

        try {
            JobExecution result = launcher.run(job, new JobParameters());
            System.out.println("==========" + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
