package Parte_1.Teste;

import Parte_1.Classe.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {

        List<String> result = null;
        List<Person> personList =  Person.db;
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        result = new ArrayList<>();

        for (Person person: personList) {
            if (person.getAge() > 30){
                result.add(person.getName());
            }
            if (result.size() >= 3){
                break;
            }
        }

        System.out.println("Teste com Java 7");
        System.out.println(result);

        //Usando Stream
        List<String> personList2 =
                personList
                .stream()
                .filter(p-> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .limit(3)
                .map(Person::getName)
                .collect(Collectors.toList())
        ;
        System.out.println("\nTeste com Stream");
        System.out.println(personList2);
    }
}
