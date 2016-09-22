package org.opendatakit.survey.android.activities;

import android.content.Intent;
import android.net.Uri;

import org.opendatakit.common.android.utilities.ODKFileUtils;

import java.io.File;

/**
 * Created by clarice on 8/19/16.
 */
public class SignatureActivity extends MediaCaptureImageActivity {

  private final static String t = "SignatureActivity";

  @Override
  protected void onResume() {
    launchIntent = new Intent(this, DrawActivity.class);
    launchIntent.putExtra(DrawActivity.OPTION, DrawActivity.OPTION_SIGNATURE);

    // Pass the ref image if we already have an image
    if (savedUri != null) {
      File mediaFile = ODKFileUtils.getRowpathFile(appName, tableId, instanceId, savedUri);
      if (mediaFile.exists()) {
        launchIntent.putExtra(DrawActivity.REF_IMAGE, Uri.fromFile(mediaFile));
      }
    }

    super.onResume();
  }
}
