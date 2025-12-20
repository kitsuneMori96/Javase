package Abstractclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class People {
    private String id;
    private String name;
    private double salary;

    public abstract void work();

    public abstract void eat();
}
