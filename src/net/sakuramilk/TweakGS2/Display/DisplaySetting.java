/*
 * Copyright (C) 2011 sakuramilk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sakuramilk.TweakGS2.Display;

import android.content.Context;
import net.sakuramilk.TweakGS2.Common.SettingManager;
import net.sakuramilk.TweakGS2.Common.SysFs;

public class DisplaySetting extends SettingManager {

    public static final String KEY_LCD_TYPE = "disp_lcd_type";
    public static final String KEY_LCD_GAMMA = "disp_lcd_gamma";
    public static final String KEY_MDNIE_POWER = "disp_mdnie_powor";
    public static final String KEY_MDNIE_FORCE_DISABLE = "disp_mdnie_force_disable";
    public static final String KEY_MDNIE_MODE = "disp_mdnie_mode";
    public static final String KEY_MDNIE_MCM_CB = "disp_mdnie_color_cb";
    public static final String KEY_MDNIE_MCM_CR = "disp_mdnie_color_cr";

    public static final String MDNIE_MCM_ENABLE = "69";
    public static final String MDNIE_MCM_DISABLE = "0";

    private final SysFs mSysFsLcdType = new SysFs("/sys/devices/platform/samsung-pd.2/s3cfb.0/spi_gpio.3/spi3.0/user_lcdtype");
    private final SysFs mSysFsLcdGamma = new SysFs("/sys/devices/platform/samsung-pd.2/s3cfb.0/spi_gpio.3/spi3.0/user_gamma_adjust");
    private final SysFs mSysFsMdniePower = new SysFs("/sys/devices/platform/samsung-pd.2/s3cfb.0/mdnie_power");
    private final SysFs mSysFsMdnieForceDisable = new SysFs("/sys/devices/platform/samsung-pd.2/s3cfb.0/mdnie_force_disable");
    private final SysFs mSysFsMdnieMode = new SysFs("/sys/devices/virtual/mdnieset_ui/switch_mdnieset_ui/mdnieset_user_mode_cmd");
    private final SysFs mSysFsMdnieMcmCb = new SysFs("/sys/devices/virtual/mdnieset_ui/switch_mdnieset_ui/mdnieset_user_mcm_cb_cmd");
    private final SysFs mSysFsMdnieMcmCr = new SysFs("/sys/devices/virtual/mdnieset_ui/switch_mdnieset_ui/mdnieset_user_mcm_cr_cmd");

    public DisplaySetting(Context context) {
        super(context);
    }

    public boolean isEnableMdniePower() {
        return mSysFsMdniePower.exists();
    }

    public String getMdniePower() {
        return mSysFsMdniePower.read();
    }

    public void setMdniePower(String value) {
        mSysFsMdniePower.write(value);
    }

    public String loadMdniePower() {
        return getStringValue(KEY_LCD_TYPE);
    }

    public void saveMdniePower(String value) {
        setValue(KEY_LCD_TYPE, value);
    }

    public boolean isEnableLcdType() {
        return mSysFsLcdType.exists();
    }

    public String getLcdType() {
        return mSysFsLcdType.read();
    }

    public void setLcdType(String value) {
        mSysFsLcdType.write(value);
    }

    public String loadLcdType() {
        return getStringValue(KEY_LCD_TYPE);
    }

    public void saveLcdType(String value) {
        setValue(KEY_LCD_TYPE, value);
    }

    public boolean isEnableLcdGamma() {
        return mSysFsLcdGamma.exists();
    }

    public String getLcdGamma() {
        return mSysFsLcdGamma.read();
    }

    public void setLcdGamma(String value) {
        mSysFsLcdGamma.write(value);
    }

    public String loadLcdGamma() {
        return getStringValue(KEY_LCD_GAMMA);
    }

    public void saveLcdGamma(String value) {
        setValue(KEY_LCD_GAMMA, value);
    }

    public boolean isEnableMdnieForceDisable() {
        return mSysFsMdnieForceDisable.exists();
    }

    public String getMdnieForceDisable() {
        return mSysFsMdnieForceDisable.read();
    }

    public void setMdnieForceDisable(boolean value) {
        mSysFsMdnieForceDisable.write(value ? "0" : "1");
    }

    public boolean loadMdnieForceDisable() {
        return getBoolValue(KEY_MDNIE_FORCE_DISABLE);
    }

    public void saveMdnieForceDisable(boolean value) {
        setValue(KEY_MDNIE_FORCE_DISABLE, value);
    }

    public boolean isEnableMdnieMode() {
        return mSysFsMdnieMode.exists();
    }

    public String getMdnieMode() {
        return mSysFsMdnieMode.read();
    }

    public void setMdnieMode(String value) {
        mSysFsMdnieMode.write(value);
    }

    public String loadMdnieMode() {
        return getStringValue(KEY_MDNIE_MODE);
    }

    public void saveMdnieMode(String value) {
        setValue(KEY_MDNIE_MODE, value);
    }

    public boolean isEnableMdnieMcmCb() {
        return mSysFsMdnieMcmCb.exists();
    }

    public String getMdnieMcmCb() {
        return mSysFsMdnieMcmCb.read();
    }

    public void setMdnieMcmCb(String value) {
        mSysFsMdnieMcmCb.write(value);
    }

    public String loadMdnieMcmCb() {
        return getStringValue(KEY_MDNIE_MCM_CB);
    }

    public void saveMdnieMcmCb(String value) {
        setValue(KEY_MDNIE_MCM_CB, value);
    }

    public boolean isEnableMdnieMcmCr() {
        return mSysFsMdnieMcmCr.exists();
    }

    public String getMdnieMcmCr() {
        return mSysFsMdnieMcmCr.read();
    }

    public void setMdnieMcmCr(String value) {
        mSysFsMdnieMcmCr.write(value);
    }

    public String loadMdnieMcmCr() {
        return getStringValue(KEY_MDNIE_MCM_CR);
    }

    public void saveMdnieMcmCr(String value) {
        setValue(KEY_MDNIE_MCM_CR, value);
    }

    /*
    public final String KEY_MDNIE_DU_CONTROL_ENABLED = "lcdsharpness_du_control";
    public final String FILE_MDNIE_DU_CONTROL_ENABLED = "/sys/devices/virtual/mdnieset_ui/switch_mdnieset_ui/mdnieset_user_de_control_enabled_cmd";
    public boolean isEnableMdnieDuControlEnabled() {
        File file = new File(FILE_MDNIE_DU_CONTROL_ENABLED);
        return file.exists();
    }
    public String loadMdnieDuControlEnabled(Context context) {
        return loadValue(context, KEY_MDNIE_DU_CONTROL_ENABLED);
    }
    public String getCurrentMdnieDuControlEnabled() {
        return getCurrentValue(FILE_MDNIE_DU_CONTROL_ENABLED);
    }
    public void setMdnieDuControlEnabled(String value) {
        setValue(FILE_MDNIE_DU_CONTROL_ENABLED, value);
    }
    
    public static final String KEY_MDNIE_DU_SHARPNESS = "lcdsharpness_du_sharpness";
    public static final String FILE_MDNIE_DU_SHARPNESS = "/sys/devices/virtual/mdnieset_ui/switch_mdnieset_ui/mdnieset_user_de_sharpness_cmd";
    public static boolean isEnableMdnieDuSharpness() {
        File file = new File(FILE_MDNIE_DU_SHARPNESS);
        return file.exists();
    }
    public String loadMdnieDuSharpness(Context context) {
        return loadValue(context, KEY_MDNIE_DU_SHARPNESS);
    }
    public String getCurrentMdnieDuSharpness() {
        return getCurrentValue(FILE_MDNIE_DU_SHARPNESS);
    }
    public void setMdnieDuSharpness(String value) {
        setValue(FILE_MDNIE_DU_SHARPNESS, value);
    }
    
    public void setRecommended(Context context) {
        saveLcdGamma(context, "-2");
        saveMdnieForceDisable(context, true);
    }
    
    public void setInit(Context context) {
        saveLcdGamma(context, "0");
        saveMdnieForceDisable(context, true);
    }
    */

    @Override
    public void setOnBoot() {
        if (isEnableLcdType()) {
            String value = loadLcdType();
            if (value != null) {
                setLcdType(value);
            }
        }
        if (isEnableLcdGamma()) {
            String value = loadLcdType();
            if (value != null) {
                setLcdGamma(value);
            }
        }
        if (isEnableMdnieMcmCb()) {
            String value = loadMdnieMcmCb();
            if (value != null) {
                setMdnieMcmCb(value);
            }
        }
        if (isEnableMdnieMcmCr()) {
            String value = loadMdnieMcmCr();
            if (value != null) {
                setMdnieMcmCr(value);
            }
        }
        if (isEnableMdnieMode()) {
            String value = loadMdnieMode();
            if (value != null) {
                setMdnieMode(value);
            }
        }
        if (isEnableMdnieForceDisable()) {
            boolean value = loadMdnieForceDisable();
            if (value == true) {
                setMdnieForceDisable(true);
            }
        }
    }

    @Override
    public void reset() {
        // TODO 自動生成されたメソッド・スタブ
    }
}
