package Parte_1.Classe;

import java.util.List;

import static java.util.Arrays.asList;

public class Person {
    private Integer age;
    private String name;
    private Long salary;

    public Person(Integer age, String name, Long salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public static List<Person> db = asList(
            new Person(30,"victor", 1992L),
            new Person(40,"hugo", 2000L),
            new Person(22,"sanches", 2012L),
            new Person(33,"joao", 12110L),
            new Person(12,"carlos", 1992L),
            new Person(30,"jose", 1995L)
    );

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
