package damianskolasa.customtestassertions.order;

import damianskolasa.customtestassertions.item.Item;
import damianskolasa.customtestassertions.money.Money;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    public void shouldAccumulatePriceOfAddedItem() {
        //given
        Order order = new Order();
        Item item = new Item("Simple test item", Money.from(BigDecimal.TEN));

        //when
        order.addItem(item);

        //then
        Assertions.assertThat(order.getItems()).hasSize(1);
        Assertions.assertThat(order.getItems()).contains(item);
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(item.getPrice());
    }

    @Test
    public void shouldAccumulatePriceOfAddedItemCustomAssertionMethod() {
        //given
        Order order = new Order();
        Item item = new Item("Simple test item", Money.from(BigDecimal.TEN));

        //when
        order.addItem(item);

        //then
        assertThatOrderContainsAddedItem(order, item);
    }

    private void assertThatOrderContainsAddedItem(Order order, Item item) {
        Assertions.assertThat(order.getItems()).hasSize(1);
        Assertions.assertThat(order.getItems()).contains(item);
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(item.getPrice());
    }

    @Test
    public void shouldAccumulatePriceOfAddedItemCustomAssertionObject() {
        //given
        Order order = new Order();
        Item item = new Item("Simple test item", Money.from(BigDecimal.TEN));

        //when
        order.addItem(item);

        //then
        OrderAssert.of(order).assertContainsItem(item);
    }

}
