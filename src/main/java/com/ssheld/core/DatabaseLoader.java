package com.ssheld.core;

import com.ssheld.course.Course;
import com.ssheld.course.CourseRepository;
import com.ssheld.review.Review;
import com.ssheld.user.User;
import com.ssheld.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
  private final CourseRepository courses;
  private final UserRepository users;

  @Autowired
  public DatabaseLoader(CourseRepository courses, UserRepository users) {
    this.courses = courses;
    this.users = users;
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

    List<User> students = Arrays.asList(
        new User("jacobproffer", "Jacob",  "Proffer", "password", new String[] {"ROLE_USER"}),
        new User("mlnorman", "Mike",  "Norman", "password", new String[] {"ROLE_USER"}),
        new User("k_freemansmith", "Karen",  "Freeman-Smith", "password", new String[] {"ROLE_USER"}),
        new User("seth_lk", "Seth",  "Kroger", "password", new String[] {"ROLE_USER"}),
        new User("mrstreetgrid", "Java",  "Vince", "password", new String[] {"ROLE_USER"}),
        new User("anthonymikhail", "Tony",  "Mikhail", "password", new String[] {"ROLE_USER"}),
        new User("boog690", "AJ",  "Teacher", "password", new String[] {"ROLE_USER"}),
        new User("faelor", "Erik",  "Faelor Shafer", "password", new String[] {"ROLE_USER"}),
        new User("christophernowack", "Christopher",  "Nowack", "password", new String[] {"ROLE_USER"}),
        new User("calebkleveter", "Caleb",  "Kleveter", "password", new String[] {"ROLE_USER"}),
        new User("richdonellan", "Rich",  "Donnellan", "password", new String[] {"ROLE_USER"}),
        new User("albertqerimi", "Albert",  "Qerimi", "password", new String[] {"ROLE_USER"})
    );
    users.saveAll(students);
    users.save(new User("Stephen", "Sheldon", "Stephen Sheldon", "12345", new String[] {"ROLE_USER", "ROLE_ADMIN"}));

    List<Course> exampleCourses = new ArrayList<>();
    IntStream.range(0,100)
        .forEach(i -> {
            String template = templates[i % templates.length];
            String buzzword = buzzwords[i % buzzwords.length];
            String title = String.format(template, buzzword);
            Course c = new Course(title, "http://www.example.com");
          Review review = new Review((i % 5)+1, String.format("Moar %s please!!!", buzzword));
          review.setReviewer(students.get(i % students.size()));
          c.addReview(review);
            exampleCourses.add(c);
        });
    courses.saveAll(exampleCourses);

  }
}
