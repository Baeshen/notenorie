package notenorie.helper;

import notenorie.layout.ScorePane;

import java.util.HashMap;

public class ScoreHelper {

    private HashMap<Integer, Integer> mClefG;
    private HashMap<Integer, Integer> mClefF;

    public ScoreHelper () {
        mClefG = new HashMap<>();
        mClefF = new HashMap<>();

        init();
    }

    private void init () {
        int[] clefFsteps = {2,2,1,2,2,2,1};

        for (int i = 0, counter = 12; i < 40; ) {
            for (int step : clefFsteps) {
                if (i < 40)
                    mClefF.put(counter, i++);
                counter += step;
            }
        }

        //int[] clefGsteps = {2,1,2,2,1,2,2};
        int[] clefGsteps = {2,2,2,1,2,2,1};

        for (int i = 39, counter = 41; i >= 0; ) {
            for (int step : clefGsteps) {
                if (i >= 0)
                    mClefG.put(counter, i--);
                counter += step;
            }
        }
    }

    public int getNoteScorePosition(int clef, int note) throws NullPointerException{
        switch (clef) {

            case ScorePane.CLEF_G:
                System.out.println("Clef G");
                return mClefG.get(note);

            case ScorePane.CLEF_F:
                System.out.println("Clef F");
                return mClefF.get(note);

            default:
                return 0;
        }
    }
}
