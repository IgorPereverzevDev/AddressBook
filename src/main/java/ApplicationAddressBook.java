import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class ApplicationAddressBook {

    public static void main(String[] args) throws IOException {
        List<String> rawData = Files.readAllLines(Paths.get(System.getProperty(AddressBookValues.HOME)
                + AddressBookValues.FILE));

        Book book = new Book();

        for (String s : rawData) {
            String[] data = s.split(AddressBookValues.DELIMITER);
            Record record = new Record();
            record.setName(data[0].trim());
            record.setSex(data[1].trim());
            record.setBirthDate(data[2].trim());
            book.insert(record);
        }
        System.out.println(book.getNumberOfMales());
        System.out.println(book.getOldestPerson());
        System.out.println(book.diffOfAges());
    }
}