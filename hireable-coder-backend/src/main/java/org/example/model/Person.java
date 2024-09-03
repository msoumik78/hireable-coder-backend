package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Person {
  private String name;
  private int age;
  private String country;
}
