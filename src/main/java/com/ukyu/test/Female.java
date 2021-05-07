package com.ukyu.test;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ukyu
 * @date 2021/2/20
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Female extends Person{
    private Boolean isLongHair;

}
