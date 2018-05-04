import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


@Data
class Book implements Repository {

    private Map<Integer, Record> map;
    private int count;
    private int numberOfRecords;

    Book() {
        this.map = new TreeMap<>();
    }

    public void insert(Record record) {
        if (record != null) {
            map.put(++count, record);
        }
    }

    public int getNumberOfMales() {
        map.forEach((key, value) -> {
            if (value.getSex().equalsIgnoreCase(AddressBookValues.SEX)) {
                ++numberOfRecords;
            }
        });
        return numberOfRecords;
    }


    public String getOldestPerson() {
        return recordsSortedByValues(map).first().getValue().getName();
    }

    public long diffOfAges() {
        LocalDate dateBirthdayFirstPerson = LocalDate.MIN;
        LocalDate dateBirthdaySecondPerson = LocalDate.MAX;
        for (Map.Entry<Integer, Record> entry : map.entrySet()) {
            if (entry.getValue().getName().split(" ")[0].equalsIgnoreCase("Paul")) {
                dateBirthdaySecondPerson = entry.getValue().getBirthDate();
                continue;
            }
            if (entry.getValue().getName().split(" ")[0].equalsIgnoreCase("Bill")) {
                dateBirthdayFirstPerson = entry.getValue().getBirthDate();
            }
        }
        return Math.abs(ChronoUnit.DAYS.between(dateBirthdayFirstPerson, dateBirthdaySecondPerson));
    }


    private <K> SortedSet<Map.Entry<K, Record>> recordsSortedByValues(Map<K, Record> map) {
        SortedSet<Map.Entry<K, Record>> sortedEntries = new TreeSet<>((e1, e2) -> {
            int res = e1.getValue().getBirthDate().compareTo(e2.getValue().getBirthDate());
            return res != 0 ? res : 1;
        });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }


}
