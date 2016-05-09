package br.com.dkprojectsandroid.daisukianime;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Audry Martins on 08/05/2016.
 */
public class AnimeAPP extends Application
{
    EventBus mEventBus;

    @Override public void onCreate()
    {
        super.onCreate();

        mEventBus = new EventBus();
    }

    public EventBus getmEventBus()
    {
        return mEventBus;
    }

    public void setmEventBus(EventBus mEventBus)
    {
        this.mEventBus = mEventBus;
    }
}
