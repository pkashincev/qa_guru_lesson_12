package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.DemoqaPracticeFormPage;
import utils.TestData;

import static utils.ConvertUtils.*;

public class DemoqaPracticeFormWithRandomDataTests extends BaseTest {

    private final DemoqaPracticeFormPage page = new DemoqaPracticeFormPage();
    private final TestData data = new TestData();

    @Tags({
            @Tag("WEB"),
            @Tag("POSITIVE")})
    @DisplayName("Полное заполнение регистрационной формы корректными данными")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Заполнение регистрационной формы")
    @Story("Ввод корректных данных")
    @Test
    void fullCompletionFormTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadFileFromClasspath(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        page.checkSuccessfulSubmit()
                .checkHeaderOfResultsWindow("Thanks for submitting the form")
                .checkHeaderOfResultsTable("Label", "Values")
                .checkContentOfResultsTable("Student Name", String.format("%s %s", data.firstName, data.lastName))
                .checkContentOfResultsTable("Student Email", data.email)
                .checkContentOfResultsTable("Gender", data.gender)
                .checkContentOfResultsTable("Mobile", data.mobileNumber)
                .checkContentOfResultsTable("Date of Birth",
                        String.format("%s %s,%s", data.dayOfBirth, data.monthOfBirth, data.yearOfBirth))
                .checkContentOfResultsTable("Subjects", arrayToStringWithCommaSeparators(data.subjects))
                .checkContentOfResultsTable("Hobbies", arrayToStringWithCommaSeparators(data.hobbies))
                .checkContentOfResultsTable("Picture", data.picture)
                .checkContentOfResultsTable("Address", data.address)
                .checkContentOfResultsTable("State and City", String.format("%s %s", data.state, data.city));
    }

    @Tags({
            @Tag("WEB"),
            @Tag("POSITIVE")})
    @DisplayName("Минимальное заполнение регистрационной формы корректными данными")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Заполнение регистрационной формы")
    @Story("Ввод корректных данных")
    @Test
    void minimumCompletionFormTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .submitForm();

        page.checkSuccessfulSubmit()
                .checkHeaderOfResultsWindow("Thanks for submitting the form")
                .checkHeaderOfResultsTable("Label", "Values")
                .checkContentOfResultsTable("Student Name", String.format("%s %s", data.firstName, data.lastName))
                .checkContentOfResultsTable("Gender", data.gender)
                .checkContentOfResultsTable("Mobile", data.mobileNumber);
    }

    @Tags({
            @Tag("WEB"),
            @Tag("NEGATIVE")})
    @DisplayName("Указан некорректный Email")
    @Severity(SeverityLevel.MINOR)
    @Feature("Заполнение регистрационной формы")
    @Story("Ввод некорректных данных")
    @Test
    void invalidEmailTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.incorrectEmail)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadFileFromClasspath(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        page.checkUnsuccessfulSubmit();
    }

    @Tags({
            @Tag("WEB"),
            @Tag("NEGATIVE")})
    @DisplayName("Указан некорректный мобильный номер")
    @Severity(SeverityLevel.MINOR)
    @Feature("Заполнение регистрационной формы")
    @Story("Ввод некорректных данных")
    @Test
    void invalidMobileNumberTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobileNumber(data.incorrectMobileNumber)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadFileFromClasspath(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        page.checkUnsuccessfulSubmit();
    }
}