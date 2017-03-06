package kr.sweetycat.carculator.calculation;

/**
 * Created by Yi on 2017-03-07.
 */

public class CalculationDefine {

    public enum setDivideBracketPosition {
        Header(0),
        Body(1),
        Footer(2);

        private int value;
        private setDivideBracketPosition(int value) {
            this.value = value;
        }
    }

    /**
     * @author -SweetyCat-
     * @since	2014 - 08 - 05
     * @param	instance Singleton Pattern
     */
    private static CalculationDefine instance;
    private boolean	bRequestError;

    public static CalculationDefine ins() {
        if (instance == null) {
            instance = new CalculationDefine();
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
