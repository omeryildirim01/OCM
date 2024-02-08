package com.yildirimomer01.ocm.core.util

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.PackageManagerCompat
import com.yildirimomer01.ocm.core.common.Constants.BASE_KEY
import javax.inject.Inject

class OCMKeyProvider @Inject constructor(
    private val context: Context
) : KeyProvider {

    override fun provideOcmKey(): String {
        return runCatching {
            context.packageManager.getApplicationInfo(
                context.packageName,
                PackageManager.GET_META_DATA
            ).metaData.getString(BASE_KEY).toString()
        }.getOrElse { "" }
    }
}