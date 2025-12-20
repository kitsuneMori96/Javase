package com.itheima.interface7;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class OperatorFurniture {
    private HomeSystem[] furniture;

    public OperatorFurniture(HomeSystem[] furniture){
        this.furniture = furniture;
    }

    public void PrintAllFurniture(){
        for(HomeSystem f : furniture){
            System.out.println(f.getName() + " " + f.getStatus());
        }
    }

}
