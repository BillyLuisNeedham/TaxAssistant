package com.billyluisneedham.taxassistant.di

import android.app.Application
import com.billyluisneedham.taxassistant.TaxAssistantApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = []
)
interface AppComponent: AndroidInjector<TaxAssistantApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
    
}