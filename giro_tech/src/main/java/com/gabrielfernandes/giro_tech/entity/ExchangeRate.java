package com.gabrielfernandes.giro_tech.entity;

import java.sql.Date;

public class ExchangeRate {
    private int id;
    private Date date;
    private float daily_variation;
    private float daily_rate;
    private int currency_id;
}
