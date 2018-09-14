package com.ldh.generateid.rep;

import com.ldh.generateid.entity.IdRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ln
 * @create 2018-09-14:2:56 PM
 **/
@Repository
public interface IdRecordRep extends CrudRepository<IdRecord,Long>{
}
