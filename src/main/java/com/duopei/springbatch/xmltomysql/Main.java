package com.duopei.springbatch.xmltomysql;

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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/duopei/springbatch/xmltomysql/spring-batch-xmltomysql-context.xml");
        JobLauncher jobLauncher =  (JobLauncher) ctx.getBean("jobLauncher");
        Job job =(Job) ctx.getBean("xmltoMysqlJob");
        try {
            JobExecution jobExecution = jobLauncher.run(job,new JobParameters());
            System.out.println("JOB EXIT STATUS =="+jobExecution.getStatus());
        } catch (Exception e) {
            System.out.println("JOB EXAMRESULT FAILD ..... ");
            e.printStackTrace();
        }
    }
}
