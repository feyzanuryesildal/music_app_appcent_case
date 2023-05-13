package com.example.music_app_appcent_case.network.model

import com.example.music_app_appcent_case.R

object MockList {

    fun getMockedItemList(): List<ItemModel> {
        val itemModel1 = ItemModel(
            R.drawable.albumkapak,
            "FACEBOOK",
        )
        val itemModel2 = ItemModel(
            R.drawable.albumkapak,
            "INSTAGRAM",
        )
        val itemModel3 = ItemModel(
            R.drawable.albumkapak,
            "WHATSAPP",
        )
        val itemModel4 = ItemModel(
            R.drawable.albumkapak,
            "YOUTUBE",
        )
        val itemModel5 = ItemModel(
            R.drawable.albumkapak,
            "TWITTER",
        )
        val itemModel6 = ItemModel(
            R.drawable.albumkapak,
            "LINKEDIN",
        )
        val itemModel7 = ItemModel(
            R.drawable.albumkapak,
            "SNAPCHAT",
        )
        val itemModel8 = ItemModel(
            R.drawable.albumkapak,
            "SKYPE",
        )

        val itemList: ArrayList<ItemModel> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)
        itemList.add(itemModel5)
        itemList.add(itemModel6)
        itemList.add(itemModel7)
        itemList.add(itemModel8)
        return itemList
    }

}