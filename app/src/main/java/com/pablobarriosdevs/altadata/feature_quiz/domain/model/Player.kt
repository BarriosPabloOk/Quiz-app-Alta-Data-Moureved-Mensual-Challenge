package com.pablobarriosdevs.altadata.feature_quiz.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    val id:Int,
    val name:String,
    val score: Int,
)
