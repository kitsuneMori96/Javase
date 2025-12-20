package AbstractclassMethodoverriding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Card {
    private String cardId;
    private double balance;
    abstract void pay(double amount);
}
