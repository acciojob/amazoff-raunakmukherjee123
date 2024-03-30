package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private HashMap<String, Order> orderMap;
    private HashMap<String, DeliveryPartner> partnerMap;
    private HashMap<String, HashSet<String>> partnerToOrderMap;
    private HashMap<String, String> orderToPartnerMap;

    public OrderRepository(){
        this.orderMap = new HashMap<String, Order>();
        this.partnerMap = new HashMap<String, DeliveryPartner>();
        this.partnerToOrderMap = new HashMap<String, HashSet<String>>();
        this.orderToPartnerMap = new HashMap<String, String>();
    }

    public void saveOrder(Order order){
        String id=order.getId();
        orderMap.put(id,order);
    }

    public void savePartner(String partnerId){
        DeliveryPartner partner=new DeliveryPartner(partnerId);
        partnerMap.put(partnerId,partner);
        partner.setNumberOfOrders(partner.getNumberOfOrders()+1);
        // your code here
        // create a new partner with given partnerId and save it
    }

    public void saveOrderPartnerMap(String orderId, String partnerId){
        HashSet<String> hs=new HashSet();
        if(orderMap.containsKey(orderId) && partnerMap.containsKey(partnerId)){
            // your code here
            //add order to given partner's order list
            //increase order count of partner
            //assign partner to this order
            hs.add(orderId);
            partnerToOrderMap.put(partnerId,hs);
            String s=String.valueOf(Integer.valueOf(orderId)+1);
            orderToPartnerMap.put(s,partnerId);
        }
    }

    public Order findOrderById(String orderId){
        // your code here
        if(!orderMap.containsKey(orderId))
        {
            return null;
        }
        else {
            return orderMap.get(orderId);
        }
    }

    public DeliveryPartner findPartnerById(String partnerId){
        // your code here
        if(!partnerMap.containsKey(partnerId))
        {
            return null;
        }
        else {
           return partnerMap.get(partnerId);
        }
    }

    public Integer findOrderCountByPartnerId(String partnerId){
        int c=0;
        for(String s:orderToPartnerMap.keySet())
        {
            if(orderToPartnerMap.get(s).equals(partnerId))
            {
                c=Integer.valueOf(s);
            }
        }
        return c;
    }

    public List<String> findOrdersByPartnerId(String partnerId){
        // your code here
        List<String> al=new ArrayList<>();
        for(String st:orderToPartnerMap.keySet())
        {
            if(orderToPartnerMap.get(st).equals(partnerId))
            {
                al.add(st);
            }
        }
        return al;
    }

    public List<String> findAllOrders(){
        // your code here
        // return list of all orders
        if(orderMap.size()==0)
        {
            return null;
        }
        List<String> al=new ArrayList<>();
        for(String s:orderMap.keySet())
        {
            al.add(s);
        }
        return al;
    }

    public void deletePartner(String partnerId){
        // your code here
        // delete partner by ID
//        if(partnerMap.containsKey(partnerId))
//        {
//            partnerMap.remove(partnerId);
//        }
        if(partnerToOrderMap.containsKey(partnerId))
        {
            partnerToOrderMap.remove(partnerId);
        }
    }

    public void deleteOrder(String orderId){
        // your code here
        // delete order by ID
//        if(orderMap.containsKey(orderId))
//        {
//            orderMap.remove(orderId);
//        }
        if(orderToPartnerMap.containsKey(orderId))
        {
            orderToPartnerMap.remove(orderId);
        }
    }

    public Integer findCountOfUnassignedOrders(){
        // your code here
        return orderMap.size()-partnerToOrderMap.size();
    }

    public Integer findOrdersLeftAfterGivenTimeByPartnerId(String timeString, String partnerId){
        // your code here
        int c=0;
        return c;
    }

    public String findLastDeliveryTimeByPartnerId(String partnerId){
        // your code here
        // code should return string in format HH:MM
         return "";
    }
}


