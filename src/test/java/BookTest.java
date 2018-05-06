import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void fileIsEmptyDiffOfAgesZero() throws IOException {
        String fileName = System.getProperty(AddressBookValues.HOME_DIRECTORY)+ "/Readme1.txt";
        Path path = Paths.get(fileName);
        Files.createDirectories(path.getParent());
        Files.createFile(Paths.get(fileName));

        List<String> rawData = Files.readAllLines(Paths.get(fileName));

        Files.deleteIfExists(path);

        Book book = new Book();
        Person person = new Person();
        String[] data = rawData.get(0).split(AddressBookValues.DELIMITER);
        person.setFirstName(data[0].split(" ")[0]);
        person.setLastName(data[0].split(" ")[1]);
        person.setSex(data[1].trim());
        person.setBirthDate(data[2].trim());
        book.insert(person);

        Person personOne = new Person();
        personOne.setFirstName("Bill");

        Person personTwo = new Person();
        personTwo.setFirstName("Paul");

        int expectedValues = 0;

        assertEquals(expectedValues, book.diffOfAges(personOne, personTwo));

    }

    @Test
    public void fileIsEmptyGetNumberOfMalesZero() throws IOException {
        String fileName = System.getProperty(AddressBookValues.HOME_DIRECTORY) + "/Readme1.txt";
        Path path = Paths.get(fileName);
        Files.createDirectories(path.getParent());
        Files.createFile(Paths.get(fileName));

        List<String> rawData = Files.readAllLines(Paths.get(fileName));

        Files.deleteIfExists(path);

        Book book = new Book();
        Person person = new Person();
        String[] data = rawData.get(0).split(AddressBookValues.DELIMITER);
        person.setFirstName(data[0].split(" ")[0]);
        person.setLastName(data[0].split(" ")[1]);
        person.setSex(data[1].trim());
        person.setBirthDate(data[2].trim());
        book.insert(person);

        int expectedValues = 0;

        assertEquals(expectedValues, book.getNumberOfMales());

    }

    @Test
    public void fileIsEmptyGetOldestPersonNoN() throws IOException {
        String fileName = System.getProperty(AddressBookValues.HOME_DIRECTORY);
        Path path = Paths.get(fileName);
        Files.createDirectories(path.getParent());
        Files.createFile(Paths.get(fileName));

        List<String> rawData = Files.readAllLines(Paths.get(fileName));

        Files.deleteIfExists(path);

        Book book = new Book();
        Person person = new Person();
        String[] data = rawData.get(0).split(AddressBookValues.DELIMITER);
        person.setFirstName(data[0].split(" ")[0]);
        person.setLastName(data[0].split(" ")[1]);
        person.setSex(data[1].trim());
        person.setBirthDate(data[2].trim());
        book.insert(person);

        int expectedValues = 0;

        assertEquals(expectedValues, rawData.size());

    }
}