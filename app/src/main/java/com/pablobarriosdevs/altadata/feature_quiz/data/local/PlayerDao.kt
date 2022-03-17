package com.pablobarriosdevs.altadata.feature_quiz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlayer(name:String, score: Int)

    @Query("SELECT * FROM player")
    suspend fun getPlayers() : Flow<List<Player>>

}