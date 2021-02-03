package com.reit.reit.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "activities")
@Data
public class Activity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4048798961366546115L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Activity Name is mandatory")
    private String activityName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assigned_to")
    private User assigned_to;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    private Integer status;

    @Column(name = "active")
    private boolean active;

    @CreatedDate
    @Column(name = "created_at", nullable = false, length = 19)
    private Timestamp createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, length = 19)
    private Timestamp updatedAt;


    @Override
    public String toString() {
        return "Datatype [id=" + id + ", name=" + activityName + "]";
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
        Activity other = (Activity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
