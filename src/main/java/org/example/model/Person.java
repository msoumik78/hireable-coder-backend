package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Person {
  private String name;
  private int age;
  private String country;
  private String profession;
  private String schoolName;
  private String universityName;
}
