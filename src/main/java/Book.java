import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Data
class Book implements Repository {

    private List<Person> persons;
    private NavigableMap<LocalDate, Person> mapBirthDates;

    Book() {
        this.persons = new ArrayList<>();
        this.mapBirthDates = new TreeMap<>();
    }

    public void insert(Person person) {
        if (person != null && person.getBirthDate() != null) {
            persons.add(person);
            mapBirthDates.put(person.getBirthDate(), person);
        }
    }

    public long getNumberOfMales() {
        return persons.isEmpty() ? 0 : persons.stream()
                .filter(s -> s.getSex().equalsIgnoreCase(AddressBookValues.MALE))
                .count();
    }


    public Person getOldestPerson() {
        return mapBirthDates.isEmpty() ? Optional.ofNullable(mapBirthDates.firstEntry()).get().getValue()
                : mapBirthDates.firstEntry().getValue();
    }


    public long diffOfAges(Person one, Person two) {
        if (!persons.isEmpty() && persons.size() >= 2 && one != null && two != null) {
            persons.sort(Comparator.naturalOrder());
            LocalDate dateBirthdayFirstPerson = persons.get(Collections.binarySearch(persons, one)).getBirthDate();
            LocalDate dateBirthdaySecondPerson = persons.get(Collections.binarySearch(persons, two)).getBirthDate();
            if (dateBirthdayFirstPerson != null && dateBirthdaySecondPerson != null) {
                return Math.abs(ChronoUnit.DAYS.between(dateBirthdayFirstPerson, dateBirthdaySecondPerson));
            }
        }
        return 0;
    }
}