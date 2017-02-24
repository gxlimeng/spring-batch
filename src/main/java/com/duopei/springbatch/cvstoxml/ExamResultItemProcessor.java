package com.duopei.springbatch.cvstoxml;

import com.duopei.springbatch.model.ExamResult;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Administrator on 2017/2/22.
 */
public class ExamResultItemProcessor implements ItemProcessor<ExamResult,ExamResult> {

    public ExamResult process(ExamResult item) throws Exception {
        System.out.println("PROCESS RESULT ===== "+item.toString());
        if(item.getPercentage() < 60){
            return null;
        }
        return item;
    }
}
