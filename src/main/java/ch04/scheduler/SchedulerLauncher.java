package ch04.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/9.
 */
public class SchedulerLauncher {

    private Job job;
    private JobLauncher jobLauncher;

    public void  launch() throws Exception {
        JobParameters jobParameter = new JobParametersBuilder().addDate("executeDate",new Date()).toJobParameters();
        jobLauncher.run(job,jobParameter);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }
}
