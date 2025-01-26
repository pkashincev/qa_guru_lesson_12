package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement calendarMonth = $(".react-datepicker__month-select");
    private final SelenideElement calendarYear = $(".react-datepicker__year-select");
    private final ElementsCollection calendarDays = $$(".react-datepicker__day:not([class$=outside-month])");

    public void setDate(String day, String month, String year) {
        calendarYear.selectOption(year);
        calendarMonth.selectOption(month);
        calendarDays.findBy(text(day)).click();
    }
}