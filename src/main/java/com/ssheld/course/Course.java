package com.ssheld.course;

import com.ssheld.core.BaseEntity;
import com.ssheld.review.Review;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@Entity
public class Course extends BaseEntity {
  // Validation constraint - entity is not valid if it's null
  @NotNull
  @Size(min = 2, max = 140)
  private String title;
  private String url;
  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<Review> reviews;

  // JPA requires a constructor that takes no parameters
  protected Course() {
    super();
    reviews = new ArrayList<>();
  }

  public Course(String title, String url) {
    this();
    this.title = title;
    this.url = url;
  }

  public void addReview(Review review) {
    review.setCourse(this);
    reviews.add(review);
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
