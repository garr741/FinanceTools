package tgprojects.xyz.starterapplication.views.home;

import android.content.Context;
import com.wealthfront.magellan.BaseScreenView;
import tgprojects.xyz.starterapplication.R;

public class HomeView extends BaseScreenView<HomeScreen> {

    public HomeView(Context context) {
        super(context);
        inflate(context, R.layout.home_screen, this);
    }
}
