package module_16_working_with_mysql._16_11_lecture_hibernate_HQL.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PurchaseList")
@Getter
@Setter
public class PurchaseList {

    // по факту этого поля у нас нет!!!
    @EmbeddedId
    private PurchaseListKey id;

    private int price;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;
}
