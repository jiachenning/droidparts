/**
 * Copyright 2012 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.gram.activity;

import static org.droidparts.util.Strings.join;

import org.droidparts.activity.PreferenceFragmentActivity;
import org.droidparts.gram.R;
import org.droidparts.preference.MultiSelectListPreference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

import com.actionbarsherlock.view.MenuItem;

public class SettingsActivity extends PreferenceFragmentActivity implements
		OnPreferenceChangeListener {

	public static Intent getIntent(Context ctx) {
		return new Intent(ctx, SettingsActivity.class);
	}

	private MultiSelectListPreference showDetailPref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		addPreferencesFromResource(R.xml.preferences);
		//
		showDetailPref = (MultiSelectListPreference) findPreference(getString(R.string.pref_show_detail));
		showDetailPref.setOnPreferenceChangeListener(this);
		onPreferenceChange(showDetailPref, null);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onPreferenceChange(Preference pref, Object newValue) {
		if (pref == showDetailPref) {
			pref.setSummary(join(showDetailPref.getCheckedEntries(), ", ", "."));
		}
		return true;
	}
}
