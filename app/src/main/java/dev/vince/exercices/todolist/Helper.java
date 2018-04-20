package dev.vince.exercices.todolist;

import java.util.HashMap;

public class Helper {



    private static Helper instance;
    public static Helper getInstance(){
        if(instance == null){
            instance = new Helper();
        }
        return instance;
    }

    HashMap<PriorityEnum, Integer> dico;

    private Helper(){
        dico = new HashMap<>();
        dico.put(PriorityEnum.Low, R.color.priorityLow);
        dico.put(PriorityEnum.Normal, R.color.priorityNormal);
        dico.put(PriorityEnum.High, R.color.priorityHigh);
    }


    public int getPriorityColorResource(PriorityEnum priorityEnum){
        return dico.get(priorityEnum);
    }

}
