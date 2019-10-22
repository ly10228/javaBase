package com.ly.java8.streamaapi.exer.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 *  * @create 2019-09-18 22:29
 *  * @last modify by [luoyong 2019-09-18 22:29]
 * @Description: ContractOwnerInfoDTO
 **/
@Data
public class ContractOwnerInfoDTO implements Serializable {


    private String name;


    private Long custId;


    private String percentage;

    public ContractOwnerInfoDTO(String name, Long custId, String percentage) {
        this.name = name;
        this.custId = custId;
        this.percentage = percentage;
    }
}
