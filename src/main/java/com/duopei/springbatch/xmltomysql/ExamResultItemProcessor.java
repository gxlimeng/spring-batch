package com.duopei.springbatch.xmltomysql;

import com.duopei.springbatch.model.ExamResult;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ExamResultItemProcessor implements ItemProcessor<ExamResult,ExamResult> {

    public ExamResult process(ExamResult item) throws Exception {
        System.out.println("PROCESS RESULT>>>" + item.toString());

        return item;
    }
}
