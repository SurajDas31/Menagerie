package com.sarvika.menagerie.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @NotNull(message = "Date cannot be null")
    @Column(nullable = false)
    private Date date;

    @Size(max = 15, message = "Type cannot exceed 15 characters")
    private String type;

    @Size(max = 255, message = "Remarks cannot exceed 20 characters")
    private String remark;


   /* public int getId() {
        return id;
    }*/

    public void setId(int id) {
        this.id = id;
    }

   /* public Pet getPet() {
        return pet;
    }*/

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", pet=" + pet +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

