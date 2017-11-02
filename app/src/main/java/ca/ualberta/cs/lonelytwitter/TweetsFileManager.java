package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import ca.ualberta.cs.lonelytweet.NormalLonelyTweet;

public class TweetsFileManager {

    // Add final modifier to context
	private final Context ctx;
	private static final String fileName = "file.sav";

	public TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public List<NormalLonelyTweet> loadTweets() {
        // Replace explicit type with <>
		List<NormalLonelyTweet> tweets = new ArrayList<>();

		try {
			FileInputStream fis = ctx.openFileInput(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();

			if (o instanceof ArrayList) {
				tweets = (ArrayList<NormalLonelyTweet>) o;
			} else {
				Log.i("LonelyTwitter", "Error casting");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	public void saveTweets(List<NormalLonelyTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput("file.sav", 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(tweets);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}