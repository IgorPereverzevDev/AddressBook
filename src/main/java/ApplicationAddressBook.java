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
            for (int i = 0; i < data.length; ++i) {
                Record record = new Record();
                record.setName(data[i].trim());
                record.setSex(data[++i].trim());
                record.setBirthDate(data[++i].trim());
                book.insert(record);
            }
        }
        System.out.println(book.getNumberOfMales());
        System.out.println(book.getOldestPerson());
        System.out.println(book.diffOfAges());
    }
}