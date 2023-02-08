package pav.zar.springmvccrud.dao;

import org.springframework.stereotype.Component;
import pav.zar.springmvccrud.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "John",18,"test1@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",21,"test2@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",32,"test3@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Felix",43,"test4@email.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny()
                .orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }

}
