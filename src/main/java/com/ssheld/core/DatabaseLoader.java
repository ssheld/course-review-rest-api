package com.ssheld.core;

import com.ssheld.course.Course;
import com.ssheld.course.CourseRepository;
import com.ssheld.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
  private final CourseRepository courses;

  @Autowired
  public DatabaseLoader(CourseRepository courses) {
    this.courses = courses;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Course course = new Course("Java Basics", "https://teamtreehouse.com/java");
    course.addReview(new Review(9,"This course rocks my socks!"));
    courses.save(course);
    String[] templates = {
        "up and Running with %s",
        "%s Basics",
        "%s for Beginners",
        "%s for neckbeards",
        "Under the hood: %s"
    };

    String[] buzzwords = {
        "Spring REST Data",
        "Java 9",
        "Scala",
        "Groovy",
        "Hibernate",
        "Spring HATEOAS"
    };
    List<Course> exampleCourses = new ArrayList<>();
    IntStream.range(0,100)
        .forEach(i -> {
            String template = templates[i % templates.length];
            String buzzword = buzzwords[i % buzzwords.length];
            String title = String.format(template, buzzword);
            Course c = new Course(title, "http://www.example.com");
            c.addReview(new Review(i % 5, String.format("Moar %s please!!!", buzzword)));
            exampleCourses.add(c);
        });
    courses.saveAll(exampleCourses);

  }
}
