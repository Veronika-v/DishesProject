package by.rogalevich.dishesproject.model;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="dishes")
public class Dishes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "dishname cannot be empty")
    private String dishname;

    @NotBlank(message = "description cannot be empty")
    private String dish_description;

    @NotBlank(message = "price cannot be empty")
    @DecimalMin("1.00")
    private BigDecimal price;

    @NotBlank(message = "category cannot be empty")
    @ElementCollection(targetClass = Category.class, fetch= FetchType.EAGER)
    @CollectionTable(name="dish_category", joinColumns = @JoinColumn(name="dish_id"))
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDish_description() {
        return dish_description;
    }

    public void setDish_description(String dish_description) {
        this.dish_description = dish_description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
