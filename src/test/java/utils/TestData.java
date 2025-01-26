package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static utils.RandomUtils.*;

public class TestData {

    private final Faker faker = new Faker(new Locale("en-GB"));
    private final Calendar date = DateUtils.toCalendar(faker.date().birthday());

    private final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private final String[] genders = {"Male", "Female", "Other"};
    private final String[] allSubjects = {"Arts", "Biology", "Chemistry", "English", "History", "Maths", "Physics"};
    private final String[] allHobbies = {"Sports", "Reading", "Music"};
    private final String[] allStates = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String incorrectEmail = randomAlphanumeric(10);
    public final String gender = faker.options().option(genders);
    public final String mobileNumber = faker.number().digits(10);
    public final String incorrectMobileNumber = randomAlphanumeric(10);
    public final String dayOfBirth = String.format("%d", date.get(Calendar.DAY_OF_MONTH));
    public final String monthOfBirth = months[date.get(Calendar.MONTH)];
    public final String yearOfBirth = String.format("%d", date.get(Calendar.YEAR));
    public final String[] subjects = getRandomItemsFromArray(allSubjects);
    public final String[] hobbies = getRandomItemsFromArray(allHobbies);
    public final String picture = "picture.jpg";
    public final String address = faker.address().fullAddress();
    public final String state = faker.options().option(allStates);
    public final String city = getCityByState(state);


    private String getCityByState(String state) {
        String city = "";

        switch (state) {

            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;

            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;

            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;

            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }

        return city;
    }
}