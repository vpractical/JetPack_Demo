package com.y.jetpack_demo.workmanager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.y.jetpack_demo.R
import kotlinx.android.synthetic.main.activity_workmanager.*
import java.util.concurrent.TimeUnit

/**
 * https://juejin.im/post/5d8c7d9e5188254d8c070a38
 */
class WorkManagerActivity: AppCompatActivity() {

    companion object{
        fun start(context: Context){
            val intent = Intent(context,WorkManagerActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workmanager)

        //一次性的任务
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(Worker1::class.java).build()
        //周期性的任务
        val periodicWorkRequest = PeriodicWorkRequest.Builder(Worker2::class.java,10,TimeUnit.SECONDS).build()
        //任务执行条件约束
//        val constrains = Constraints.Builder()
//                //当本地的contenturi更新时，会触发任务执行（api需大于等于24，配合JobSchedule）
//                .addContentUriTrigger(Uri.EMPTY, true)
//                //当content uri变更时，执行任务的最大延迟，配合JobSchedule
//                .setTriggerContentMaxDelay(10, TimeUnit.SECONDS)
//                //当content uri更新时，执行任务的延迟（api>=26）
//                .setTriggerContentUpdateDelay(100, TimeUnit.SECONDS)
//                //任务的网络状态：无网络要求，有网络连接，不限量网络，非移动网络，按流量计费的网络
//                .setRequiredNetworkType(NetworkType.NOT_ROAMING)
//                //电量足够才能执行
//                .setRequiresBatteryNotLow(true)
//                //充电时才能执行
//                .setRequiresCharging(false)
//                //存储空间足够才能执行
//                .setRequiresStorageNotLow(false)
//                //设备空闲才能执行
//                .setRequiresDeviceIdle(true)
//                .build()

        btn1.setOnClickListener { WorkManager.getInstance().enqueue(oneTimeWorkRequest) }
        btn2.setOnClickListener { WorkManager.getInstance().enqueue(periodicWorkRequest) }
        btn3.setOnClickListener { throw NullPointerException("exit!")}

    }

}