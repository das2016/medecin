package com.rdvmedecin.springdatajpa;

import com.rdvmedecin.dao.CreneauDao;
import com.rdvmedecin.entity.Creneau;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public abstract interface SpringDataCreneauDao
  extends CreneauDao, Repository<Creneau, Long>
{
  @Query("select c from Creneau c where c.medecin.id =:id")
  public abstract List<Creneau> getAllCreneaux(@Param("id") long paramLong);
}
