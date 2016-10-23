package com.rdvmedecin.springdatajpa;

import com.rdvmedecin.dao.RvDao;
import com.rdvmedecin.entity.Rv;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
/**
 * 
 * @author SKAN
 *
 */
public abstract interface SpringDataRvDao extends RvDao, Repository<Rv, Long>
{
  @Query("select rv from Rv rv left join fetch rv.client c left join fetch rv.creneau cr where cr.medecin.id=:id and rv.jour=:jour")
  public abstract List<Rv> getRvMedecinJour(@Param("id") long paramLong, @Param("jour") Date paramDate);
}
