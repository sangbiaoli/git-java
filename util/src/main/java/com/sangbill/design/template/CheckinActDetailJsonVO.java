package com.sangbill.design.template;

import lombok.Data;

@Data
public class CheckinActDetailJsonVO {
    private long actMinTime;
    private long actMaxTime;
    private String actAddress;
    private String actTimeRanage;
    private int actIntegral;
}
