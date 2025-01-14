package com.example.santa.register.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Service
public class TransitScheduler {

    // application.properties에서 변수 읽기
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    // 매일 오전 10시에 실행
    @Scheduled(cron = "0 0 10 * * *") // 초, 분, 시, 일, 월, 요일
    public void updateTransitStatus() {
        String query = "UPDATE Transit SET status = '배송중' WHERE status = '배송승인'";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            int updatedRows = preparedStatement.executeUpdate();
            System.out.println("배송 상태가 '배송중'으로 업데이트되었습니다: " + updatedRows + "건");

        } catch (Exception e) {
            System.err.println("배송 상태 업데이트 중 오류 발생: " + e.getMessage());
        }
    }
}
