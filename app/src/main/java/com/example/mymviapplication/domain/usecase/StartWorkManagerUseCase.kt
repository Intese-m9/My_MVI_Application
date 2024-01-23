package com.example.mymviapplication.domain.usecase

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.mymviapplication.domain.work.DemoWorker

class StartWorkManagerUseCase {
    private val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
    private val workName = "DemoWorker"
    fun startWorker(context: Context) {
        val workManager = WorkManager.getInstance(context)
        val workRequest =
            OneTimeWorkRequestBuilder<DemoWorker>().setConstraints(constraints = constraints)
                .build()
        workManager.enqueueUniqueWork(
            workName, ExistingWorkPolicy.REPLACE, workRequest
        )
    }
}