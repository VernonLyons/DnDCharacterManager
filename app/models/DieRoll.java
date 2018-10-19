package models;

import java.util.Random;

public class DieRoll
{
    private int strValue;
    private int dexValue;
    private int conValue;
    private int intValue;
    private int wisValue;
    private int chaValue;
    private int dieRoll;

    public int roll()
    {
        Random random = new Random();
        dieRoll = random.nextInt(6) + 1;
        return dieRoll;
    }

    public int getStrValue()
    {
        DieRoll dieRoll = new DieRoll();
        int dieRollOne = dieRoll.roll();
        int dieRollTwo = dieRoll.roll();
        int dieRollThree = dieRoll.roll();
        int dieRollFour = dieRoll.roll();
        int smallest = Math.min(dieRollOne, Math.min(dieRollTwo, Math.min(dieRollThree, dieRollFour)));

        strValue = (dieRollOne + dieRollTwo + dieRollThree + dieRollFour) - smallest;

        return strValue;
    }

    public int getDexValue()
    {
        DieRoll dieRoll = new DieRoll();
        int dieRollOne = dieRoll.roll();
        int dieRollTwo = dieRoll.roll();
        int dieRollThree = dieRoll.roll();
        int dieRollFour = dieRoll.roll();
        int smallest = Math.min(dieRollOne, Math.min(dieRollTwo, Math.min(dieRollThree, dieRollFour)));

        dexValue = (dieRollOne + dieRollTwo + dieRollThree + dieRollFour) - smallest;

        return dexValue;
    }

    public int getConValue()
    {
        int dieRollOne = roll();
        int dieRollTwo = roll();
        int dieRollThree = roll();
        int dieRollFour = roll();
        int smallest = Math.min(dieRollOne, Math.min(dieRollTwo, Math.min(dieRollThree, dieRollFour)));

        conValue = (dieRollOne + dieRollTwo + dieRollThree + dieRollFour) - smallest;

        return conValue;
    }

    public int getIntValue()
    {
        int dieRollOne = roll();
        int dieRollTwo = roll();
        int dieRollThree = roll();
        int dieRollFour = roll();
        int smallest = Math.min(dieRollOne, Math.min(dieRollTwo, Math.min(dieRollThree, dieRollFour)));

        intValue = (dieRollOne + dieRollTwo + dieRollThree + dieRollFour) - smallest;

        return intValue;
    }

    public int getWisValue()
    {
        int dieRollOne = roll();
        int dieRollTwo = roll();
        int dieRollThree = roll();
        int dieRollFour = roll();
        int smallest = Math.min(dieRollOne, Math.min(dieRollTwo, Math.min(dieRollThree, dieRollFour)));

        wisValue = (dieRollOne + dieRollTwo + dieRollThree + dieRollFour) - smallest;

        return wisValue;
    }

    public int getChaValue()
    {
        int dieRollOne = roll();
        int dieRollTwo = roll();
        int dieRollThree = roll();
        int dieRollFour = roll();
        int smallest = Math.min(dieRollOne, Math.min(dieRollTwo, Math.min(dieRollThree, dieRollFour)));

        chaValue = (dieRollOne + dieRollTwo + dieRollThree + dieRollFour) - smallest;

        return chaValue;
    }
}
