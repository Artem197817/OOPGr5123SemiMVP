import java.util.ArrayList;
import java.util.List;

import Controller.ControllerClass;
import Controller.ControllerModel;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClassFile;
import Model.ModelClassHash;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;

public class App {
    public static void main(String[] args) throws Exception {

        List<Student> students = new ArrayList<>();
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        Student s1 = new Student("Сергей", 21);
        Student s2 = new Student("Андрей", 25);
        Student s3 = new Student("Иван", 23);
        Student s4 = new Student("Дарья", 24);
        Student s5 = new Student("Света", 22);
        Student s6 = new Student("Игорь", 21);
        Student s7 = new Student("Мария", 21);
        students.add(s1);
        students.add(s2);
        students1.add(s3);
        students1.add(s4);
        students2.add(s5);
        students2.add(s6);
        students2.add(s7);

        ModelClassFile fModel = new ModelClassFile("StudentDB.csv");
        fModel.saveAllStudentToFile(students);

        ModelClassHash modelClassHash = new ModelClassHash(students1);
        ModelClassList modelClassList = new ModelClassList(students2);
        //ViewClass view = new ViewClass();

        List <iGetModel> modelList = new ArrayList<>();
        modelList.add(fModel);
        modelList.add(modelClassHash);
        modelList.add(modelClassList);
        ControllerModel controllerModel = new ControllerModel(modelList);
        iGetView view = new ViewClass();

       ControllerClass controller = new ControllerClass(controllerModel,view);

       // controller.update();
       controller.run();


    }
}
