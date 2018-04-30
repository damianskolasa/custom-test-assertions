package damianskolasa.customtestassertions.basket;

import damianskolasa.customtestassertions.item.Item;
import damianskolasa.customtestassertions.money.Money;
import damianskolasa.customtestassertions.order.Order;
import damianskolasa.customtestassertions.order.OrderAssert;
import org.junit.Test;

import java.math.BigDecimal;

public class BasketTest {

    @Test
    public void shouldCreateOrderWithAllItemsFromBasket() {
        //given
        Basket basket = new Basket();
        Item item = new Item("Simple test item", Money.from(BigDecimal.ONE));
        basket.getItems().add(item);

        //when
        Order order = basket.orderAllItems();

        //then
        //upsss how to iterate over order ?
    }


    @Test
    public void shouldCreateOrderWithAllItemsFromBasketOrderAssert() {
        //given
        Basket basket = new Basket();
        Item item = new Item("Simple test item", Money.from(BigDecimal.ONE));
        basket.getItems().add(item);

        //when
        Order order = basket.orderAllItems();

        //then
        OrderAssert.of(order).assertContainsItem(item);
    }

}
