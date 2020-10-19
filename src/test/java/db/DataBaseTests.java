package db;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import person.Person;
import person.PersonJson;

import static org.junit.gen5.api.Assertions.assertFalse;

public class DataBaseTests {
    @BeforeAll
    static void connectAndCreateTable() {
        // DataBaseData.createTableUserDataBase("CREATE TABLE `challange`.`emuravev`(id int, name text, surname text, age int, birthdate int,  PRIMARY KEY (id));");
//        DataBaseData.updateTableUserDataBase( "INSERT INTO emuravev VALUES ('1','Борис', 'Борисыч','52','1900');");
//        DataBaseData.updateTableUserDataBase( "INSERT INTO emuravev VALUES ('2','Генадий', 'Генадич','53','1901');");
    }

    @Test
    public void testGetDataFromDataBase() {
        Person person1 = new GetPersonFromDataBase("SELECT * FROM challange.emuravev WHERE id = 1;").getPersonData();
        Person person2 = new GetPersonFromDataBase("SELECT * FROM challange.emuravev WHERE id = 2;").getPersonData();

        assertFalse(person1.getId() == person2.getId(), "Ой id равны");
        assertFalse(person1.getName().equals(person2.getName()), "Name равны");
        assertFalse(person1.getAge() == person2.getAge(), "аge равны");
        assertFalse(person1.getSurname().equals(person2.getSurname()), "surname равны");
        assertFalse(person1.getBirthdate() == person2.getBirthdate(), "birthday равны");

        PersonJson.ConvertPersonToJson();
    }
}
