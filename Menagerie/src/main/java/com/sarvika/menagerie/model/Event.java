package com.sarvika.menagerie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Event {
    @EmbeddedId
    private EventId petId;

    @NotNull(message = "Date cannot be null")
    @Column(nullable = false)
    private Date date;

    @Size(max = 15, message = "Type cannot exceed 15 characters")
    private String type;

    @Size(max = 255, message = "Remarks cannot exceed 20 characters")
    private String remark;


    public EventId getPetId() {
        return petId;
    }

    public void setPetId(EventId petId) {
        this.petId = petId;
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

    @Embeddable
    public static class EventId implements Serializable {
        private Integer petId;

        public EventId() {}

        public EventId(Integer petId) {
            this.petId = petId;
        }

        // Getters and setters

        public Integer getPetId() {
            return petId;
        }

        public void setPetId(Integer petId) {
            this.petId = petId;
        }

        @Override
        public String toString() {
            return "EventId{" +
                    "petId=" + petId +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "petId=" + petId +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

