package Controller.Interfaces;


import java.util.List;

import Model.Core.Student;

public interface iGetModel {
    List<Student> getStudents();

    boolean delete(int id);

    Integer key();
}
