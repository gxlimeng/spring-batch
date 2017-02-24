package com.duopei.springbatch.xmltomysql;

import com.duopei.springbatch.model.ExamResult;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ExamResultItemPreparedStatementSetter implements ItemPreparedStatementSetter<ExamResult> {

    public void setValues(ExamResult item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getStudentName());
        ps.setDate(2, new java.sql.Date(item.getDob().toDate().getTime()));
        ps.setDouble(3, item.getPercentage());
    }
}
