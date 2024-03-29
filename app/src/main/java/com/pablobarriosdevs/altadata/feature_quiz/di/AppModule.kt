package com.pablobarriosdevs.altadata.feature_quiz.di

import android.app.Application
import androidx.room.Room
import com.pablobarriosdevs.altadata.feature_quiz.data.local.PlayerDatabase
import com.pablobarriosdevs.altadata.feature_quiz.data.provider.QuizProvider
import com.pablobarriosdevs.altadata.feature_quiz.data.repoitory.QuizRepositoryImpl
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.GetPlayerWithHighScoreUC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.GetSingleQuestionUC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.SaveNewPlayerUC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
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
    fun provideQuizProvider():QuizProvider = QuizProvider()

    @Provides
    @Singleton
    fun providesRepository(db:PlayerDatabase, provider:QuizProvider): QuizRepository{
        return QuizRepositoryImpl(db.dao, provider = provider)
    }

    @Provides
    @Singleton
    fun providesQuizUseWrapper(repo: QuizRepository): UseCases{
        return UseCases(
            getPlayers = GetPlayerWithHighScoreUC(repo),
            getSingleQuestion = GetSingleQuestionUC(repo),
            saveNewPlayer = SaveNewPlayerUC(repo),
        )
    }
}
















