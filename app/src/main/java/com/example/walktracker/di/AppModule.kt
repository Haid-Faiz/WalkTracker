package com.example.walktracker.di

import android.content.Context
import androidx.room.Room
import com.example.walktracker.db.RunDatabase
import com.example.walktracker.utils.Constants.APP_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

// Now this module will get installed in ApplicationComponent... means dependencies (vars/objects) will
// be created & destroyed only once during start & closing of our app {Lifecycle of application}
// `[created in onCreate() of Application class]`
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    // In Modules we setup the recipes of our dependencies that we need to
    // inject in our classes or in other dependencies


    @Provides  // Now it can be used to inject in classes/other dependencies
    @Singleton  // It will make sure of having singleton instance
    fun provideRunDatabase(
        @ApplicationContext app: Context   // Dagger will insert the application context now
    ): RunDatabase = Room.databaseBuilder(
        app,
        RunDatabase::class.java,
        APP_DATABASE_NAME
    ).build()


    @Provides
    @Singleton
    fun providesRunDao(
        db: RunDatabase  // We don't need to inject it, dagger will automatically recognize how to create
                         // this db as we have already given it the recipe of the RunDatabase
    ) = db.getRunDao()

    // In provide fun when we pass such a param which was already created as a @Provides fun then we
    // don't need to inject it.... dagger will automatically take care of it.


    // NOTE: We don't need to call all these funs... these will be called by dagger itself in auto
    // generated dagger classes
}