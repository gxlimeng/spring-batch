package ch04;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/9.
 */
public class HelloworldTasklet implements Tasklet {

    /* (non-Javadoc)
	 * @see org.springframework.batch.core.step.tasklet.Tasklet#execute(org.springframework.batch.core.StepContribution, org.springframework.batch.core.scope.context.ChunkContext)
	 */
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        String jobName = chunkContext.getStepContext().getJobName();
        System.out.println("Execute job :" + jobName +".");
        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        System.out.println("JobParameters:" + jobParameterToString(jobParameters));
        return RepeatStatus.FINISHED;
    }

    /**
     * 转换为String类型格式.<br>
     * @param jobParameters
     * @return
     */
    private String jobParameterToString(JobParameters jobParameters){
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, JobParameter> param : jobParameters.getParameters().entrySet()) {
            sb.append(String.format(
                    "%s = %s (%s);",
                    param.getKey(),param.getValue().getValue(),param.getValue().getType()
            ));
        }
        return sb.toString();
    }
}
