package Controller.Interfaces;

import java.util.List;

import Model.Core.Student;

public interface iGetView {
    void printAllStudent(List<Student> students);

    String prompt(String msg);

    void sendMessage(String message);
}
