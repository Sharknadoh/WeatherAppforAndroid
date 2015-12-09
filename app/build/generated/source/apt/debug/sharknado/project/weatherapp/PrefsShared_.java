//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package sharknado.project.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;
import org.androidannotations.api.sharedpreferences.StringPrefEditorField;
import org.androidannotations.api.sharedpreferences.StringPrefField;

public final class PrefsShared_
    extends SharedPreferencesHelper
{


    public PrefsShared_(Context context) {
        super(context.getSharedPreferences("PrefsShared", 0));
    }

    public PrefsShared_.PrefsSharedEditor_ edit() {
        return new PrefsShared_.PrefsSharedEditor_(getSharedPreferences());
    }

    public StringPrefField lastSearched0() {
        return stringField("lastSearched0", "");
    }

    public StringPrefField lastSearched1() {
        return stringField("lastSearched1", "");
    }

    public StringPrefField lastSearched2() {
        return stringField("lastSearched2", "");
    }

    public final static class PrefsSharedEditor_
        extends EditorHelper<PrefsShared_.PrefsSharedEditor_>
    {


        PrefsSharedEditor_(SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }

        public StringPrefEditorField<PrefsShared_.PrefsSharedEditor_> lastSearched0() {
            return stringField("lastSearched0");
        }

        public StringPrefEditorField<PrefsShared_.PrefsSharedEditor_> lastSearched1() {
            return stringField("lastSearched1");
        }

        public StringPrefEditorField<PrefsShared_.PrefsSharedEditor_> lastSearched2() {
            return stringField("lastSearched2");
        }

    }

}
