
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


class Person implements Comparable<Person> {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String sex;

    @Getter
    private LocalDate birthDate;

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AddressBookValues.DATE_FORMAT, Locale.ENGLISH);
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.firstName);
    }

}
