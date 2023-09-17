package com.example.folkatech

import android.content.Context
import javax.sql.DataSource

object Injection {
    fun provideRepository(): Repository {
        return Repository.getInstance()
    }
}