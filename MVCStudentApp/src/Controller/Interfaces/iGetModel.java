package Controller.Interfaces;

import java.util.HashMap;
import java.util.List;

import Model.Core.Student;

public interface iGetModel {
    public List<Student> getStudents();
    public boolean delete(int id);
    public Integer key();
}
