package com.pablobarriosdevs.altadata.feature_quiz.data.local

import androidx.room.Dao
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz

@Dao
interface PlayerDao {

    suspend fun savePlayer(name:String, score: Int)

    suspend fun getPlayers() : List<Player>?

}