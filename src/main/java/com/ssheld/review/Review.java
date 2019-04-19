package com.ssheld.review;

import com.ssheld.core.BaseEntity;
import com.ssheld.course.Course;
import com.ssheld.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@Entity
public class Review extends BaseEntity {
  private int rating;
  private String description;
  @ManyToOne
  private Course course;
  // Many to one - One user can have many reviews
  @ManyToOne
  private User reviewer;

  protected Review() {
    super();
  }

  public Review(int rating, String description) {
    this();
    this.rating = rating;
    this.description = description;
  }

  public User getReviewer() {
    return reviewer;
  }

  public void setReviewer(User reviewer) {
    this.reviewer = reviewer;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
