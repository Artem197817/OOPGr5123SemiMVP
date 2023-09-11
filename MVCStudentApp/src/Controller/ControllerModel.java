package Controller;

import Controller.Interfaces.iGetModel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ControllerModel {

    Map<Integer, iGetModel> numberModel;

    public ControllerModel(List<iGetModel> iGetModel){
      numberModel =  iGetModel.stream()
                .collect(Collectors.toMap(Controller.Interfaces.iGetModel::key, Function.identity()));

    }

}
