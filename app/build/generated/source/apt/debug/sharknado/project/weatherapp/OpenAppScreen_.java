//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package sharknado.project.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;
import sharknado.project.weatherapp.R.id;
import sharknado.project.weatherapp.R.layout;

public final class OpenAppScreen_
    extends OpenAppScreen
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.activity_open_app_screen);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        App = WeatherAppGlobal_.getInstance();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static OpenAppScreen_.IntentBuilder_ intent(Context context) {
        return new OpenAppScreen_.IntentBuilder_(context);
    }

    public static OpenAppScreen_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new OpenAppScreen_.IntentBuilder_(fragment);
    }

    public static OpenAppScreen_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new OpenAppScreen_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        logInButton = ((Button) hasViews.findViewById(id.log_in_button));
        createAccount = ((Button) hasViews.findViewById(id.create_account_button));
        if (createAccount!= null) {
            createAccount.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    OpenAppScreen_.this.createAccount();
                }

            }
            );
        }
        if (logInButton!= null) {
            logInButton.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    OpenAppScreen_.this.login();
                }

            }
            );
        }
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<OpenAppScreen_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, OpenAppScreen_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), OpenAppScreen_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), OpenAppScreen_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode, lastOptions);
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        context.startActivity(intent, lastOptions);
                    }
                }
            }
        }

    }

}