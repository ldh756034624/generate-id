package com.ldh.generateid.service;

import java.util.Date;

/**
 * 解析id
 */
public interface Decode {

    /** 生成时间
     * @param id  id
     * @return Date 生成的时间
     */
    Date getDate(long id);

    /**
     * 生成id 的机器
     * @param id
     * @return
     */
    long getMachine(long id);

    /**
     * id 的版本
     * @param id
     * @return
     */
    long getVersion(long id);

    /**
     * 序列号
     * @param id
     * @return
     */
    long getsequence(long id);
}
