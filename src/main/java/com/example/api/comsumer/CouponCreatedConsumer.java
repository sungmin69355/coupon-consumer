package com.example.api.comsumer;

import com.example.api.domain.Coupon;
import com.example.api.repository.CouponRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    public CouponCreatedConsumer(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {
        couponRepository.save(new Coupon(userId));
    }
}
