package sharknado.project.weatherapp;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

import java.util.List;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
@SharedPref(value=SharedPref.Scope.UNIQUE)
public interface PrefsShared {

    @DefaultString("")
    String lastSearched0();
    @DefaultString("")
    String lastSearched1();
    @DefaultString("")
    String lastSearched2();
}
