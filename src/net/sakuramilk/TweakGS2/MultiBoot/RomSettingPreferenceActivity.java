package net.sakuramilk.TweakGS2.MultiBoot;

import net.sakuramilk.TweakGS2.R;
import net.sakuramilk.TweakGS2.Common.Misc;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class RomSettingPreferenceActivity extends PreferenceActivity
    implements OnPreferenceChangeListener {

    private int mRomId;
    private final MbsConf mMbsConf = new MbsConf();
    
    private static final String KEY_SYSTEM_PART = "rom_system_part_list";
    private static final String KEY_SYSTEM_IMG = "rom_system_img_list";
    private static final String KEY_SYSTEM_PATH = "rom_system_path_list";
    private static final String KEY_DATA_PART = "rom_data_part_list";
    private static final String KEY_DATA_IMG = "rom_data_img_list";
    private static final String KEY_DATA_PATH = "rom_data_path_list";
    
    private ListPreference mSystemPart;
    private ListPreference mSystemImg;
    private ListPreference mSystemPath;
    private ListPreference mDataPart;
    private ListPreference mDataImg;
    private ListPreference mDataPath;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        addPreferencesFromResource(R.xml.rom_setting_pref);
        
        Intent intent = getIntent();
        mRomId = intent.getIntExtra("rom_id", -1);
        if ((0 < mRomId) || (mRomId > MbsConf.MAX_ROM_ID)) {
            finish();
        }
        
        mSystemPart = (ListPreference)findPreference(KEY_SYSTEM_PART);
        mSystemPart.setSummary(Misc.getCurrentValueText(this, mMbsConf.getSystemPartition(mRomId)));
        
        mSystemPart.setOnPreferenceChangeListener(this);
        mSystemImg = (ListPreference)findPreference(KEY_SYSTEM_IMG);
        mSystemImg.setSummary(Misc.getCurrentValueText(this, mMbsConf.getSystemImage(mRomId)));
        mSystemPath = (ListPreference)findPreference(KEY_SYSTEM_PATH);
        mSystemPath.setSummary(Misc.getCurrentValueText(this, mMbsConf.getSystemPath(mRomId)));
        
        mDataPart = (ListPreference)findPreference(KEY_DATA_PART);
        mDataPart.setSummary(Misc.getCurrentValueText(this, mMbsConf.getDataPartition(mRomId)));
        mDataImg = (ListPreference)findPreference(KEY_DATA_IMG);
        mDataImg.setSummary(Misc.getCurrentValueText(this, mMbsConf.getDataImage(mRomId)));
        mDataPath = (ListPreference)findPreference(KEY_DATA_PATH);
        mDataPath.setSummary(Misc.getCurrentValueText(this, mMbsConf.getDataPath(mRomId)));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        String value = objValue.toString();
        if (preference == mSystemPart) {
            mMbsConf.setSystemPartition(mRomId, value);
            mSystemPart.setSummary((Misc.getCurrentValueText(this, value)));
        } else if (preference == mSystemImg) {
            mMbsConf.setSystemImage(mRomId, value);
            mSystemImg.setSummary((Misc.getCurrentValueText(this, value)));
        } else if (preference == mSystemPath) {
            mMbsConf.setDataPath(mRomId, value);
            mSystemPath.setSummary((Misc.getCurrentValueText(this, value)));
        } else if (preference == mDataPart) {
            mMbsConf.setDataPartition(mRomId, value);
            mDataPart.setSummary((Misc.getCurrentValueText(this, value)));
        } else if (preference == mDataImg) {
            mMbsConf.setDataImage(mRomId, value);
            mDataImg.setSummary((Misc.getCurrentValueText(this, value)));
        } else if (preference == mDataPath) {
            mMbsConf.setDataPath(mRomId, value);
            mDataPath.setSummary((Misc.getCurrentValueText(this, value)));
        }
        return false;
    }
}
