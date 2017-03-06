package kr.sweetycat.carculator.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yi on 2017-02-27.
 */

public class Define {

    public String sEquation = "";
    public String sResult = "";
    public boolean bUnsingde = false;
    public List lEquation = new LinkedList();

    /**
     * @author -SweetyCat-
     * @since	2014 - 08 - 05
     * @param	instance Singleton Pattern
     */
    private static Define instance;
    private boolean	bRequestError;

    public static Define ins() {
        if (instance == null) {
            instance = new Define();
        }
        return instance;
    }

    public static void insDestroy() {
        instance = null;
    }

    public void setRequestError(boolean bFlag)
    {
        bRequestError = bFlag;
    }

}
