package com.practice.demo.dto;

/**
 * record keyword is new keyword introduced in Java 14 which is analog of data keyword in Kotlin
 * Generates as an immutable object methods: getters, toString, hashcode and equals
 *
 * @param id
 * @param name
 * @param age
 */
public record UserDTO(String id, String name, int age) {

}
