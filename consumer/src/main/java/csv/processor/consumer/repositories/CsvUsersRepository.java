package csv.processor.consumer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import csv.processor.consumer.entities.CsvUsersEntity;

public interface CsvUsersRepository extends JpaRepository<CsvUsersEntity, Long>{

}
