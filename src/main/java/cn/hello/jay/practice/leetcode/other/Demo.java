package cn.hello.jay.practice.leetcode.other;

/**
 * @author 周健以
 * @Date 2020年06月29日
 */
public class Demo {

//    private static final Logger log = LoggerFactory.getLogger(Demo.class);
//
//    private static ExecutorService pool = new ThreadPoolExecutor(
//            6,
//            10,
//            0L,
//            TimeUnit.MILLISECONDS,
//            new SynchronousQueue<Runnable>());
//
//    // 假设依赖注入
//    private PaymentRemoteSerivce paymentRemoteSerivce;
//
//    /**
//     * 获取可用支付方式列表
//     *
//     * @return
//     */
//    public List<String> queryAvailablePaymentTypeList() {
//        // 假设有六种支付方式
//        int n = 6;
//
//        Map<String, Future<ConsultResult>> futuresMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            Future<ConsultResult> future = pool.submit(new Callable<ConsultResult>() {
//                @Override
//                public ConsultResult call() throws Exception {
//                    return paymentRemoteSerivce.isEnabled(paymentType);
//                }
//            });
//            futuresMap.put(paymentType, future);
//        }
//        List<String> res = new ArrayList<>();
//        for (Map.Entry<String, Future<ConsultResult>> futureEntry : futuresMap.entrySet()) {
//            String paymentType = futureEntry.getKey();
//            Future<ConsultResult> future = futureEntry.getValue();
//
//            ConsultResult consultResult;
//            try {
//                consultResult = future.get();
//            } catch (Exception e) {
//                log.error("查询支付方式是否可用系统异常,paymentType:{}", paymentType, e);
//                continue;
//            }
//            if (consultResult != null && consultResult.getIsEnable()) {
//                res.add(paymentType);
//            } else {
//                log.error("paymentType:{}支付方式不可用,errorCode:{}", paymentType, consultResult == null
//                                                                                     ? "consultResult返回空"
//                                                                                     : consultResult.getErrorCode());
//            }
//        }
//        return res;
//    }
}


class ConsultResult {
    public ConsultResult(boolean isEnable, String errorCode) {
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    /**
     * 咨询结果是否可用
     */
    private boolean isEnable;

    /**
     * 错误码
     */
    private String errorCode;

    public boolean getIsEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }

}