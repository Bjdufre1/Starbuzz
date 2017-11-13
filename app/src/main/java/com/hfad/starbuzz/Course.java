package com.hfad.starbuzz;

/**
 * Created by davidg on 30/04/2017.
 */

public class Course {
    private String prefix; private String CourseNumber; private String Description;
    //drinks is an array of Drinks
    public static final Course[] courses = {
            new Course("CS", "116", "Entry class")
    };

    //Each Drink has a name, description, and an image resource
    private Course(String prefix, String CourseNumber, String Description) {
        this.prefix = prefix;
        this.CourseNumber = CourseNumber;
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getCourseNumber(){ return CourseNumber; }

    public String toString() {
        return this.prefix;
    }
}
