package View;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

import java.util.List;
import java.util.Scanner;

public class ViewClassEng implements iGetView {
    @Override
    public void printAllStudent(List<Student> students) {
        System.out.println("----------- List Students -----------");
        for(Student s : students)
        {
            System.out.println(s);
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    @Override
    public void sendMessage(String message) {

    }
}
