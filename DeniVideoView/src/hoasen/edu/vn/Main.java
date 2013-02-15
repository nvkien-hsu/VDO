package hoasen.edu.vn;

import ru.denivip.android.video.MediaController;
import ru.denivip.android.video.VideoView;
import hoasen.edu.vn.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

public class Main extends Activity {

	//private static final String TEST_STREAM_LOCAL = "http://local/PR243467.mp4";

	private static final String TEST_STREAM_REMOTE = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

	private VideoView mVideo;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mVideo = (VideoView) findViewById(R.id.videoView);
		mVideo.requestFocus();

		MediaController controller = new MediaController(Main.this);

		mVideo.setMediaController(controller);
		mVideo.setVideoURI(Uri.parse(TEST_STREAM_REMOTE));
		mVideo.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mVideo.suspend();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mVideo.resume();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
}
