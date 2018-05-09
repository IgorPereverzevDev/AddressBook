import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ApplicationAddressBook {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> rawData;
        System.out.print("Enter the path to the file: ");
        System.out.flush();
        String input = scanner.nextLine();
        Path path = Paths.get(input);
        if (input.length() != 0 && Files.isRegularFile(path)) {
            rawData = Files.readAllLines(path);
        } else {
            rawData = Files.readAllLines(Paths.get(System.getProperty(AddressBookValues.HOME_DIRECTORY)
                    + AddressBookValues.SOLIDUS + AddressBookValues.FILE));
        }

        scanner.close();
        cleanup(path);

        Book book = fillingByData(rawData);

        System.out.println("The number of men = " + book.getNumberOfMales());
        System.out.println("The oldest person: " + book.getOldestPerson().getFirstName() + " "
                + book.getOldestPerson().getLastName());

        Person personOne = new Person();
        personOne.setFirstName("Bill");

        Person personTwo = new Person();
        personTwo.setFirstName("Paul");

        System.out.println(personOne.getFirstName() + " is older than " + personTwo.getFirstName() + " on " +
                book.diffOfAges(personOne, personTwo) + " days");
    }

    private static Book fillingByData(List<String> rawData) {
        Book book = new Book();
        if (rawData.size() == 0) {
            Collections.fill(Collections.singletonList(rawData), 0);
        }
        for (String s : rawData) {
            String[] data = s.split(AddressBookValues.COMMA);
            Person person = new Person();
            person.setFirstName(data[0].split(" ")[0]);
            person.setLastName(data[0].split(" ")[1]);
            person.setSex(data[1].trim());
            person.setBirthDate(data[2].trim());
            book.insert(person);
        }
        return book;
    }

    private static void cleanup(Path dir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                if (file.getFileName().endsWith(AddressBookValues.FILE)) {
                    try {
                        Files.delete(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        Files.delete(file);
                    }
                }
            }

        }
    }
}