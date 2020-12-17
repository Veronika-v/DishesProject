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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Userr userr;


    @NotBlank(message = "order_state cannot be empty")
    @ElementCollection(targetClass = OrderState.class, fetch= FetchType.EAGER)
    @CollectionTable(name="order_state", joinColumns = @JoinColumn(name="order_id"))
    @Enumerated(EnumType.STRING)
    private Set<OrderState> orderStates;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id")
    private Dishes dish;


    @NotBlank(message = "count_of_dishes cannot be empty")
    private Integer count_of_dishes;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Userr getUserr() {
        return userr;
    }

    public void setUserr(Userr userr) {
        this.userr = userr;
    }

    public Set<OrderState> getOrderStates() {
        return orderStates;
    }

    public void setOrderStates(Set<OrderState> orderStates) {
        this.orderStates = orderStates;
    }

    public Dishes getDish() {
        return dish;
    }

    public void setDish(Dishes dish) {
        this.dish = dish;
    }

    public Integer getCount_of_dishes() {
        return count_of_dishes;
    }

    public void setCount_of_dishes(Integer count_of_dishes) {
        this.count_of_dishes = count_of_dishes;
    }
}
