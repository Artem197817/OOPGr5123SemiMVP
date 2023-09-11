package Model;

import java.util.List;


import Controller.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassList implements iGetModel {

    private List<Student> students;

    public ModelClassList(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean delete (int id) {
       List <Student> students1 = students.stream()
                .filter(x->x.getId()==id)
                .toList();
       if (students1.isEmpty())
           return false;
        for (Student s:students1) {
            students.remove(s);
        }
        return true;
    }

    @Override
    public Integer key() {
        return 3;
    }
}
