package com.example.mail_sender_ms.repository;


import com.example.mail_sender_ms.models.MailsModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
//@EnableJpaRepositories
public interface MailRepository extends JpaRepository<MailsModel, Long> {


}
