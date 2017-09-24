package rray.me.androidresume;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by RRay on 9/22/2017.
 */

public class ProjectEditActivity extends EditBaseActivity {

    public static final String KEY_PROJECT = "project";
    public static final String KEY_PROJECT_ID = "project_id";

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void setupUIForCreate() {

    }

    @Override
    protected void setupUIForEdit(@NonNull Object data) {

    }

    @Override
    protected void saveAndExit(@Nullable Object data) {

    }

    @Override
    protected Object initializeData() {
        return null;
    }
}
