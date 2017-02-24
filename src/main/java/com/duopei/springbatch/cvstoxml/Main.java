package com.duopei.springbatch.cvstoxml;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/22.
 */
public class Main {

    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("com/duopei/springbatch/cvstoxml/spring-batch-context.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/duopei/springbatch/cvstoxml/spring-batch-bean-context.xml");
        JobLauncher jobLauncher =  (JobLauncher) ctx.getBean("jobLauncher");
        Job job =(Job) ctx.getBean("examResultJob");
        try {
            JobExecution jobExecution = jobLauncher.run(job,new JobParameters());
            System.out.println("JOB EXIT STATUS =="+jobExecution.getStatus());
        } catch (Exception e) {
            System.out.println("JOB EXAMRESULT FAILD ..... ");
            e.printStackTrace();
        }
    }
}
