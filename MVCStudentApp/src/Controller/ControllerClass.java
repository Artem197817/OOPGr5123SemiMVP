package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ControllerClass {

    private ControllerModel controllerModel;
    private iGetModel model;
    private iGetView view;
    private List<Student> students = new ArrayList<Student>();

    public ControllerClass(ControllerModel controllerModel, iGetView view) {
        this.controllerModel = controllerModel;
        this.view = view;
    }

    public void setModel(iGetModel model) {
        this.model = model;
    }

    private boolean testData(List<Student> studs) {
        if (studs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {

        //MVP
        students = model.getStudents();

        if (testData(students)) {
            view.printAllStudent(students);
        } else {
            System.out.println("Список студентов пуст!");
        }


        // MVC
        //view.printAllStudent(model.getStudents());
    }


    public void run() {
        Command com = Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.prompt("Введите команду:");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    for (int i = 1; i <= 3; i++) {
                        setModel(controllerModel.numberModel.get(i));
                        view.printAllStudent(model.getStudents());
                    }
                    break;
                case DELETE:
                    String idString = view.prompt("Для удаления студента введите id: ");
                    if (!idString.matches("\\d*"))
                        break;
                    int id = Integer.parseInt(idString);
                    boolean isDelete = false;
                    for (int i = 1; i <= 3; i++) {
                        setModel(controllerModel.numberModel.get(i));
                        isDelete = model.delete(id);
                        if (isDelete) {
                            view.sendMessage("Студент удален");
                            break;
                        }
                    }
                    if (!isDelete)
                        view.sendMessage("Студент не найден");
                    break;
            }

        }
    }
}




