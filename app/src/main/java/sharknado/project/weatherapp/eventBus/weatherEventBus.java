package sharknado.project.weatherapp.eventBus;

import com.squareup.otto.Bus;

import org.androidannotations.annotations.EBean;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
@EBean(scope = EBean.Scope.Singleton)
public class weatherEventBus extends Bus {


}
