package com.justdoit.demo.di.component;

import com.justdoit.elementlibrary.di.component.AppComponent;
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import com.justdoit.demo.di.module.MainModule;
import com.justdoit.demo.mvp.ui.activity.MainActivity;
import com.justdoit.demo.mvp.ui.fragment.MainFragment;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);

    void inject(MainFragment fragment);
}