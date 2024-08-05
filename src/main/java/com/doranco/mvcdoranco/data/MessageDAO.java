package com.doranco.mvcdoranco.data;

import com.doranco.mvcdoranco.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageDAO extends JpaRepository<Message, Long> {

}
