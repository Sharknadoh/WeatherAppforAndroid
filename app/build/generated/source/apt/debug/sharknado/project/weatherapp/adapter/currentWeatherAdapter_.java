//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package sharknado.project.weatherapp.adapter;

import android.content.Context;

public final class currentWeatherAdapter_
    extends currentWeatherAdapter
{

    private Context context_;

    private currentWeatherAdapter_(Context context) {
        context_ = context;
        init_();
    }

    public static currentWeatherAdapter_ getInstance_(Context context) {
        return new currentWeatherAdapter_(context);
    }

    private void init_() {
        context = context_;
        onAfterInject();
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}
