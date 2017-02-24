package springbatch;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Administrator on 2017/2/7.
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        final Person transformedPerson = new Person(firstName, lastName);
        System.out.println("Converting (" + person + ") into ("
                + transformedPerson + ")");
        return transformedPerson;
    }

}
