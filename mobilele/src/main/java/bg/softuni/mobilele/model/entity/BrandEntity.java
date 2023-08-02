package bg.softuni.mobilele.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created")
    private LocalDate created;

    @Column(name = "modified")
    private LocalDate modified;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ModelEntity> models;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", models=" + models +
                '}';
    }
}
