package com.kamiloses.productservice.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    //todo usuń zbędne kolejki
    public static final String QUEUE_ORDER_TO_USER = "order.user.request";
    public static final String QUEUE_USER_TO_ORDER = "user.order.response";


    public static final String QUEUE_ORDER_TO_PRODUCT = "order.product.request";
    public static final String QUEUE_PRODUCT_TO_ORDER = "product.order.response";

    public static final String QUEUE_PRODUCT_TO_INVENTORY = "product.order.response";
    public static final String QUEUE_INVENTORY_TO_ORDER = "product.order.response";

    public static final String EXCHANGE_MAKING_ORDER = "order.created.exchange";


    public static final String ROUTING_KEY_ORDER_TO_USER = "order.to.user";
    public static final String ROUTING_KEY_USER_TO_ORDER = "user.to.order";

    public static final String ROUTING_KEY_ORDER_TO_PRODUCT = "order.to.product";
    public static final String ROUTING_KEY_PRODUCT_TO_ORDER = "product.to.order";

    public static final String ROUTING_KEY_PRODUCT_TO_INVENTORY = "product.to.inventory";
    public static final String ROUTING_KEY_INVENTORY_TO_ORDER = "inventory.to.order";



    @Bean
    public Queue queueOrderToUser() {
        return new Queue(QUEUE_ORDER_TO_USER, true);
    }

    @Bean
    public Queue queueUserToOrder() {
        return new Queue(QUEUE_USER_TO_ORDER, true);
    }






    @Bean
    public Queue queueOrderToProduct() {
        return new Queue(QUEUE_ORDER_TO_PRODUCT, true);
    }

    @Bean
    public Queue queueProductToOrder() {
        return new Queue(QUEUE_PRODUCT_TO_ORDER, true);
    }
    @Bean
    public Queue queueProductToInventory() {
        return new Queue(QUEUE_PRODUCT_TO_INVENTORY, true);
    }

    @Bean
    public Queue queueInventoryToOrder() {
        return new Queue(QUEUE_INVENTORY_TO_ORDER, true);
    }






    @Bean
    public DirectExchange exchangeMakingOrder() {
        return new DirectExchange(EXCHANGE_MAKING_ORDER);
    }



    @Bean
    public Binding bindingOrderToUser() {
        return BindingBuilder.bind(queueOrderToUser()).to(exchangeMakingOrder()).with(ROUTING_KEY_ORDER_TO_USER);
    }
    @Bean
    public Binding bindingUserToOrder() {
        return BindingBuilder.bind(queueUserToOrder()).to(exchangeMakingOrder()).with(ROUTING_KEY_USER_TO_ORDER);
    }




    @Bean
    public Binding bindingOrderToProduct() {
        return BindingBuilder.bind(queueOrderToProduct()).to(exchangeMakingOrder()).with(ROUTING_KEY_ORDER_TO_PRODUCT);
    }
    @Bean
    public Binding bindingProductToOrder() {
        return BindingBuilder.bind(queueProductToOrder()).to(exchangeMakingOrder()).with(ROUTING_KEY_PRODUCT_TO_ORDER);
    }



    @Bean
    public Binding bindingProductToInventory() {
        return BindingBuilder.bind(queueProductToInventory()).to(exchangeMakingOrder()).with(ROUTING_KEY_PRODUCT_TO_INVENTORY);
    }

    @Bean
    public Binding bindingInventoryToOrder() {
        return BindingBuilder.bind(queueInventoryToOrder()).to(exchangeMakingOrder()).with(ROUTING_KEY_INVENTORY_TO_ORDER);
    }

}