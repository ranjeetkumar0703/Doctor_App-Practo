package com.practo_Doctor_app.repository;

import com.practo_Doctor_app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Booking,Long> {

}
