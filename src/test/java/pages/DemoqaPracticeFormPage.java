package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultsWindowComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPracticeFormPage {

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement gender = $("#genterWrapper");
    private final SelenideElement mobileNumber = $("#userNumber");
    private final SelenideElement dateOfBirthCalendar = $("#dateOfBirthInput");
    private final SelenideElement subjects = $("#subjectsInput");
    private final SelenideElement hobbies = $("#hobbiesWrapper");
    private final SelenideElement picture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement submitButton = $("#submit");

    private final CalendarComponent calendar = new CalendarComponent();
    private final ResultsWindowComponent resultsWindow = new ResultsWindowComponent();

    @Step("Открыть главную страницу")
    public DemoqaPracticeFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public DemoqaPracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Ввести First Name: {value}")
    public DemoqaPracticeFormPage setFirstName(String value) {
        firstName.scrollTo().setValue(value);

        return this;
    }

    @Step("Ввести Last Name: {value}")
    public DemoqaPracticeFormPage setLastName(String value) {
        lastName.scrollTo().setValue(value);

        return this;
    }

    @Step("Ввести Email: {value}")
    public DemoqaPracticeFormPage setEmail(String value) {
        email.scrollTo().setValue(value);

        return this;
    }

    @Step("Выбрать пол: {value}")
    public DemoqaPracticeFormPage setGender(String value) {
        gender.scrollTo().$(byText(value)).click();

        return this;
    }

    @Step("Ввести мобильный номер: {value}")
    public DemoqaPracticeFormPage setMobileNumber(String value) {
        mobileNumber.scrollTo().setValue(value);

        return this;
    }

    @Step("Указать дату рождения: {day} {month} {year}")
    public DemoqaPracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthCalendar.scrollTo().click();
        calendar.setDate(day, month, year);

        return this;
    }

    @Step("Указать список дисциплин: {values}")
    public DemoqaPracticeFormPage setSubjects(String... values) {
        subjects.scrollTo();
        for (String s : values) {
            subjects.setValue(s).pressEnter();
        }

        return this;
    }

    @Step("Выбрать хобби: {values}")
    public DemoqaPracticeFormPage setHobbies(String... values) {
        hobbies.scrollTo();
        for (String s : values) {
            hobbies.$(byText(s)).click();
        }

        return this;
    }

    @Step("Прикрепить файл: {fileName}")
    public DemoqaPracticeFormPage uploadFileFromClasspath(String fileName) {
        picture.scrollTo().uploadFromClasspath(fileName);

        return this;
    }

    @Step("Ввести адрес: {value}")
    public DemoqaPracticeFormPage setCurrentAddress(String value) {
        currentAddress.scrollTo().setValue(value);

        return this;
    }

    @Step("Выбрать штат: {value}")
    public DemoqaPracticeFormPage setState(String value) {
        state.scrollTo().click();
        state.$(byText(value)).click();

        return this;
    }

    @Step("Выбрать город: {value}")
    public DemoqaPracticeFormPage setCity(String value) {
        city.scrollTo().click();
        city.$(byText(value)).click();

        return this;
    }

    @Step("Передать введенные данные")
    public DemoqaPracticeFormPage submitForm() {
        submitButton.scrollTo().click();

        return this;
    }

    @Step("Проверить наличие окна с результатами")
    public DemoqaPracticeFormPage checkSuccessfulSubmit() {
        resultsWindow.isVisible();

        return this;
    }

    @Step("Проверить отсутствие окна с результатами")
    public DemoqaPracticeFormPage checkUnsuccessfulSubmit() {
        resultsWindow.isHidden();

        return this;
    }

    @Step("Проверить, что окно с результатами имеет заголовок {header}")
    public DemoqaPracticeFormPage checkHeaderOfResultsWindow(String header) {
        resultsWindow.checkWindowHeader(header);

        return this;
    }

    @Step("Проверить, что заголовок таблицы имеет значения {key} и {value}")
    public DemoqaPracticeFormPage checkHeaderOfResultsTable(String key, String value) {
        resultsWindow.checkTableHeader(key, value);

        return this;
    }

    @Step("Проверить наличие в таблице строки со значениями \"{key}\" и \"{value}\"")
    public DemoqaPracticeFormPage checkContentOfResultsTable(String key, String value) {
        resultsWindow.checkTableContent(key, value);

        return this;
    }
}