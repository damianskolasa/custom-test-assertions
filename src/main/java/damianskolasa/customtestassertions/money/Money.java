package damianskolasa.customtestassertions.money;

import java.math.BigDecimal;

public class Money {

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value.setScale(2, BigDecimal.ROUND_UP);
    }

    public Money add(Money price) {
        return new Money(value.add(price.value));
    }

    public static Money from(BigDecimal value) {
        return new Money(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        return value != null ? value.equals(money.value) : money.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
