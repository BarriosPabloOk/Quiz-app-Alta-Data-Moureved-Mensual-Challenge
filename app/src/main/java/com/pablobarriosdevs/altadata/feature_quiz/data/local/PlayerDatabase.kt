package com.pablobarriosdevs.altadata.feature_quiz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player

@Database(
    entities = [Player::class],
    version = 1,
    exportSchema = false,
)
abstract class PlayerDatabase :RoomDatabase() {
    abstract val dao: PlayerDao

    companion object{
        const val DATABASE_NAME = "player_db"
    }
}