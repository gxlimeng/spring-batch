package ch02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/2/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ch02/job.xml"})
public class JobLaunchTest {

    @Autowired
    private JobLauncher launcher;

    @Autowired
    private Job job;

    @Before
    public void init(){
    }

    @After
    public void destory(){
    }

    @Test
    public void execute() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();

        JobExecution result = launcher.run(job,jobParameters);
        System.out.println(result.toString());
    }
}
