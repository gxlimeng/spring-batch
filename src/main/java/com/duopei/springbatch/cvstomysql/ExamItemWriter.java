package com.duopei.springbatch.cvstomysql;

import com.duopei.springbatch.model.ExamResult;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class ExamItemWriter implements ItemWriter<ExamResult> {

    private final String GET_EXAM_QUERY = "select count(1) from EXAM_RESULT where student_name = ? ";

    private final String UPDATE_EXAM_QUERY = "update EXAM_RESULT set percentage = ? where student_name = ? ";

    private final String INSERT_EXAM_QUERY = "insert into EXAM_RESULT(student_name,dob,percentage) values(?,?,?) ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void write(List<? extends ExamResult> items) throws Exception {
        for (ExamResult item : items) {
            System.out.println("===========" + item.toString());
            // 业务处理
            Integer count = jdbcTemplate.queryForInt(GET_EXAM_QUERY,new Object[]{item.getStudentName()});
            if(count > 0 ){
                System.out.println(" count = "+count);
                jdbcTemplate.update(UPDATE_EXAM_QUERY,new Object[]{0, item.getStudentName()});
            }
            jdbcTemplate.update(INSERT_EXAM_QUERY, new Object[]{item.getStudentName(),new Date(item.getDob().toDate().getTime()),item.getPercentage()});

        }
    }
}
