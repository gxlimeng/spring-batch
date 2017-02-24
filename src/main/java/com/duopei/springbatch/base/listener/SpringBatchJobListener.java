package com.duopei.springbatch.base.listener;

import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class SpringBatchJobListener implements JobExecutionListener {

    private DateTime startTime,stopTime;

    public void beforeJob(JobExecution jobExecution) {
        startTime = new DateTime();
        System.out.println("ExamResult job start at "+startTime);
    }

    public void afterJob(JobExecution jobExecution) {
        stopTime = new DateTime();
        System.out.println("ExamResult job stops at "+stopTime);
        System.out.println("Totle time take in millis" + (stopTime.getMillis() - startTime.getMillis()));

        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("ExamResult job completed successfully");
        }else if(jobExecution.getStatus() == BatchStatus.FAILED){
            System.out.println("ExamResult job faild with flowering exception=== ");
            List<Throwable> exceptionList  = jobExecution.getAllFailureExceptions();
            for (Throwable th : exceptionList) {
                System.err.println("exception ===="+th.getLocalizedMessage());
            }
        }
    }
}
