package org.training.performance.test1;

public class Employee {
    private String name;
    private String surname;
    private Integer age;
    private int height;

    public String getName() {
        return name;
    }

    public void setName(final String nameParam) {
        name = nameParam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surnameParam) {
        surname = surnameParam;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer ageParam) {
        age = ageParam;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int heightParam) {
        height = heightParam;
    }
}
