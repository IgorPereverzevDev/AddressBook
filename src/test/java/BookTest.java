import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {


    @Test
    public void insert() {
        Record record = new Record();
        record.setName("Bill");
        record.setSex("male");
        record.setBirthDate("11/11/11");

        Book book = new Book();
        book.insert(record);

        int expectedValues = 1;

        assertEquals(expectedValues, book.getMap().size());
    }

    @Test
    public void getNumberOfMales() {
        Record record = new Record();
        record.setName("Bill");
        record.setSex("male");
        record.setBirthDate("11/11/11");

        Book book = new Book();
        book.insert(record);
        book.getNumberOfMales();

        int expectedValues = 1;

        assertEquals(expectedValues, book.getNumberOfRecords());
    }

    @Test
    public void getOldestPerson() {
        Record recordOne = new Record();
        recordOne.setName("Bill");
        recordOne.setSex("male");
        recordOne.setBirthDate("11/11/11");

        Record recordTwo = new Record();
        recordTwo.setName("Paul");
        recordTwo.setSex("male");
        recordTwo.setBirthDate("12/12/12");

        Book book = new Book();
        book.insert(recordOne);
        book.insert(recordTwo);

        String expectedValues = "Bill";

        assertEquals(expectedValues, book.getOldestPerson());

    }

    @Test
    public void diffOfAges() {
        Record recordOne = new Record();
        recordOne.setName("Bill");
        recordOne.setSex("male");
        recordOne.setBirthDate("11/11/11");

        Record recordTwo = new Record();
        recordTwo.setName("Paul");
        recordTwo.setSex("male");
        recordTwo.setBirthDate("12/11/11");

        Book book = new Book();
        book.insert(recordOne);
        book.insert(recordTwo);

        int expectedValues = 1;

        assertEquals(expectedValues, book.diffOfAges());

    }

    @Test
    public void insertNull() {

    Book book = new Book();
        book.insert(null);

                int expectedValues = 0;

                assertEquals(expectedValues, book.getMap().size());

                }
                }