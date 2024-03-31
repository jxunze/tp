package seedu.address.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.ScheduleDate;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;


/*
 * Adapted from Da9el00's Calendar.fxml
 * https://gist.github.com/Da9el00/f4340927b8ba6941eb7562a3306e93b6
 */
public class Calendar extends UiPart<Region> {
    private static final String FXML = "Calendar.fxml";

    // Number of weeks to display in the calendar
    public static int NUMBER_OF_WEEKS = 4;

    LocalDate dateFocus;
    LocalDate today;
    Set<ScheduleDate> scheduleDates;

    @FXML
    private FlowPane calendar;

    public Calendar(Set<ScheduleDate> scheduleDates) {
        super(FXML);
        dateFocus = LocalDate.now();
        today = LocalDate.now();
        this.scheduleDates = scheduleDates;
        drawCalendar();
    }

    private void drawCalendar() {
        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        // List of activities for a given month
        Map<LocalDate, ScheduleDate> scheduleDateMap = createCalendarMap();

        Month month = dateFocus.getMonth();
        int day = dateFocus.getDayOfMonth() - dateFocus.getDayOfWeek().getValue();
        int currentMonthMaxDay = dateFocus.lengthOfMonth();

        for (int i = 0; i < NUMBER_OF_WEEKS; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();
                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth = (calendarWidth / 7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight / NUMBER_OF_WEEKS) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);
                System.out.println("Day: " + day);
                String dayMonth = day + " " + month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                ScheduleDate scheduleDate = scheduleDateMap.get(LocalDate.of(dateFocus.getYear(), month, day));
                day++;
                if (day > currentMonthMaxDay) {
                    day = 1;
                    month = month.plus(1);
                }
                Text date = new Text(dayMonth);
                double textTranslationY = - (rectangleHeight / 2) * 0.75;
                date.setTranslateY(textTranslationY);
                stackPane.getChildren().add(date);
                if(scheduleDate != null){
                    createCalendarActivity(scheduleDate, rectangleHeight, rectangleWidth, stackPane);
                }
                if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth()
                        && today.getDayOfMonth() == day) {
                    rectangle.setStroke(Color.BLUE);
                }
                calendar.getChildren().add(stackPane);
            }
        }
    }

    private void createCalendarActivity(ScheduleDate scheduleDate, double rectangleHeight, double rectangleWidth,
                                        StackPane stackPane) {
        VBox calendarActivityBox = new VBox();
        List<Person> persons = scheduleDate.getPersons();
        List<String> personNames = persons.stream()
                .map(Person::getName)
                .map(x -> x.value)
                .collect(Collectors.toList());
        for (int k = 0; k < persons.size(); k++) {
            Text text = new Text(personNames.get(k));
            calendarActivityBox.getChildren().add(text);
        }
        calendarActivityBox.setTranslateY((rectangleHeight / 2) * 0.20);
        calendarActivityBox.setMaxWidth(rectangleWidth * 0.8);
        calendarActivityBox.setMaxHeight(rectangleHeight * 0.65);
        stackPane.getChildren().add(calendarActivityBox);
    }

    private Map<LocalDate, ScheduleDate> createCalendarMap() {
        return scheduleDates.stream().collect(
                Collectors.toMap(ScheduleDate::getDate, x -> x));
    }
}