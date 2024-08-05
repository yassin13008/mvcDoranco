package com.doranco.mvcdoranco.model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String messageText;
    private LocalDateTime timeStamp;

    public Message(String author, String messageText){
        this.author = author;
        this.messageText = messageText;
        this.timeStamp= LocalDateTime.now();
    }
    public Message(){
        this.timeStamp= LocalDateTime.now();
    }

    public String getAuthor() {
        return author;
    }

    public String getMessageText() {
        return messageText;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}