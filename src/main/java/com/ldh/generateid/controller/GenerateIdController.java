package com.ldh.generateid.controller;

import com.ldh.generateid.entity.IdRecord;
import com.ldh.generateid.rep.IdRecordRep;
import com.ldh.generateid.service.GenerateIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ln
 * @create 2018-09-14:2:46 PM
 **/
@RestController
public class GenerateIdController {

    @Resource
    private GenerateIdService generateIdService;

    @Resource
    private IdRecordRep idRecordRep;

    @RequestMapping(method = RequestMethod.GET,path = "/generate")
    public IdRecord generate(){
        long id = generateIdService.nextId();

        long sequence = generateIdService.getsequence(id);
        long machine = generateIdService.getMachine(id);
        Date date = generateIdService.getDate(id);

        long version = generateIdService.getVersion(id);
        IdRecord idRecord = new IdRecord(id,version,machine,sequence,date);
        idRecordRep.save(idRecord);
        return idRecord;

    }
}
