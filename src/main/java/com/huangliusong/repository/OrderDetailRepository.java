package com.huangliusong.repository;

import com.huangliusong.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huangliusong on 2017/8/9.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderId);
}
