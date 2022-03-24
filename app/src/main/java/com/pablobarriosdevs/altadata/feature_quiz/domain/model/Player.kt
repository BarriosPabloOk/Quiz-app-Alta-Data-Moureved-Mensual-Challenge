package com.pablobarriosdevs.altadata.feature_quiz.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true)val id:Int = 0,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "score") val score: Int,
)
