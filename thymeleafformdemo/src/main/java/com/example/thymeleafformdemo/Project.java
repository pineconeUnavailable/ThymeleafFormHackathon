package com.example.thymeleafformdemo;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Project implements Serializable, Comparable<Project>{
    private static final Long ID_OFFSET = 34500000L;
    private static Long idCounter = 0L;

    private Long id;
    private String title;
    private String type;
    private String color;
    private String description;
    private Integer days;
    private Double price;
    private Boolean featured;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime launchDate;

    public Project() {
        this.id = idCounter++;
        this.launchDate = LocalDateTime.now();
    }

    public Project(Long id, String title, String type, String color, String description, Integer days, Double price, Boolean featured, LocalDateTime launchDate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.color = color;
        this.description = description;
        this.days = days;
        this.price = price;
        this.featured = featured;
        this.launchDate = launchDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public int compareTo(Project o) {
        if (this.featured != o.featured) {
            return o.featured ? 1 : -1;
        }

        return this.launchDate.equals(o.launchDate) ? 0 : this.launchDate.isBefore(o.launchDate) ? -1 : 1;
    }
/*
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", days=" + days +
                ", price=" + price +
                ", featured=" + featured +
                ", launchDate=" + launchDate +
                '}';
    }
    */

    public void setNullsAsDefault() {
        id = id == null ? ID_OFFSET + idCounter++ : id;
        price = price == null ? 0.0 : price;
        days = days == null ? 0 : days;
        launchDate = launchDate == null ? LocalDateTime.now() : launchDate;
    }
}