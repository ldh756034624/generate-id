package com.ldh.generateid.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Ln
 * @create 2018-09-14:2:13 PM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "id_record")
@Entity
public class IdRecord {

    @Id
    private Long id;

    @Column(name = "version")
    private long version;

    @Column(name = "machine")
    private long machine;

    @Column(name = "sequence")
    private long sequence;

    @Column(name = "date",columnDefinition = "timestamp(6) NOT NULL")
    private Date date;

}
