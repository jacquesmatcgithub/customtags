package com.jfourie.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HelloWorldTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();

        String salutation = "Good ";
        int hourNow = LocalDateTime.now().getHour();

        if (hourNow >= 1 && hourNow < 12) {
            salutation = salutation + "morning ";
        } else if (hourNow >= 12 && hourNow < 17) {
            salutation = salutation + "afternoon ";
        } else {
            salutation = salutation + "evening ";
        }

        salutation = salutation + "enterprise java class.";

        out.println(salutation + "<br/>");


        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        salutation = "Today is " + dayOfWeek + ".";
        out.println(salutation + "<br/>");

        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        if (month == 12 && day == 24) {
            salutation = "Tomorrow is Christmas Day.";
        } else if (month == 12 && day == 30) {
            salutation = "Tomorrow is new years eve.";
        } else if (month == 12 && day == 31) {
            salutation = "Tomorrow is new years day.";
        } else if (month == 2 && day == 13) {
            salutation = "Tomorrow is Valentines Day.";
        } else {
            salutation = "Tomorrow is just another day.";
        }

        out.println(salutation + "<br/>");

    }
}
