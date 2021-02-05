package com.reit.reit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "building")
public class Building implements Serializable {

    @Serial
    private static final long serialVersionUID = 4048798961366546485L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "active")
    private boolean active;

    @OneToOne
    @JoinColumn(name = "status_id",  nullable = false)
    private Status status;

    @JsonIgnore
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 19)
    private Date createdAt;

    @JsonIgnore
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, length = 19)
    private Date updatedAt;

    @Override
    public String toString() {
        return "Datatype [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Building other = (Building) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
