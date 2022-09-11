package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

public class Order {
    String id;
    String date;
    String status;
    String creatorEmail;
    BigDecimal totalCost;
    BigDecimal totalPurchaseCost;
    private LinkedHashMap<Product, Integer> orderList;

    public Order(String id, String creatorEmail) {
        DateTimeFormatter timeStampFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.id = id;
        this.date = LocalDateTime.now().format(timeStampFormat);
        this.status = "Новый заказ";
        this.creatorEmail = creatorEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public LinkedHashMap<Product, Integer> getOrderList() {
        return orderList;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalPurchaseCost(BigDecimal totalPurchaseCost) {
        this.totalPurchaseCost = totalPurchaseCost;
    }


}
