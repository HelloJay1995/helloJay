package cn.hello.jay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author 周健以
 * @Date 2020年04月28日
 */
public class CreateSql {

    private static final String file = "/Users/hellojay/Desktop/信托计划.txt";

    private static final String sql = "INSERT ignore INTO goods_trust_plan (uid, trust_plan_no, start_time, end_time, trust_plan_start_time, trust_plan_end_time, term, rate, create_time, update_time, repay_date) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', now(), now(), %s);";


    public static void main(String[] args) throws Exception {
        String trustPlanNo = "AMC20200601";
        String startTime = "2020-06-01 00:00:00";
        String endTime = "2020-06-10 20:00:00";
        String trustPlanStartTime = "2020-07-10 00:00:00";
        String trustPlanEndTime = "2021-12-10 23:59:59";

//        String trustPlanNo = "TSX20200528";
//        String startTime = "2020-05-28 00:00:00";
//        String endTime = "2020-05-30 23:59:59";
//        String trustPlanStartTime = "2020-06-20 00:00:00";
//        String trustPlanEndTime = "2021-11-20 23:59:59";



        String term = "18";
        String rate = "0.0225";
        String repayDate = "10";

        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String uid = br.readLine();
        while (uid != null) {
            System.out.println(String.format(sql, uid, trustPlanNo, startTime, endTime, trustPlanStartTime, trustPlanEndTime, term, rate, repayDate));
            uid = br.readLine();
        }

    }
}
