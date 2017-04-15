package tgprojects.xyz.starterapplication.views.home;

import android.content.Context;
import com.wealthfront.magellan.Screen;

public class HomeScreen extends Screen<HomeView> {
    @Override protected HomeView createView(Context context) {
        return new HomeView(context);
    }
}
