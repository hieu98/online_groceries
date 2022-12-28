package com.hdt.onlinegroceries.ui.shop

import android.app.Application
import com.hdt.onlinegroceries.base.ui.BaseViewModel
import com.hdt.onlinegroceries.utils.SharePreference

class ShopViewModel(
    override val app: Application,
    private val sharePreference: SharePreference
) : BaseViewModel(app) {

}