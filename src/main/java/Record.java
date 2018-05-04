
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


class Record {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String sex;

    @Getter
    private LocalDate birthDate;

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AddressBookValues.PATTERN, Locale.ENGLISH);
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

}
