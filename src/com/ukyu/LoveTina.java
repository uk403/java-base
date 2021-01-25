package com.ukyu;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

/**
 * @author ukyu
 * @date 2021/1/20
 **/
public class LoveTina {
    public static void main(String[] args) {
        //猪儿猪儿 do re mi do
        Pattern pattern1 = new Pattern("C5q D5q E5q C5q");

        //我爱你 mi fa so
        Pattern pattern2 = new Pattern("E5q F5q G5h");

        //小仙女小仙女 so la so fa mi do
        Pattern pattern3 = new Pattern("G5i A5i G5i F5i E5q C5q");

        //我爱你 do so do
        Pattern pattern4 = new Pattern("C5q G4q C5h");

        Pattern song = new Pattern();
        song.add(pattern1, 1);
        song.add(pattern2, 2);
        song.add(pattern3, 2);
        song.add(pattern4, 2);

        Player player = new Player();
        player.play(song);
    }
}
