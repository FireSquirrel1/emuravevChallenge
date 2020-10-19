package db;

import person.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static db.DataBaseConnect.connectionDataBase;

public class GetPersonFromDataBase {
    ResultSet data;
    Statement statement = null;
    public GetPersonFromDataBase(String select) {
        try {
            statement = connectionDataBase().createStatement();
            data = statement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person getPersonData() {
        Person person = new Person();
        try {
            data.next();
            person.setId(data.getInt("id"));
            person.setName(data.getString("name"));
            person.setSurname(data.getString("surname"));
            person.setAge(data.getInt("age"));
            person.setBirthdate(data.getInt("birthdate"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }
}
