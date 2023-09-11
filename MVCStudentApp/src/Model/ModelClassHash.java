package Model;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ModelClassHash implements iGetModel {


    private HashMap<Long, Student> studentHashMap = new HashMap<>();

    public ModelClassHash(List<Student> students) {
       for (Student s:students){
           studentHashMap.put((long)s.getId(),s);
       }
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(studentHashMap.values());
    }
    public void add (Student student){
        Long l = (long) student.getId();
        studentHashMap.put(l,student);
    }

    @Override
    public boolean delete(int id) {
        Long l = (long) id;
        if (studentHashMap.containsKey(l)) {
            studentHashMap.remove(l);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer key() {
        return 2;
    }
}
