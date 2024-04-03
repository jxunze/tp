package seedu.address.model.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.ArchiveStatus;
import seedu.address.model.person.BankDetails;
import seedu.address.model.person.Name;
import seedu.address.model.person.PayRate;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Sex;
import seedu.address.model.person.WorkHours;
import seedu.address.model.schedule.Schedule;
import seedu.address.model.schedule.ScheduleManager;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(
                new Name("Alex"),
                new Name("Yeoh"),
                new Phone("87438807"),
                new Sex("m"),
                new PayRate(14.5),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                new BankDetails("dbs 1234567890"),
                new WorkHours(),
                getTagSet("friends"),
                new ArchiveStatus(false)),
            new Person(
                new Name("Bernice"),
                new Name("Yu"),
                new Phone("99272758"),
                new Sex("f"),
                new PayRate(16),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new BankDetails("ocbc 1234567"),
                new WorkHours(),
                getTagSet("colleagues", "friends"),
                new ArchiveStatus(false)),
            new Person(
                new Name("Charlotte"),
                new Name("Oliveiro"),
                new Phone("93210283"),
                new Sex("f"),
                new PayRate(20),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                new BankDetails("hsbc 0987654321"),
                new WorkHours(),
                getTagSet("neighbours"),
                new ArchiveStatus(false)),
            new Person(
                new Name("David"),
                new Name("Li"),
                new Phone("91031282"),
                new Sex("m"),
                new PayRate(18.5),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                new BankDetails("uob 8888777700"),
                new WorkHours(),
                getTagSet("family"),
                new ArchiveStatus(false)),
            new Person(
                new Name("Irfan"),
                new Name("Ibrahim"),
                new Phone("92492021"),
                new Sex("m"),
                new PayRate(16.5),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                new BankDetails("posb 369369369"),
                new WorkHours(),
                getTagSet("classmates"),
                new ArchiveStatus(false)),
            new Person(
                new Name("Roy"),
                new Name("Balakrishnan"),
                new Phone("92624417"),
                new Sex("m"),
                new PayRate(10),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                new BankDetails("ocbc 7654321"),
                new WorkHours(),
                getTagSet("colleagues"),
                new ArchiveStatus(false))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static Schedule getSampleSchedule() {
        Schedule sampleSchedule = new ScheduleManager();
        LocalDate date = LocalDate.now();
        int count = 0;
        for (Person samplePerson : getSamplePersons()) {
            if (count % 3 == 0) {
                date = date.plusDays(1);
            }
            sampleSchedule.addPerson(samplePerson, date);
        }
        return sampleSchedule;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings).map(Tag::new).collect(Collectors.toSet());
    }

}
