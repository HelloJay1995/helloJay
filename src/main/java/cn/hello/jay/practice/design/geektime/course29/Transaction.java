package cn.hello.jay.practice.design.geektime.course29;

/**
 * @author 周健以
 * @Date 2020年06月10日
 */
public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

}

enum STATUS {
    TO_BE_EXECUTED,
    EXECUTED,
    EXPIRED,
    FAILED;
}
