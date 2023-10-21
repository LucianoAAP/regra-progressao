package com.trybe.java.regraprogressao;

public class Activity {
  private String name;
  private int weight;
  private int grade;
  
  public Activity() {
    
  }
  
  public Activity(String name, int weight, int grade) {
    this.name = name;
    this.weight = weight;
    this.grade = grade;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
  public int getGrade() {
    return grade;
  }
  public void setGrade(int grade) {
    this.grade = grade;
  }
}
