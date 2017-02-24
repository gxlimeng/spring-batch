package ch02;

import org.springframework.batch.item.ItemProcessor;

/**
 * 数据处理类（输入、输出）
 * Created by Administrator on 2017/2/8.
 */
public class PersonProcessor implements ItemProcessor<Person,Person>{

    public Person process(Person item) throws Exception {
        System.out.println(">>=" + item.toString());
        return item;
    }
}
