package model;

public class OrderData {

    private  String name;
    private  String secondName;
    private  String address;
    private  String metroStation;
    private  String phone;
    private  String orderDate ;
    private  String orderTerm;
    private  String samokatColor;
    private  String commentForDelivery;

    public OrderData(String name, String secondName, String address, String metroStation, String phone, String orderDate, String orderTerm, String samokatColor, String commentForDelivery) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.orderDate = orderDate;
        this.orderTerm = orderTerm;
        this.samokatColor = samokatColor;
        this.commentForDelivery = commentForDelivery;
    }

    public  String getName() {
        return name;
    }
    public  String getSecondName() {
        return secondName;
    }
    public String getAddress() {
        return address;
    }
    public  String getMetroStation() {
        return metroStation;
    }
    public  String getPhone() {
        return phone;
    }
    public  String getOrderDate() {
        return orderDate;
    }
    public  String getOrderTerm() {
        return orderTerm;
    }
    public  String getSamokatColor() {
        return samokatColor;
    }
    public  String getCommentForDelivery() { return commentForDelivery; }
}
