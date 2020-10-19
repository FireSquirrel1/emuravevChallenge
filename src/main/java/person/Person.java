package person;

public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int birthdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }


//    public boolean equals(Object obj) {
//        if (!(obj instanceof PersonDataBase))
//            return false;
//
//        PersonDataBase p = (PersonDataBase) obj;
//
//        return name.equals(p.name) && surname.equals(p.surname) && id == p.id && age == p.age &&
//                birthdate == p.birthdate;
//
//    }
}
