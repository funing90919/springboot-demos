package top.os.fun.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Jacky on 2019-01-05 13:46.
 */

@Service
public class ScheduledTaskService {

    /**
     * 需要@EnableScheduling // 开启定时任务
     *
     * second, minute, hour, day of month, month, day of week(1-6周一至周六, 0和7代表周六)
     * eg:
     * 0 * * * * MON-FRI:
     * 0 0/5 14 18 * * ?: 每天14点整，18点整，每隔5分钟执行一次
     * 0 15 10 ? * 1-6: 每个月周一至周六10:15执行一次
     * 0 0 2 ? * 6L: 每个月最后一个周六凌晨2:00执行一次
     * 0 0 2 LW * ?: 每个月最后一个工作日凌晨2:00执行一次
     * 0 0 2-4 ? * 1#1: 每月第一个周一凌晨2点到4点，整点执行
     */
    // @Scheduled(cron = "* * * * * MON-SAT")// 周一到周六每秒执行
    // @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")// 每0,1,2,3,4秒执行
    // @Scheduled(cron = "0-4 * * * * MON-SAT")// 每0至4秒执行
    @Scheduled(cron = "0/5 * * * * MON-SAT")// 0秒启动，每5秒执行一次
    public void schedule() {
        System.out.println("scheduled...");
    }
}
