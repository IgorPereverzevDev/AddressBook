import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTest {


    @Test
    public void insert() {
        Person person = new Person();
        person.setFirstName("Bill");
        person.setSex("male");
        person.setBirthDate("11/11/11");

        Book book = new Book();
        book.insert(person);

        int expectedValues = 1;

        assertEquals(expectedValues, book.getPersons().size());

    }

    @Test
    public void getNumberOfMales() {
        Person person = new Person();
        person.setFirstName("Bill");
        person.setSex("male");
        person.setBirthDate("11/11/11");

        Book book = new Book();
        book.insert(person);
        book.getNumberOfMales();

        int expectedValues = 1;

        assertEquals(expectedValues, book.getNumberOfMales());
    }

    @Test
    public void getOldestPerson() {
        Person personOne = new Person();
        personOne.setFirstName("Bill");
        personOne.setLastName("McKnight");
        personOne.setSex("male");
        personOne.setBirthDate("11/11/11");

        Person personTwo = new Person();
        personTwo.setFirstName("Paul");
        personOne.setLastName("Robinson");
        personTwo.setSex("male");
        personTwo.setBirthDate("12/12/12");

        Book book = new Book();
        book.insert(personOne);
        book.insert(personTwo);

        assertEquals(personOne, book.getOldestPerson());

    }

    @Test
    public void diffOfAges() {
        Person personOne = new Person();
        personOne.setFirstName("Bill");
        personOne.setSex("male");
        personOne.setBirthDate("11/11/11");

        Person personTwo = new Person();
        personTwo.setFirstName("Paul");
        personTwo.setSex("male");
        personTwo.setBirthDate("12/11/11");

        Book book = new Book();
        book.insert(personOne);
        book.insert(personTwo);

        int expectedValues = 1;

        assertEquals(expectedValues, book.diffOfAges(personOne, personTwo));

    }

    @Test
    public void insertNull() {

        Book book = new Book();
        book.insert(null);

        int expectedValues = 0;

        assertEquals(expectedValues, book.getPersons().size());
    }

    @Test
    public void notUniqueNamesPerson() {
        Person personOne = new Person();
        personOne.setFirstName("Bill");
        personOne.setBirthDate("16/03/77");

        Person personTwo = new Person();
        personTwo.setFirstName("Bill");
        personTwo.setBirthDate("16/03/77");

        Book book = new Book();
        book.insert(personOne);
        book.insert(personTwo);

        int expectedValues = 2;

        assertEquals(expectedValues, book.getPersons().size());

    }
}