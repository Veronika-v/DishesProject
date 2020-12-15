package by.rogalevich.dishesproject.model;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "user_id cannot be empty")
    private Integer user_id;///////////////////////////////

    @NotBlank(message = "order_state cannot be empty")
    @ElementCollection(targetClass = OrderState.class, fetch= FetchType.EAGER)
    @CollectionTable(name="order_state", joinColumns = @JoinColumn(name="order_id"))
    @Enumerated(EnumType.STRING)
    private Set<OrderState> orderStates;

    @NotBlank(message = "dish_id cannot be empty")
    private Integer dish_id;///////////////////////////////

    @NotBlank(message = "count_of_dishes cannot be empty")
    private Integer count_of_dishes;
}
