package com.pablobarriosdevs.altadata.feature_quiz.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pablobarriosdevs.altadata.feature_quiz.data.local.PlayerDao
import com.pablobarriosdevs.altadata.feature_quiz.data.local.PlayerDatabase
import com.pablobarriosdevs.altadata.feature_quiz.data.provider.QuizProvider
import com.pablobarriosdevs.altadata.feature_quiz.data.repoitory.QuizRepositoryImpl
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDataBase(app:Application): PlayerDatabase{
        return Room.databaseBuilder(
            app,
            PlayerDatabase::class.java,
            PlayerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesRepository(dao:PlayerDao, provider:QuizProvider): QuizRepositoryImpl{
        return QuizRepositoryImpl(dao = dao, provider = provider)
    }
}
















