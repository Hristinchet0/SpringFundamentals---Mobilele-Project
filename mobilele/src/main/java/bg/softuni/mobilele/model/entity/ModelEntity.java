package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.enums.CategoryEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "modified")
    private LocalDate modified;

    @ManyToOne
    private BrandEntity brand;
}
