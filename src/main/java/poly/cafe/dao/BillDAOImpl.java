/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao;

import java.util.Date;
import java.util.List;
import poly.cafe.entity.Bill;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class BillDAOImpl implements BillDAO{
    String createSql = "INSERT INTO Bills(Id, Username, CardId, Checkin, Checkout, Status) VALUES(?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Bills SET Username=?, CardId=?, Checkin=?, Checkout=?, Status=? WHERE Id=?";
    String deleteSql = "DELETE FROM Bills WHERE Id=?";
    String findAllSql = "SELECT * FROM Bills";
    String findByIdSql = "SELECT * FROM Bills WHERE Id=?";
    String findByUsernameSql = "SELECT * FROM Bills WHERE Username=?";
    String findByCardIdSql = "SELECT * FROM Bills WHERE CardId=?";
    String findByTimeRangeSql = "SELECT * FROM Bills WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";
    @Override
    public List<Bill> findByUsername(String username) {
        return XQuery.getBeanList(Bill.class, findByUsernameSql, username);    
    }

    @Override
    public List<Bill> findByCardId(Integer cardId) {
        return XQuery.getBeanList(Bill.class, findByCardIdSql, cardId);
    }

    @Override
    public Bill create(Bill entity) {
        Object[] values = {
        entity.getUsername(),
        entity.getId(),
        entity.getCardId(),
        entity.getCheckin(),
        entity.getCheckout(),
        entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Bill entity) {
        Object[] values = {
        
        entity.getUsername(),
        entity.getCardId(),
        entity.getCheckin(),
        entity.getCheckout(),
        entity.getStatus(),
        entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
        
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Bill> findAll() {
    return XQuery.getBeanList(Bill.class, findAllSql);       
    }

    @Override
    public Bill findById(Long id) {
        return XQuery.getSingleBean(Bill.class, findByIdSql, id);  
    }

    @Override
    public List<Bill> findByTimeRange(Date begin, Date end) {
        return XQuery.getBeanList(Bill.class, findByTimeRangeSql, begin, end);
    }
    
}
