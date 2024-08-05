package com.doranco.mvcdoranco.controller;
import com.doranco.mvcdoranco.data.MessageDAO;
import com.doranco.mvcdoranco.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/messagerie")
public class MessageController {
    @Autowired
    private MessageDAO messageDAO;
    @GetMapping("/msg")
    public String showMessage(Model model){
        System.out.println("in get mapping");

        model.addAttribute( "messageList", messageDAO.findAll());
        model.addAttribute( "message", new Message());
        return "Messagerie";

    }

    @PostMapping("/msg")
    public String postMessage(@ModelAttribute Message newMessage){
        System.out.println("in postmapping");
        Message msgDAO = new Message(newMessage.getAuthor(), newMessage.getMessageText());
        messageDAO.save(msgDAO);
        return "redirect:/messagerie/msg"; // Redirection absolue
    }

    }
