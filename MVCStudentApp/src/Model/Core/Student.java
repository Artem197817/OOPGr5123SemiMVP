package Model.Core;

public class Student extends Person  {
    private final int id;
    private static int generalId;

    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }
    public Student(String name, int age, int id){
        super(name,age);
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Students [age=" + super.getAge() + ", name=" + super.getName() + ", id=" + id + "]";
    }
}
