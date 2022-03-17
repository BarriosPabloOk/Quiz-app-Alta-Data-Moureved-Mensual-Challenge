package com.pablobarriosdevs.altadata.feature_quiz.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey(autoGenerate = true)val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "score") val score: Int,
)
