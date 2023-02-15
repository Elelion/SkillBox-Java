package module_16_working_with_mysql._16_4_lecture_hibernate;

import javax.persistence.*;

/**
 * Пишем аннотации, что бы Hibernate смог определить где какие поля
 * и с чем работать
 *
 * это обязательно:
 * @Entity
 * @Table(name = "good")
 *
 * это обязательно для id с автоинкрементом
 * @Id
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 *
 * тк в Java не принято именовать переменные с нижним подчеркиванием
 * мы пишем их camelCase, а перед добавляем аннотацию соответствующую
 * имени в таблице с нижним подчеркиваением
 */
@Entity
@Table(name = "good")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_id")
    private int categoryId;
    private String name;
    private int count;
    private int price;

    /**/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
