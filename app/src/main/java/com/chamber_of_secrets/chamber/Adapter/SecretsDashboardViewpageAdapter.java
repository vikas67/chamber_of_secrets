package com.chamber_of_secrets.chamber.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.chamber_of_secrets.chamber.Fragment.SecretsCallFragment;
import com.chamber_of_secrets.chamber.Fragment.SecretsChatFragment;
import com.chamber_of_secrets.chamber.Fragment.SecretsGroupFragment;
import com.chamber_of_secrets.chamber.Fragment.SecretsStatusFragment;

public class SecretsDashboardViewpageAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public SecretsDashboardViewpageAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Toast.makeText(context, "camera", Toast.LENGTH_SHORT).show();
            case 1:
                SecretsChatFragment secretsChatFragment = new SecretsChatFragment();
                return secretsChatFragment;
            case 2:
                SecretsGroupFragment secretsGroupFragment = new SecretsGroupFragment();
                return secretsGroupFragment;
            case 3:
                SecretsStatusFragment secretsStatusFragment = new SecretsStatusFragment();
                return secretsStatusFragment;
            case 4:
                SecretsCallFragment secretsCallFragment = new SecretsCallFragment();
                return secretsCallFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
