package springbatch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "classpath:spring-batch2.xml" });
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        Job job = (Job) context.getBean("sampleJob03");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher01");
        JobExecution result = launcher.run(job, jobParametersBuilder.toJobParameters());
        ExitStatus es = result.getExitStatus();
        if (es.getExitCode().equals(ExitStatus.COMPLETED.getExitCode())) {
            System.out.println("任务正常完成");
        } else {
            System.out.println("任务失败，exitCode=" + es.getExitCode());
        }
    }
}
