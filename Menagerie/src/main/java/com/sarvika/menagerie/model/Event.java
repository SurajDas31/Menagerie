package com.sarvika.menagerie.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Event {
    @EmbeddedId
    private EventId id;

    @Column(nullable = false)
    private Date date;

    @Column(length = 15)
    private String type;

    @Column(length = 255)
    private String remark;

    // Getters and setters


    public EventId getId() {
        return id;
    }

    public void setId(EventId id) {
        this.id = id;
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
    }
}

